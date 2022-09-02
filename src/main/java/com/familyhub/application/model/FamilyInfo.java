package com.familyhub.application.model;

import javax.persistence.*;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import com.familyhub.application.enums.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_family")
public class FamilyInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long familyId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;  
    
    
    @Column(name = "cardNo", columnDefinition = "nvarchar(120) default 'istiaq'")
    @Nationalized
    @Type(type="org.hibernate.type.StringNVarcharType")    
	private String cardNo;
	
	 @Column(name = "createdDate")
	 private Date  createdDate;   

	private String area;
    
    private String ward;
    
    private String thana;
    
    private String name;
    
    private String spouseName;
    
    private String profession;
    
    private String mobileNo;
    
    private String nationalId;
    

    @OneToMany(mappedBy = "imgFamily", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<FamilyImage> familyImage;
    
	public Set<FamilyImage> getPostImage() {
		return familyImage;
	}
	public void setPostImage(Set<FamilyImage> familyImage) {
		this.familyImage= familyImage;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Set<FamilyImage> getFamilyImage() {
		return familyImage;
	}
	public void setFamilyImage(Set<FamilyImage> familyImage) {
		this.familyImage = familyImage;
	}
	public FamilyInfo() {
		super();
	}	
}
