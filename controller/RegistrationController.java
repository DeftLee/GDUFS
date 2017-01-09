package com.gdufs.graduation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gdufs.dao.UserRegistrationDao;
import com.gdufs.entity.MailUtil;

@Controller

public class RegistrationController {
	final static String html=   "<head><link href='./static/css/bootstrap.min.css' rel='stylesheet'>"+
			"<link href='./static/css/font-awesome.min.css' rel='stylesheet'>"+
			"<link href='./static/css/font-face.css' rel='stylesheet'>"+
			"<meta charset='utf-8' />"+
		    "<script type='text/javascript' src='./static/js/jquery-1.11.2.min.js'></script> "+  
		    "<script src='./static/js/bootstrap.min.js'></script>"+ 
		    "<script src='./static/js/bootbox.min.js'></script> </head> ";
	
	/*@RequestMapping(value = "/registrationCheck", method = RequestMethod.POST)
	public void check(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws  IOException,SecurityException {
		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		String confirm = request.getParameter("confirm").trim();
		PrintWriter out = response.getWriter();		
		UserRegistrationDao regist = new UserRegistrationDao();
		
		try{
			if(!password.equals(confirm)) {
				out.print("different");
			}
			else {
				String checkName = regist.checkUserName(userName);
				if(checkName.equals("active")) {
					out.print("active");
				}
				else if(checkName.equals("notActive")) {
					out.print("notActive");
				}
				else if(checkName.equals("go")) {
					out.print("success");
				}
				else {
					out.print("error");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}*/
	
	@RequestMapping(value = "/registrationCheckName", method = RequestMethod.POST)
	public void registrationCheckName(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws  IOException,SecurityException {
		String userName = request.getParameter("userName").trim();
		PrintWriter out = response.getWriter();		
		UserRegistrationDao regist = new UserRegistrationDao();
		
		try {
			String checkName = regist.checkUserName(userName);
			if(checkName.equals("active")) {
				out.print("active");
			}
			else if(checkName.equals("notActive")) {
				out.print("notActive");
			}
			else if(checkName.equals("go")) {
				out.print("success");
			}
			else {
				out.print("error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
	
	@RequestMapping(value = "/registrationDO", method = RequestMethod.POST)
	public void registration(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws  IOException,SecurityException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		String teamType = request.getParameter("teamType").trim();
		String confirm = request.getParameter("confirm").trim();
		String email = request.getParameter("email").trim();
		String depart = request.getParameter("depart").trim();
		PrintWriter out=response.getWriter();		
		UserRegistrationDao regist = new UserRegistrationDao();
		System.out.println(userName+","+depart);
		
		try{
			if(!password.equals(confirm)) {
				out.print(html);
				out.print("<body><script>bootbox.alert('<br><B>两次输入的密码不同，请再试一次。',function (){window.location.href='toRegistration';})</script></body>");
			}
			else {
				String result = regist.regist(userName, password, teamType, email, depart);
				if(result.equals("active")) {
					out.print(html);
					out.print("<body><script>bootbox.alert('<br><B>此用户名已经被注册,请换个用户名。',function (){window.location.href='toRegistration';})</script></body>");
				}
				else if(result.equals("notActive")) {
					out.print(html);
					out.print("<body><script>bootbox.alert('<br><B>此用户名被注册但未激活，请查看邮件激活。',function (){window.location.href='toRegistration';})</script></body>");
				}
				else if(result.equals("error")) {
					out.print(html);
					out.print("<body><script>bootbox.alert('<br><B>系统错误，请再试一次。',function (){window.location.href='toRegistration';})</script></body>");
				}
				else {
					String title="如果你想激活刚注册的账号，请点击下面的链接。 \n";
					String content=title+"<a href='http://localhost:8080/graduation/active?";
					userName = java.net.URLEncoder.encode(userName, "utf-8");
					String data="1="+userName+"'>点击这里。</a>";
					content=content+data;
					
					MailUtil.send(email, content);
					out.print(html);
					out.print("<body><script>bootbox.alert('<br><B>激活帐号的邮件已经发送到您的邮箱，请点击链接激活帐号。',function (){window.location.href='/graduation';})</script></body>");
				}
			}
		} catch (SQLException e) {
			out.print(html);
			out.print("<body><script>bootbox.alert('<br><B>系统错误，请再试一次。',function (){window.location.href='toRegistration';})</script></body>");
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}		
	}
	
	@RequestMapping(value = "/active", method = RequestMethod.GET)
	public void activeName(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws  IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("1");
		userName = new String(userName.getBytes("ISO-8859-1"),"utf-8");
		userName = java.net.URLDecoder.decode(userName, "utf-8");
		UserRegistrationDao regist = new UserRegistrationDao();
		PrintWriter out=response.getWriter();
		System.out.println(userName);
		
		boolean isActive = regist.active(userName);
		if(isActive) {
			out.print(html);
			out.print("<body><script>bootbox.alert('<br><B>您的账号已成功激活。',function (){window.location.href='/graduation';})</script></body>");
		}
		else {
			out.print(html);
			out.print("<body><script>bootbox.alert('<br><B>系统错误，请再试一次。',function (){window.location.href='';})</script></body>");
		}
		out.flush();
		out.close();
	}	
}
