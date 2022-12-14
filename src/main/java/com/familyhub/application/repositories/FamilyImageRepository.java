package com.familyhub.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.familyhub.application.model.FamilyImage;


@Repository
@Transactional
public interface FamilyImageRepository extends JpaRepository<FamilyImage, Long>{
	
	Optional<FamilyImage> findByImageId(long imageId);	
	
	//List<PostImage> findByImgPost(Post imgPost);		
	
}
