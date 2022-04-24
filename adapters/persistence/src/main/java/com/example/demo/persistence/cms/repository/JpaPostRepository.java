package com.example.demo.persistence.cms.repository;

import com.example.demo.persistence.cms.model.JpaPost;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostRepository extends PagingAndSortingRepository<JpaPost, Long> {

}
