package com.example.demo.persistence.util;

import com.example.demo.core.util.PagingRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.springframework.data.domain.Sort.Direction.fromString;

public class PageRequestUtil {
    private static final String SORT_DESCENDING_PREFIX = "-";

    private PageRequestUtil() {
        //~ deliberately making utility class
    }

    public static Pageable fromPageRequestToPageable(PagingRequest pagingRequest) {
        Sort sort = Sort.unsorted();
        String sorting = pagingRequest.getSort();
        if(!StringUtils.isBlank(pagingRequest.getSort())){
            String direction = "ASC";
            if(sorting.startsWith(SORT_DESCENDING_PREFIX)){
                direction = "DESC";
                sorting = sorting.substring(1);
            }
            sort = Sort.by(fromString(direction), sorting);
        }
        return PageRequest.of(pagingRequest.getPage(), pagingRequest.getSize(), sort);
    }

}
