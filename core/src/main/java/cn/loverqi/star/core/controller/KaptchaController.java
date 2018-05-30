package cn.loverqi.star.core.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Producer;

import cn.loverqi.star.core.utils.ConstantUtil;
import io.swagger.annotations.Api;

/**
 * 验证码的获取
 * @author LoverQi
 * @date 2018年3月28日
 */
@Controller
@Api(tags = "获取验证码")
@RequestMapping("/")
public class KaptchaController {

    @Autowired
    private Producer producer;

    @GetMapping("/getKaptchaImg.do")
    public void getKaptchaImg(HttpServletResponse response, HttpSession session) throws IOException {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capText = producer.createText();
        BufferedImage bufferedImage = producer.createImage(capText);
        //将验证码存到session
        session.setAttribute(ConstantUtil.KAPTCHA_SESSION_KEY, capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bufferedImage, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

}
