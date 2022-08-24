package com.familyhub.application.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.familyhub.application.dto.ImageDto;
import com.familyhub.application.dto.PostCommentDto;
import com.familyhub.application.dto.PostDto;
import com.familyhub.application.dto.PostLikeDto;
import com.familyhub.application.dto.familyInfoDto;
import com.familyhub.application.model.Post;
import com.familyhub.application.model.PostComment;
import com.familyhub.application.model.PostLike;
import com.familyhub.application.model.User;
import com.familyhub.application.service.PostService;
import com.familyhub.application.service.UserService;
import com.familyhub.application.util.Constants;
import com.google.gson.Gson;


@Controller
public class FamilyInfoController {

	
	@Autowired	ServletContext context;

	
	@RequestMapping(path="/familyInfo/add",produces = "text/html;charset=UTF-8",method = RequestMethod.GET)
	public String familyInfoAdd(Model model) {
		model.addAttribute("familyInfo", new familyInfoDto());		
		return "familyInfo/add";
	}
	@GetMapping("/familyInfo/edit")
	public String editFamilyInfo(Model model, @RequestParam("id") long id) {
//		var data =postService.getPostById(id);	
//		model.addAttribute("post", data);	
		return "post/edit";
	}
	

	
}
