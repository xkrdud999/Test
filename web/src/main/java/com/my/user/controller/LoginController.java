package com.my.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.user.service.IUserService;
import com.my.user.vo.UserVO;

@Controller

public class LoginController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	BCryptPasswordEncoder bpe;
	
	@PostMapping(value="login.do")
	public String login(String userId, String userPw, Model model, HttpSession session) {
		
		String dbpw = userService.getPassword(userId);
		if(dbpw != null  & !bpe.matches(userPw, dbpw)) {
			UserVO vo = userService.getUser(userId);
			session.setAttribute("vo", vo);
			session.setAttribute("userId", userId);
			return "redirect:/user";
			
		}else {
			model.addAttribute("message","아이디 또는 비밀번호가 잘못 되었습니다.");
			return "user/login";
		}
		
	}

}
