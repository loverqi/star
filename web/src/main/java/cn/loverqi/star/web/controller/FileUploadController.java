package cn.loverqi.star.web.controller;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.loverqi.star.core.bean.ResponseData;
import cn.loverqi.star.core.security.util.SecurityUtil;
import cn.loverqi.star.core.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 文件上传
 * @author LoverQi
 * @date 2018年3月28日
 */
@RestController
@Api(tags = "文件上传")
@RequestMapping("file")
public class FileUploadController {

    @ApiOperation(value = "上传图片", notes = "文件上传，code为0是成功")
    @RequestMapping(value = "/uploadImg.do", method = RequestMethod.POST, headers = ("content-type=multipart/*"), consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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
