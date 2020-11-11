package com.my.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.user.service.IUserService;
import com.my.user.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping(value="")
	public String mainPage(Model model) {
		model.addAttribute("message","Hello!");
		return "home";
	}
	
	@GetMapping(value="/login")
	public void LoginPage() {
		
	}

	
	@GetMapping(value="/join")
	public void JoinPage(Model model) {
		
		
	}
	@PostMapping(value="/join")
	public String JoinPage(@RequestParam MultipartFile file, UserVO vo, RedirectAttributes redirectAttributes) {
		if(file!=null & !file.isEmpty()) {
			try {
				vo.setPicture(file.getBytes());
				vo.setPictureSize(file.getSize());
			} catch (Exception e) {
				System.out.println("파일업다운로드 에러");
			}
			
		}
		userService.userJoin(vo);
		redirectAttributes.addFlashAttribute("message","회원가입완료");
		return "redirect:/user/login";
	}
	@GetMapping(value="/mypage")
	public void MyPage() {
		
	}
	
	@PostMapping(value="/check")
	@ResponseBody
	public String idCheck(String userId) {
		return userService.idCheck(userId) == 0 ? "true" : null;
	}
	
	
	
	
	
	
	

}
