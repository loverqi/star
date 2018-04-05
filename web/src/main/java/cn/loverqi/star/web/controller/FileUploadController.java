package cn.loverqi.star.web.controller;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.loverqi.star.core.bean.ResponseData;
import cn.loverqi.star.core.utils.FileUtil;
import cn.loverqi.star.web.security.util.SecurityUtil;
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
    @RequestMapping(value = "/uploadFile.do", method = RequestMethod.POST, headers = ("content-type=multipart/*"), consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "file", paramType = "form"), })
    public ResponseData<String> uploadImg(MultipartFile file) {
        ResponseData<String> responseDate = new ResponseData<String>();
        String[] split = file.getOriginalFilename().split("\\.");
        String name = "img_" + SecurityUtil.getUser().getId() + "_" + UUID.randomUUID().toString() + "."
                + split[split.length - 1];
        FileUtil.uploadFile(name, file);

        responseDate.setData(name);
        return responseDate;
    }

}
