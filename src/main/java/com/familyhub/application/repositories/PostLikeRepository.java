package com.familyhub.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.familyhub.application.model.Post;
import com.familyhub.application.model.PostComment;
import com.familyhub.application.model.PostImage;
import com.familyhub.application.model.PostLike;

@Repository
@Transactional
public interface PostLikeRepository extends JpaRepository<PostLike, Long>{
	
	//List<PostImage> findByImgPost(Post imgPost);		
	 //Optional<PostLike> findByLikePostAndUsrLike(long likePost,long usrLike);
	 
	 //Optional<PostLike> GetDataByPostIdAndUserId(long postId ,long userId);
	 @Query(value="SELECT pst.* FROM tbl_postLike pst where pst.postId =:postId and  pst.likeBy =:likeBy ",nativeQuery = true)
	 List<PostLike> GetDataByPostIdAndUserId(@Param("postId") long postId, @Param("likeBy") long likeBy);

}
