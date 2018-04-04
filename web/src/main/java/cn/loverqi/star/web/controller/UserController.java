package cn.loverqi.star.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.loverqi.star.core.bean.ResponseData;
import cn.loverqi.star.core.bean.ResponseDataCode;
import cn.loverqi.star.core.bean.ResponsePageData;
import cn.loverqi.star.core.mybaties.pojo.Example;
import cn.loverqi.star.core.utils.StringUtil;
import cn.loverqi.star.domain.UserInfo;
import cn.loverqi.star.service.UserInfoService;
import cn.loverqi.star.web.controller.param.UserInfoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理
 * @author LoverQi
 * @date 2018年3月5日
 */
@Controller
@RequestMapping("user")
@Api(value = "用户管理", tags = "user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation(value = "新建或者修改用户", notes = "新建或者修改用户,有id时为修改，无id时为新建，code为0是成功")
    @RequestMapping(value = "/AddOrModifyUser.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData<Boolean> AddOrModifyUser(@ModelAttribute UserInfo user) {

        ResponseData<Boolean> responseDate = new ResponseData<Boolean>();

        if (StringUtil.isNotNull(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
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
                user.setCreateDate(new Date());
                if (StringUtil.isNull(user.getRole())) {
                    user.setRole("USER");
                }
                insert = userInfoService.insertSelective(user);
                responseDate.setData(insert > 0);
            } else {
                responseDate.setCode(ResponseDataCode.FIND_USER_ERROR);
                responseDate.setMessage(ResponseDataCode.FIND_USER_MESSAGE);
            }
        }

        return responseDate;
    }

    /**
     * 用户修改密码
     * @return ResponseDate<String>
     */
    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "用户修改密码", notes = "用户修改密码的申请，code为0是成功成功")
    @RequestMapping(value = "/changePwd.do", method = { RequestMethod.POST })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, dataType = "String", paramType = "form"), })
    public @ResponseBody ResponseData<String> changePwd(String username, String oldPassword, String newPassword) {
        ResponseData<String> responseDate = new ResponseData<String>();
        UserInfo userInfo = new UserInfo();
        Example example = new Example();
        example.createCriteria().andFieldEqualTo("username", username);
        List<UserInfo> userInfos = userInfoService.selectByExample(userInfo, example);
        if (userInfos == null || userInfos.size() <= 0) {
            //未找到用户
            responseDate.setCode(ResponseDataCode.NOT_FIND_USER_ERROR);
            responseDate.setMessage(ResponseDataCode.USERNAME_OR_PASSWORD_ERROR_MESSAGE);
        } else {

            userInfo = userInfos.get(0);
            boolean matches = passwordEncoder.matches(oldPassword, userInfo.getPassword());

            if (!matches) {
                //密码错误
                responseDate.setCode(ResponseDataCode.PASSWORD_ERROR);
                responseDate.setMessage(ResponseDataCode.PASSWORD_ERROR_MESSAGE);
            } else {
                //开始修改密码
                userInfo.setPassword(passwordEncoder.encode(newPassword));
                userInfoService.updateByPrimaryKeySelective(userInfo);
            }
        }

        return responseDate;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "查询用户列表", notes = "根据查询用户列表，code为0是成功")
    @RequestMapping(value = "/getUsers.do", method = { RequestMethod.POST })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = false, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "role", value = "权限", required = false, dataType = "String", paramType = "form"), })
    public @ResponseBody ResponseData<List<UserInfo>> getUsers(String username, String role) {
        ResponseData<List<UserInfo>> responseDate = new ResponseData<List<UserInfo>>();
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

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "根据id删除用戶", notes = "根据id刪除用户，code为0是成功")
    @RequestMapping(value = "/deleteUser.do", method = { RequestMethod.POST })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "岗位的id", required = true, dataType = "int", paramType = "form"), })
    public @ResponseBody ResponseData<Boolean> deleteUser(Integer id) {
        ResponseData<Boolean> responseDate = new ResponseData<Boolean>();
        if (id == null) {
            responseDate.setCode(ResponseDataCode.PARAMETER_ANOMALY);
            responseDate.setMessage(ResponseDataCode.PARAMETER_ANOMALY_MESSAGE);
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(id);
            int deleteByPrimaryKey = userInfoService.deleteByPrimaryKey(userInfo);

            responseDate.setData(deleteByPrimaryKey > 0);
        }

        return responseDate;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "根据id删除用戶", notes = "根据id删除用戶，code为0是成功")
    @RequestMapping(value = "/deleteUsers.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData<Boolean> deleteUsers(@RequestBody List<Integer> ids) {
        ResponseData<Boolean> responseDate = new ResponseData<Boolean>();
        if (ids == null || ids.size() == 0) {
            responseDate.setCode(ResponseDataCode.PARAMETER_ANOMALY);
            responseDate.setMessage(ResponseDataCode.PARAMETER_ANOMALY_MESSAGE);
        } else {
            UserInfo userInfo = new UserInfo();
            Example example = new Example();
            example.createCriteria().andFieldIn("id", ids);
            int deleteByPrimaryKey = userInfoService.deleteByExample(userInfo, example);

            responseDate.setData(deleteByPrimaryKey > 0);
        }

        return responseDate;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/create_user.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String createUser(Model model) {

        UserInfo userInfo = new UserInfo();
        model.addAttribute("user", userInfo);
        model.addAttribute("type", "create");

        return "create_user";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/edit_user.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String editUser(Integer id, Model model) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo = userInfoService.selectByPrimaryKey(userInfo);
        if (userInfo == null) {
            userInfo = new UserInfo();
        }

        model.addAttribute("user", userInfo);
        model.addAttribute("type", "edit");
        return "create_user";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user_details.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String userDetails(Integer id, Model model) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo = userInfoService.selectByPrimaryKey(userInfo);
        if (userInfo == null) {
            userInfo = new UserInfo();
        }

        model.addAttribute("user", userInfo);
        model.addAttribute("type", "view");
        return "create_user";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/view_user.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String viewUser(@ModelAttribute UserInfoParam param, Model model) {

        if (param == null) {
            param = new UserInfoParam();
        }
        Example example = new Example();
        if (StringUtil.isNotNull(param.getUsername())) {
            example.createCriteria().andFieldLike("username", "%" + param.getUsername() + "%");
        }
        if (StringUtil.isNotNull(param.getName())) {
            example.createCriteria().andFieldLike("name", "%" + param.getName() + "%");
        }
        if (StringUtil.isNotNull(param.getRole())) {
            example.createCriteria().andFieldEqualTo("role", param.getRole());
        }
        if (param.getPage() == null) {
            param.setPage(1);
        }
        if (param.getPageSize() == null) {
            param.setPageSize(10);
        }

        UserInfo userInfo = new UserInfo();
        ResponsePageData<UserInfo> datas = userInfoService.selectByExampleWithRowbounds(userInfo, example,
                param.getPage(), param.getPageSize());

        model.addAttribute("param", param);
        model.addAttribute("datas", datas);
        return "view_user";
    }

}
