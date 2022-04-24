package com.example.demo.persistence.cms.repository;

import com.example.demo.persistence.cms.model.JpaPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostRepository extends PagingAndSortingRepository<JpaPost, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "comments")
    Page<JpaPost> findAll(Pageable pageable);


}
