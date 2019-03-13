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
		//1.������֤�������
		String securityCode = SecurityCode.getSecurityCode();
		//2.����������浽session��,�Ա�δ������֤
		session.setAttribute("serverCode", securityCode);
		//3.��ȡ��֤��ͼƬ
		BufferedImage image = SecurityImage.createImage(securityCode);
		//4.ʹ��IO����Ӧ���ͻ���
		ServletOutputStream out = response.getOutputStream();
		/**
		 * ��һ��������ָ����֤��ͼƬ����
		 * �ڶ���������ָ��ͼƬ����
		 * ������������ָ�������
		 */
		ImageIO.write(image, "png", out);
	}
}
