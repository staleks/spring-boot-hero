package com.example.demo.persistence.cms.mapper;

import com.example.demo.domain.cms.Post;
import com.example.demo.persistence.cms.model.JpaPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper POST_JPA_ADAPTER_MAPPER = Mappers.getMapper(PostMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "body", target = "body")
    })
    Post entityToDomain(JpaPost entity);

}
