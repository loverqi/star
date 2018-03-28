package cn.loverqi.star.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.loverqi.star.core.bean.ResponseDate;
import cn.loverqi.star.core.bean.ResponseDateCode;
import cn.loverqi.star.core.mybaties.pojo.Example;
import cn.loverqi.star.core.utils.PasswordEncoder;
import cn.loverqi.star.core.utils.StringUtil;
import cn.loverqi.star.domain.UserInfo;
import cn.loverqi.star.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理
 * @author LoverQi
 * @date 2018年3月5日
 */
@RestController
@RequestMapping("user")
@Api(value = "用户管理", tags = "user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "新建或者修改用户", notes = "新建或者修改用户,有id时为修改，无id时为新建，code为0是成功")
    @RequestMapping(value = "/AddOrModifyUser.do", method = { RequestMethod.POST })
    public ResponseDate<Boolean> AddOrModifyUser(@RequestBody UserInfo user) {

        ResponseDate<Boolean> responseDate = new ResponseDate<Boolean>();

        if (StringUtil.isNotNull(user.getPassword())) {
            user.setPassword(PasswordEncoder.encode(user.getPassword()));
        }

        int insert = 0;
        if (user.getId() != null) {
            insert = userInfoService.updateByPrimaryKeySelective(user);
            responseDate.setData(insert > 0);
        } else {
            Example example = new Example();
            example.createCriteria().andFieldEqualTo("username", user.getUsername());
            List<UserInfo> userInfos = userInfoService.selectByExample(user, example);
            if (userInfos == null || userInfos.size() <= 0) {
                insert = userInfoService.insertSelective(user);
                responseDate.setData(insert > 0);
            } else {
                responseDate.setCode(ResponseDateCode.FIND_USER_ERROR);
                responseDate.setMessage(ResponseDateCode.FIND_USER_MESSAGE);
            }

        }

        return responseDate;
    }

    /**
     * 用户修改密码
     * @return ResponseDate<String>
     */
    @ApiOperation(value = "用户修改密码", notes = "用户修改密码的申请，code为0是成功成功")
    @RequestMapping(value = "/changePwd.do", method = { RequestMethod.POST })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, dataType = "String", paramType = "form"), })
    public ResponseDate<String> changePwd(String username, String oldPassword, String newPassword) {
        ResponseDate<String> responseDate = new ResponseDate<String>();
        UserInfo userInfo = new UserInfo();
        Example example = new Example();
        example.createCriteria().andFieldEqualTo("username", username);
        List<UserInfo> userInfos = userInfoService.selectByExample(userInfo, example);
        if (userInfos == null || userInfos.size() <= 0) {
            //未找到用户
            responseDate.setCode(ResponseDateCode.NOT_FIND_USER_ERROR);
            responseDate.setMessage(ResponseDateCode.USERNAME_OR_PASSWORD_ERROR_MESSAGE);
        } else {

            userInfo = userInfos.get(0);
            boolean matches = PasswordEncoder.matches(oldPassword, userInfo.getPassword());

            if (!matches) {
                //密码错误
                responseDate.setCode(ResponseDateCode.PASSWORD_ERROR);
                responseDate.setMessage(ResponseDateCode.PASSWORD_ERROR_MESSAGE);
            } else {
                //开始修改密码
                userInfo.setPassword(PasswordEncoder.encode(newPassword));
                userInfoService.updateByPrimaryKeySelective(userInfo);
            }
        }

        return responseDate;
    }

    @ApiOperation(value = "查询用户列表", notes = "根据查询用户列表，code为0是成功")
    @RequestMapping(value = "/getUsers.do", method = { RequestMethod.POST })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = false, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "role", value = "权限", required = false, dataType = "String", paramType = "form"), })
    public ResponseDate<List<UserInfo>> getUsers(String username, String role) {
        ResponseDate<List<UserInfo>> responseDate = new ResponseDate<List<UserInfo>>();
        Example example = new Example();

        if (StringUtil.isNotNull(username)) {
            example.createCriteria().andFieldLike("username", "%" + username + "%");
        }
        if (StringUtil.isNotNull(role)) {
            example.createCriteria().andFieldLike("role", "%" + role + "%");
        }

        UserInfo userInfo = new UserInfo();
        List<UserInfo> userInfos = userInfoService.selectByExample(userInfo, example);

        responseDate.setData(userInfos);

        return responseDate;
    }

    @ApiOperation(value = "根据id删除用戶", notes = "根据id刪除用户，code为0是成功")
    @RequestMapping(value = "/deleteUser.do", method = { RequestMethod.POST })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "岗位的id", required = true, dataType = "int", paramType = "form"), })
    public ResponseDate<Boolean> deleteUser(Integer id) {
        ResponseDate<Boolean> responseDate = new ResponseDate<Boolean>();
        if (id == null) {
            responseDate.setCode(ResponseDateCode.PARAMETER_ANOMALY);
            responseDate.setMessage(ResponseDateCode.PARAMETER_ANOMALY_MESSAGE);
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(id);
            int deleteByPrimaryKey = userInfoService.deleteByPrimaryKey(userInfo);

            responseDate.setData(deleteByPrimaryKey > 0);
        }

        return responseDate;
    }

    @ApiOperation(value = "根据id删除用戶", notes = "根据id删除用戶，code为0是成功")
    @RequestMapping(value = "/deleteUsers.do", method = { RequestMethod.POST })
    public ResponseDate<Boolean> deleteUsers(@RequestBody List<Integer> ids) {
        ResponseDate<Boolean> responseDate = new ResponseDate<Boolean>();
        if (ids == null || ids.size() == 0) {
            responseDate.setCode(ResponseDateCode.PARAMETER_ANOMALY);
            responseDate.setMessage(ResponseDateCode.PARAMETER_ANOMALY_MESSAGE);
        } else {
            UserInfo userInfo = new UserInfo();
            Example example = new Example();
            example.createCriteria().andFieldIn("id", ids);
            int deleteByPrimaryKey = userInfoService.deleteByExample(userInfo, example);

            responseDate.setData(deleteByPrimaryKey > 0);
        }

        return responseDate;
    }

}
