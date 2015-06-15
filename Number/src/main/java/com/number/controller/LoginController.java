package com.number.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.number.model.UserInfo;
import com.number.service.UserInfoService;
import com.number.utils.EncryptString;

@Controller
public class LoginController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/auth/showLoginPage", method = RequestMethod.GET)
	public ModelAndView showLoginPage(HttpServletRequest request) {

		if (request.getSession().getAttribute("loginUser") == null) {

			ModelAndView modelAndView = new ModelAndView("login");

			UserInfo loginUser = new UserInfo();

			modelAndView.addObject("loginUser", loginUser);

			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView(
					"redirect:/app/showPlay");
			return modelAndView;
		}
	}

	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	public ModelAndView LoginProcess(
			@ModelAttribute("loginUser") UserInfo loginUser,
			HttpServletRequest request) {

		ModelAndView modelAndView;

		if (!this.checkUser(loginUser)) {
			modelAndView = new ModelAndView("login");
			// request.getSession().setAttribute("message", "Login Fail..");
			request.setAttribute("message", "Login Fail..");

			modelAndView.addObject("loginUser", loginUser);
			return modelAndView;
		} else {
			modelAndView = new ModelAndView("play");
			List<UserInfo> topScorers = userInfoService.findTopTenUsers();

			modelAndView.addObject("userInfo", loginUser);
			modelAndView.addObject("topScorers", topScorers);

			request.getSession().setAttribute("loginUser", loginUser);

		}
		return modelAndView;
	}

	@RequestMapping(value = "/auth/asAnonymous", method = RequestMethod.GET)
	public ModelAndView LoginAnonymous(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("play");
		UserInfo anonymousUser = userInfoService
				.getUserInfoByEmail("default@number.com");
		
		if (anonymousUser == null) {
			anonymousUser = new UserInfo();
			anonymousUser.setEmail("default@number.com");
			anonymousUser.setUserName("Anonymous");
			anonymousUser.setBestScore(0);
			anonymousUser.setLastScore(0);

			userInfoService.saveUserInfo(anonymousUser);
		}

		List<UserInfo> topScorers = userInfoService.findTopTenUsers();

		modelAndView.addObject("userInfo", anonymousUser);
		modelAndView.addObject("topScorers", topScorers);

		request.getSession().setAttribute("loginUser", anonymousUser);
		return modelAndView;
	}

	@RequestMapping(value = "/auth/logout", method = RequestMethod.GET)
	public ModelAndView LogOutProcess(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/auth/showLoginPage");
		request.getSession().invalidate();
		return modelAndView;
	}

	private boolean checkUser(UserInfo loginUser) {

		UserInfo userInfo = userInfoService.getUserInfoByEmail(loginUser
				.getEmail());
		if (userInfo != null) {
			if (userInfo.getPassword().equals(
					EncryptString.encryptToSHA1(loginUser.getPassword()))) {

				loginUser.setUserId(userInfo.getUserId());
				loginUser.setUserName(userInfo.getUserName());
				loginUser.setEmail(userInfo.getEmail());
				loginUser.setLastScore(userInfo.getLastScore());
				loginUser.setBestScore(userInfo.getBestScore());

				return true;
			}
		}

		return false;
	}

}
