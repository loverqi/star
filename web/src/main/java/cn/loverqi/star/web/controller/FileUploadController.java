package cn.loverqi.star.web.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.loverqi.star.core.bean.ResponseDate;
import cn.loverqi.star.core.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 文件上传的测试类
 * @author LoverQi
 * @date 2018年3月28日
 */
@RestController
@RequestMapping("file")
@PreAuthorize("hasRole('USER')")
@Api(value = "文件上传", tags = "file")
public class FileUploadController {

    @ApiOperation(value = "文件上传测试", notes = "文件上传测试，code为0是成功")
    @RequestMapping(value = "/uploadtest", method = RequestMethod.POST, headers = ("content-type=multipart/*"), consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "string", paramType = "form"),
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "file", paramType = "form"), })
    public ResponseDate<String> uploadImg(String name, MultipartFile file) {
        ResponseDate<String> responseDate = new ResponseDate<String>();
        FileUtil.uploadFile(name, file);

        System.err.println(FileUtil.getClassPath());

        return responseDate;
    }

}
