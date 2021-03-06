package com.gdufs.graduation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdufs.dao.UserRegistrationDao;

@Controller
public class PasswordController {
	final static String html=   "<head><link href='./static/css/bootstrap.min.css' rel='stylesheet'>"+ 
								"<link href='./static/css/font-awesome.min.css' rel='stylesheet'>"+ 
								"<link href='./static/css/font-face.css' rel='stylesheet'>"+ 
								"<meta charset='utf-8' />"+ 
								"<script type='text/javascript' src='./static/js/jquery-1.11.2.min.js'></script> "+   
								"<script src='./static/js/bootstrap.min.js'></script>"+  
								"<script src='./static/js/bootbox.min.js'></script> </head> "; 

	
	/*@RequestMapping(value = "/findPasswordCheck", method = RequestMethod.POST)
	public void findPasswordCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName").trim();
		String email = request.getParameter("email").trim();
		PasswordManageDao user = new PasswordManageDao();
		String nameCheck = user.checkName(userName);
		System.out.println(userName+","+email);
		
		if(nameCheck.equals("active")) {
			String checkMail = user.checkUserAndEmail(userName, email);
			if(checkMail.equals("right")) {				
				out.print("right");
			}
			else if(checkMail.equals("wrong")) {
				out.print("right");
			}
			else {
				out.print("error");
			}
		}
		else if(nameCheck.equals("notActive")) {
			out.print("notActive");
		}
		else if(nameCheck.equals("notExist")) {
			out.print("notExist");
		}
		else {
			out.print("error");
		}
		out.flush();
		out.close();
	}*/
	
	@RequestMapping(value = "/findPasswordCheckName", method = RequestMethod.POST)
	public void findPasswordCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName").trim();
		PasswordManageDao user = new PasswordManageDao();
		String nameCheck = user.checkName(userName);
		
		if(nameCheck.equals("active")) {
			out.print("active");
		}
		else if(nameCheck.equals("notActive")) {
			out.print("notActive");
		}
		else if(nameCheck.equals("notExist")) {
			out.print("notExist");
		}
		else {
			out.print("error");
		}
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/findPasswordCheckEmail", method = RequestMethod.POST)
	public void findPasswordCheckEmail(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName").trim();
		String email = request.getParameter("email").trim();
		PasswordManageDao user = new PasswordManageDao();
		String checkMail = user.checkUserAndEmail(userName, email);
		
		if(checkMail.equals("right")) {
			out.print("right");
		}
		else if(checkMail.equals("wrong")) {
			out.print("wrong");
		}
		else {
			out.print("error");
		}
		out.flush();
		out.close();
	}
	
	//findPasswordDo
	@RequestMapping(value = "/findPasswordDo", method = RequestMethod.POST)
	public void passwordFind(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName").trim();
		String email = request.getParameter("email").trim();
		PasswordManageDao user = new PasswordManageDao();
		String nameCheck = user.checkName(userName);
		System.out.println(userName+","+email);
		
		if(nameCheck.equals("active")) {
			String checkMail = user.checkUserAndEmail(userName, email);
			if(checkMail.equals("right")) {				
				String pass = user.getPass(userName);
				String content = userName+"您好，您的密码是: "+pass;
				MailUtil.send(email, content);
				
				out.print(html); 
	 			out.print("<body><script>bootbox.alert('<br><B>密码已发送到您的邮箱，请查看。',function (){window.location.href='/graduation';})</script></body>"); 
			}
			else if(checkMail.equals("wrong")) {
				out.print(html); 
	 			out.print("<body><script>bootbox.alert('<br><B>该邮箱不是注册时的邮箱，请再试一次。',function (){window.location.href='toFindPass';})</script></body>"); 
			}
			else {
				out.print(html); 
	 			out.print("<body><script>bootbox.alert('<br><B>系统错误，请再试一次。',function (){window.location.href='toFindPass';})</script></body>"); 
			}
		}
		else if(nameCheck.equals("notActive")) {
			out.print(html); 
 			out.print("<body><script>bootbox.alert('<br><B>该用户名没有激活，请先激活。',function (){window.location.href='toFindPass';})</script></body>"); 
		}
		else if(nameCheck.equals("notExist")) {
			out.print(html); 
 			out.print("<body><script>bootbox.alert('<br><B>该用户名不存在，请再试一次。',function (){window.location.href='toFindPass';})</script></body>"); 
		}
		else {
			out.print(html); 
 			out.print("<body><script>bootbox.alert('<br><B>系统错误，请再试一次。',function (){window.location.href='toFindPass';})</script></body>"); 
		}
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/changePasswordCheckName", method = RequestMethod.POST)
	public void findPasswordCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    String userName = request.getParameter("userName").trim();
	    String oldPass = request.getParameter("oldPass").trim();
	    PasswordManageDao user = new PasswordManageDao();
	    PrintWriter out = response.getWriter();
	    String checkName = user.checkName(userName);
	    
	    if(userName.equals("active")) {
	    	out.print("active");
	    }
	    else if(userName.equals("notActive")) {
	    	out.print("notActive");
	    }
	    else if(userName.equals("notExist")) {
	    	out.print("notExist");
	    }
	    else {
	    	out.print("error");
	    }
	    out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/changePasswordCheckPass", method = RequestMethod.POST)
	public void changePasswordCheckPass(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    String userName = request.getParameter("userName").trim();
	    String oldPass = request.getParameter("oldPass").trim();
	    PasswordManageDao user = new PasswordManageDao();
	    PrintWriter out = response.getWriter();
	    String checkPass = user.checkUserAndPass(userName, oldPass);
	    
	    if(checkPass.equals("right")) {
	    	out.print("right");
	    }
	    else if(checkPass.equals("wrong")) {
	    	out.print("wrong");
	    }
	    else {
	    	out.print("error");
	    }
	}
}
