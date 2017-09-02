package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 验证页面上输入的验证码信息
 * @author feizi
 * @time 2015-2-2上午8:14:22
 */
public class ResultServlet extends HttpServlet {

	private static final long serialVersionUID = -4023881398470853660L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//产生的正确的验证码值
		String validateC = (String) request.getSession().getAttribute("veryCode");
		
		//浏览器中用户输入的验证码值
		String veryCode = request.getParameter("code");
		
		PrintWriter out = response.getWriter();
		if(null == veryCode || "".equals(veryCode)){
			out.println("请输入验证码...");
		}else{
			if(validateC.equals(veryCode)){
				out.print(1);
			}else{
				out.println("对不起，验证码输入错误...");
			}
		}
		
		out.flush();
		out.close();
	}
}	
