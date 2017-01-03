package com.gdufs.graduation;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String toLoginPage() {
		return "LoginPage";
	}
	
	@RequestMapping(value = "/tomainpage", method = RequestMethod.GET)
	public String toMainPage(HttpSession session) {
		if (session.getAttribute("userName")!=null) {
			return "MainPage";
		}
		else {
			return "LoginFirst";
		}
	}
	
	@RequestMapping(value = "/toRegistration", method = RequestMethod.GET)
	public String toRegistratrion() {
		return "Registration";
	}
}
