package com.number.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.number.model.UserInfo;
import com.number.service.UserInfoService;
import com.number.utils.EncryptString;

@Controller
public class AppController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/app/sendLastScore", method = RequestMethod.GET)
	@ResponseBody
	public void sendLastScore(HttpServletRequest request) {

		String userId = request.getParameter("userId");
		String lastScore = request.getParameter("lastScore");
		Integer id = Integer.parseInt(userId);
		Integer score = Integer.parseInt(lastScore);
		
		UserInfo userInfo = userInfoService.getUserInfoById(id);

		userInfo.setLastScore(score);
		if(userInfo.getBestScore() < score) {
			userInfo.setBestScore(score);
		}

		userInfoService.updateUserInfo(userInfo);

	}

	@RequestMapping(value = "/app/sendBestScore", method = RequestMethod.GET)
	@ResponseBody
	public void sendBestScore(@RequestParam("userId") String userId, @RequestParam("bestScore") String bestScore, HttpServletRequest request) {

		Integer id = Integer.parseInt(userId);
		Integer best = Integer.parseInt(bestScore);

		UserInfo userInfo = userInfoService.getUserInfoById(id);
		if (userInfo.getBestScore() < best) {
			userInfo.setBestScore(best);
			userInfoService.updateUserInfo(userInfo);
		}

	}

	@RequestMapping(value = "/app/showPlay", method = RequestMethod.GET)
	public ModelAndView showPlay(HttpServletRequest request) {
		// Authentication check starts
		boolean isLogin = this.isLogin(request);
		ModelAndView modelAndView;

		if (!isLogin) {

			modelAndView = new ModelAndView("redirect:/auth/showLoginPage");
			return modelAndView;
		}

		// Authentication check ends

		modelAndView = new ModelAndView("play");

		String userId = request.getParameter("userId");
		Integer id = Integer.parseInt(userId);

		UserInfo userInfo = userInfoService.getUserInfoById(id);
		List<UserInfo> topScorers = userInfoService.findTopTenUsers();

		modelAndView.addObject("userInfo", userInfo);
		modelAndView.addObject("topScorers", topScorers);

		return modelAndView;

	}

	@RequestMapping(value = "/app/showRegister", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("register");

		UserInfo userInfo = new UserInfo();

		modelAndView.addObject("userInfo", userInfo);

		return modelAndView;
	}

	@RequestMapping(value = "/app/register", method = RequestMethod.POST)
	public ModelAndView registerUser(
			@ModelAttribute("userInfo") UserInfo userInfo,
			HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("success");

		userInfo.setPassword(EncryptString.encryptToSHA1(userInfo.getPassword()));

		userInfoService.saveUserInfo(userInfo);

		modelAndView.addObject("userInfo", userInfo);

		return modelAndView;

	}

	private boolean isLogin(HttpServletRequest request) {
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"loginUser");

		if (loginUser.getEmail() == null && loginUser.getUserName() == null
				&& loginUser.getUserId() == null) {
			return false;
		}

		return true;
	}

}
