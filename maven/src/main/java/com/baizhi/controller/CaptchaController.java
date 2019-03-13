package com.baizhi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;


@Controller
@RequestMapping("/cap")
public class CaptchaController {
	
	@RequestMapping("/generateCaptcha")
	public void generateCaptcha(HttpSession session,HttpServletResponse response) throws IOException{
		//1.生成验证码随机数
		String securityCode = SecurityCode.getSecurityCode();
		//2.将随机数保存到session中,以便未来做验证
		session.setAttribute("serverCode", securityCode);
		//3.获取验证码图片
		BufferedImage image = SecurityImage.createImage(securityCode);
		//4.使用IO流响应到客户端
		ServletOutputStream out = response.getOutputStream();
		/**
		 * 第一个参数：指定验证码图片对象
		 * 第二个参数：指定图片类型
		 * 第三个参数：指定输出流
		 */
		ImageIO.write(image, "png", out);
	}
}
