package com.example.demo.persistence.cms.repository;

import com.example.demo.persistence.cms.model.JpaPostComment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostCommentRepository extends PagingAndSortingRepository<JpaPostComment, Long> {

}
