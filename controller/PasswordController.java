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
	@RequestMapping(value = "/findPasswordCheck", method = RequestMethod.POST)
	public void passwordCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		UserRegistrationDao user = new UserRegistrationDao();
		String nameCheck = user.checkUserName(userName);
		
		if(nameCheck.equals("active")) {
			out.print("active");
		}
		else if(nameCheck.equals("notActive")) {
			out.print("notActive");
		}
		else if(nameCheck.equals("go")) {
			out.print("notExist");
		}
		else {
			out.print("error");
		}
		out.flush();
		out.close();
	}
}
