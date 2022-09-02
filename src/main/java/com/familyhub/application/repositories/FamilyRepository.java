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
	
	@Query(value ="SELECT pst.* FROM tbl_family  pst  where pst.full_name like %:text%  or pst.cardNo like %:text% or pst.mobileNo like %:text% or pst.nationalId like %:text% ",nativeQuery = true)
	Page<FamilyInfo> fullTextSearch(@Param("text") String text,Pageable pageable);	
	
//	@Query(value="SELECT m.* FROM tbl_family m WHERE m.full_name LIKE %:text%  ORDER BY ?#{#pageable}",nativeQuery = true)
//	Page<FamilyInfo> searchByTextSearch(@Param("text") String text,Pageable pageable);
	
	
	@Query(value = "SELECT * FROM tbl_family t WHERE LOWER(t.full_name) LIKE LOWER(CONCAT('%', ?1,'%')) or LOWER(t.cardNo) LIKE LOWER(CONCAT('%', ?1,'%'))", nativeQuery = true)
	Page<FamilyInfo> searchByTextSearch(String text, Pageable pageable);
	
			
}
