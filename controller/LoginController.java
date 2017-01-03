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

import com.gdufs.dao.UserLoginDao;
import com.gdufs.entity.User;

@Controller

public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) throws  IOException {
		String userName = request.getParameter("useruame").trim();
		String password = request.getParameter("password").trim();
		String userType = request.getParameter("userType").trim();
		PrintWriter out=response.getWriter();	
		User user = null;
		UserLoginDao userLogin = new UserLoginDao();
		
		try{
			user = userLogin.findUser(userName, password, userType);
			if(user!=null) {
				String status = user.getStatus();
				if(status.equals("active")) {
					session.setAttribute("userName", userName);
					model.addAttribute("userName", userName);
					out.print("1");
				}
				else {
					out.print("4");
				}
			}
			else {
				out.print("2");
			}
		} catch (SQLException e) {
			out.print("3");
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
}
