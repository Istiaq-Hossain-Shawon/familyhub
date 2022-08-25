package com.familyhub.application.repositories;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.familyhub.application.model.FamilyInfo;
@Repository
@Transactional
public interface FamilyRepository extends JpaRepository<FamilyInfo , Long>{	
	
	Optional<FamilyInfo> findByFamilyId(long familyId);	
	
	@Query(value ="SELECT pst.* FROM tbl_family  pst  where pst.name like %:text%  or pst.cardNo like %:text% "
			,nativeQuery = true)
	Page<FamilyInfo> fullTextSearch(@Param("text") String text,Pageable pageable);	
	
}
