package com.example.mysecurity.controller;

import cn.hutool.core.codec.Base64;
import com.example.mysecurity.annotation.UsualApi;
import com.example.mysecurity.common.ImageVerificationCode;
import com.example.mysecurity.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("common")
public class CommonController {

    /**
     * @param selectIds
     * @return
     */
    @GetMapping("getSelectIds")
    public Result<String> getSelectIds(String selectIds) {
        return Result.success(selectIds);
    }


    @GetMapping("getVerifiCode")
    @UsualApi(name = "/sardline/common/getVerifiCode", type = "GET")
    public Map getVerifiCode(HttpServletRequest request) throws IOException {
        /*
             1.生成验证码
             2.把验证码上的文本存在session中
             3.把验证码图片发送给客户端
//             */
//        ImageVerificationCode ivc = new ImageVerificationCode();     //用我们的验证码类，生成验证码类对象
//        BufferedImage image = ivc.getImage();  //获取验证码
////        request.getSession().setAttribute("text", ivc.getText()); //将验证码的文本存在session中
////        ivc.output(image, response.getOutputStream());//将验证码图片响应给客户端
//
//
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        ImageIO.write(image, "png", stream);
//        String base64 = Base64.encode(stream.toByteArray());
        Map resp = new HashMap();
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                code += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                code += String.valueOf(random.nextInt(10));
            }
        }
        String key = "smsPwd_";
        ImageVerificationCode ivc = new ImageVerificationCode();     //用我们的验证码类，生成验证码类对象
        BufferedImage image = ivc.getImage();  //获取验证码
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", stream);
        String imageBase64 = Base64.encode(stream.toByteArray());

        resp.put("key", key);
        resp.put("code", imageBase64);
        return resp;

    }


}
