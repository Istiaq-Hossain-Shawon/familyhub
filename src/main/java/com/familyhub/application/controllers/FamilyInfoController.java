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
import com.familyhub.application.dto.familyInfoDto;
import com.familyhub.application.model.FamilyInfo;
import com.familyhub.application.model.User;
import com.familyhub.application.service.FamilyService;
import com.familyhub.application.service.UserService;
import com.familyhub.application.util.Constants;
import com.google.gson.Gson;


@Controller
public class FamilyInfoController {

	
	@Autowired	ServletContext context;
	@Autowired	
	UserService userService;
	@Autowired	
	FamilyService familyService;
	
	@RequestMapping(path="/familyInfo/add",produces = "text/html;charset=UTF-8",method = RequestMethod.GET)
	public String familyInfoAdd(Model model) {
		model.addAttribute("familyInfo", new familyInfoDto());		
		return "familyInfo/add";
	}

	@RequestMapping(path="/familyInfo/add",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
	public String add(@ModelAttribute(name = "familyInfo") familyInfoDto familyInfo, Model model) {
		
		if (familyInfo.getCardNo() == null || familyInfo.getCardNo().trim().isEmpty()) {
			throw new RuntimeException("Please give card no");
		}		
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		
		var data=userService.getUserByUserName(username).get();
		familyInfo.setUser(data);
		
		try {
			List<ImageDto> images= new ArrayList<ImageDto>();
			for (var temp : familyInfo.getImages()) {
				if(temp.getSize()==0) {
					continue;
				}
				ImageDto  imgDto= new ImageDto();
				byte[] bytes = temp.getBytes();
				String absoluteFilePath = context.getRealPath(Constants.UPLOADED_FOLDER);
				var fileName = System.currentTimeMillis() + temp.getOriginalFilename();
				Path path = Paths.get(absoluteFilePath + fileName);
				Files.write(path, bytes);
				imgDto.setImageName(fileName);
				imgDto.setImage(temp);	
				images.add(imgDto);
			}
			familyInfo.setImageDto(images);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}		
		familyService.insert(familyInfo);
		model.addAttribute("message", "family information added successfully");
		return "redirect:/?_search=&_pageIndex=0&_rows=5&_sort=NA";
	}	
	@GetMapping("/familyInfo/edit")
	public String editFamilyInfo(Model model, @RequestParam("id") long id) {
		var data =familyService.getFamilyById(id);	
		model.addAttribute("familyInfo", data);	
		return "familyInfo/edit";
	}
	@GetMapping("/familyInfo/detail")
	public String familyDetailInfo(Model model, @RequestParam("id") long id) {
		var data =familyService.getFamilyById(id);	
		model.addAttribute("familyInfo", data);	
		return "familyInfo/detail";
	}
	@PostMapping("/familyInfo/update")
	public String updateFamilyInfo(@ModelAttribute(name = "familyInfo") familyInfoDto familyInfo, Model model) {
		
		
		
		try {
			
			if (familyInfo.getCardNo() == null || familyInfo.getCardNo().trim().isEmpty()) {
				throw new RuntimeException("Please give card no");
			}	
			
			var username="";
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				  username = ((UserDetails)principal).getUsername();
				} else {
				  username = principal.toString();
			}	
			
			var data=userService.getUserByUserName(username).get();
			familyInfo.setUser(data);
			
			List<ImageDto> images= new ArrayList<ImageDto>();
			for (var temp : familyInfo.getImages()) {
				if(temp.getSize()==0) {
					continue;
				}
				ImageDto  imgDto= new ImageDto();
				byte[] bytes = temp.getBytes();
				String absoluteFilePath = context.getRealPath(Constants.UPLOADED_FOLDER);
				var fileName = System.currentTimeMillis() + temp.getOriginalFilename();
				Path path = Paths.get(absoluteFilePath + fileName);
				Files.write(path, bytes);
				imgDto.setImageName(fileName);
				imgDto.setImage(temp);	
				images.add(imgDto);
			}			
			familyInfo.setImageDto(images);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}		
		familyService.update(familyInfo);
		model.addAttribute("message", "information updated successfully");
		return "redirect:/familyInfo/detail?id="+familyInfo.getFamilyId();
	}
	@PostMapping("/familyInfo/search")
	public String search(@ModelAttribute(name = "familyInfoDto") familyInfoDto familyInfoDto, Model model) {		
				
		return "redirect:/?_search="+familyInfoDto.getSearchContent()+"&_pageIndex=0&_rows=5&_sort=NA";
	}
	

	
}
