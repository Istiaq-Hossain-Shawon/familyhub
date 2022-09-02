package com.familyhub.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.familyhub.application.dto.familyInfoDto;
import com.familyhub.application.exceptions.ResourceAlreadyExistsException;
import com.familyhub.application.model.FamilyImage;
import com.familyhub.application.model.FamilyInfo;
import com.familyhub.application.repositories.FamilyImageRepository;
import com.familyhub.application.repositories.FamilyRepository;
import com.familyhub.application.repositories.UserRepository;
import com.familyhub.application.util.Constants;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FamilyService {

	
	@Autowired
	private FamilyRepository familyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FamilyImageRepository familyImageRepository;
	
	
	public void insert(familyInfoDto familydto) {
		FamilyInfo family = new FamilyInfo();
		family.setUser(familydto.getUser());
		family.setArea(familydto.getArea());
		family.setWard(familydto.getWard());
		family.setThana(familydto.getThana());
		family.setCardNo(familydto.getCardNo());
		family.setName(familydto.getName());
		family.setSpouseName(familydto.getSpouseName());
		family.setProfession(familydto.getProfession());
		family.setMobileNo(familydto.getMobileNo());
		family.setNationalId(familydto.getNationalId());
		family.setArea(familydto.getArea());
		family.setArea(familydto.getArea());
		family.setArea(familydto.getArea());
		family.setArea(familydto.getArea());
		family.setCreatedDate(new Date());		
		familyRepository.save(family);
		for (var temp : familydto.getImageDto()) {				
			familyImageRepository.save(new FamilyImage(temp.getImageName(), new Date(), family));
		}

	}
	public void update(familyInfoDto familydto) {
		FamilyInfo family=familyRepository.findById(familydto.getFamilyId()).get();		
		family.setUser(familydto.getUser());
		family.setArea(familydto.getArea());
		family.setWard(familydto.getWard());
		family.setThana(familydto.getThana());
		family.setCardNo(familydto.getCardNo());
		family.setName(familydto.getName());
		family.setSpouseName(familydto.getSpouseName());
		family.setProfession(familydto.getProfession());
		family.setMobileNo(familydto.getMobileNo());
		family.setNationalId(familydto.getNationalId());
		family.setArea(familydto.getArea());
		family.setArea(familydto.getArea());
		family.setArea(familydto.getArea());
		family.setArea(familydto.getArea());
		family.setCreatedDate(new Date());		
		familyRepository.save(family);
		for (var temp : familydto.getImageDto()) {				
			familyImageRepository.save(new FamilyImage(temp.getImageName(), new Date(), family));
		}
	}
	
	
	public Page<FamilyInfo> getAll(String searchText,int offset,int pageSize,String sort) {
		Pageable pageWithElements;
		pageWithElements = PageRequest.of(offset, pageSize,Sort.by("full_name").descending());	
//		Page<FamilyInfo> teams=familyRepository.fullTextSearch(searchText,pageWithElements);
//		Page<FamilyInfo> teams=familyRepository.findAll(PageRequest.of(offset,pageSize));
		Page<FamilyInfo> teams=familyRepository.searchByTextSearch(searchText,PageRequest.of(offset,pageSize));
		
		return teams;
	}
	public FamilyInfo getFamilyById(long id) {				
		Optional<FamilyInfo> family=familyRepository.findById(id);		
		return family.get();
	}
	

}
