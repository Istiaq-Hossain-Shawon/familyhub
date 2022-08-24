package com.familyhub.application.model;

import javax.persistence.*;

import com.familyhub.application.enums.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_familyImage")
public class FamilyImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long imageId;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "familyId", nullable = false)
    private FamilyInfo imgFamily; 
    

	
	public FamilyInfo getImgFamily() {
		return imgFamily;
	}
	public void setImgFamily(FamilyInfo imgPost) {
		this.imgFamily = imgPost;
	}
	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	public FamilyInfo getImgpost() {
		return imgFamily;
	}
	public void setImgpost(FamilyInfo imgpost) {
		this.imgFamily = imgpost;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	@Column(name = "imagePath")
    private String imagePath;
	
	@Column(name = "entryDate")
    private Date entryDate;
	

 

	 public FamilyImage(String imagePath,Date entryDate,FamilyInfo imgpost) {	        
		 this.imgFamily= imgpost;
	        this.imagePath = imagePath;
	        this.entryDate = entryDate;	      
	    }
	public FamilyImage() {
		super();
	}	
}
