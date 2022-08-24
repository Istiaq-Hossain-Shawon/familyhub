package com.familyhub.application.controllers;

import com.familyhub.application.dto.ImageDto;
import com.familyhub.application.dto.PostCommentDto;
import com.familyhub.application.dto.PostDto;
import com.familyhub.application.dto.familyInfoDto;
import com.familyhub.application.enums.Role;
import com.familyhub.application.model.Post;
import com.familyhub.application.model.PostImage;
import com.familyhub.application.model.User;
import com.familyhub.application.repositories.UserRepository;
import com.familyhub.application.service.FamilyService;
import com.familyhub.application.service.PostService;
import com.familyhub.application.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {

	private final UserRepository userRepository;
	@Autowired	
	FamilyService familyService;
	
	@Autowired	
	UserService userService;
	
	private final PasswordEncoder passwordEncoder;
	

	public RootController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		
	}

	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String root(Model model) {
		model.addAttribute("family", new familyInfoDto());
		var data =familyService.getAll("",0,5,"PDA");
		List<familyInfoDto> familyDtoList= new ArrayList<familyInfoDto>();
		model.addAttribute("familyInfos", data.getContent());
		model.addAttribute("totalPages",data.getTotalPages());
		model.addAttribute("pageIndex",0);		
		
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		model.addAttribute("loginUser",userService.getUserByUserName(username).get());	
		
		return "index";
	}	

	@RequestMapping(value = "/",params= {"_search","_pageIndex","_rows","_sort"},  method = RequestMethod.GET)
	public String getAll(Model model,
			@RequestParam(value = "_search") String searchText,
			@RequestParam(value = "_pageIndex") int pageIndex,
			@RequestParam(value = "_rows") int rows,
			@RequestParam(value = "_sort") String sort) {
		model.addAttribute("family", new familyInfoDto());
		var data =familyService.getAll(searchText,pageIndex,rows,sort);
		model.addAttribute("familyInfos", data.getContent());
		model.addAttribute("totalPages",data.getTotalPages());
		model.addAttribute("pageIndex",pageIndex);
		
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		model.addAttribute("loginUser",userService.getUserByUserName(username).get());	
		
		return "index";
	}
	@GetMapping("/account/index")
	public String account(Model model) {
		model.addAttribute("post", new PostDto());
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		
		var data=userService.getUserByUserName(username).get();
		model.addAttribute("user", data);
		return "account/index";
	}
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name="error", required = false) String error) {				
		generateUsers();		
		model.addAttribute("error", error);
		model.addAttribute("message", "login...");
		return "auth/login";
	}	
	private void generateUsers() {
		if (userRepository.findByUsername("user").isEmpty()) {
			var user = new User();
			user.setUsername("user");
			user.setEmail("hossain.ict@gmail.com");
			user.setPassword(passwordEncoder.encode("1"));	
			user.setLogo("default.jpg");				
			user.setRole(Role.ROLE_USER);			
			userRepository.save(user);
		}
	}
}
