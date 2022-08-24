package com.familyhub.application.dto;



import java.io.Serializable;

import java.util.Date;
import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.familyhub.application.model.User;


public class familyInfoDto implements Serializable {
    
    private long familyId;
    
    private String cardNo;
    
    private String area;
    
    private String ward;
    
    private String thana;
    
    private String name;
    private String searchContent;
    
    public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getThana() {
		return thana;
	}

	public void setThana(String thana) {
		this.thana = thana;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	private String spouseName;
    
    private String profession;
    
    private String mobileNo;
    
    private String nationalId;
    
    private List<ImageDto> imageDto;
    
    public List<ImageDto> getImageDto() {
		return imageDto;
	}

	public void setImageDto(List<ImageDto> imageDto) {
		this.imageDto = imageDto;
	}
	private List<MultipartFile> images;    

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	 
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public familyInfoDto() {
		super();
	}	
}
