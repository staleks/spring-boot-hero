package com.example.demo.core.util;

import lombok.Getter;

@Getter
public class PagingRequest {

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_SIZE = 50;
    public static final int MAX_SIZE = 100;

    public static final String SORT = "sort";
    public static final String PAGE = "page";
    public static final String SIZE = "size";

    private int page;
    private int size;
    private String sort;

    private PagingRequest(final Integer page, final Integer size, final String sorting) {
        this.page = DEFAULT_PAGE;
        if(page != null && page > 0){
            this.page = page - 1;
        }
        this.size = DEFAULT_SIZE;
        if(size != null && size > 0){
            this.size = size > MAX_SIZE ? MAX_SIZE : size;
        }
        this.sort = sorting;
    }

    /**
     *
     *
     * @param page - ZERO index page (actual page request is page - 1).
     * @param size - default is 50, but max is 100
     * @param sorting
     * @return
     */
    public static PagingRequest of(final Integer page, final Integer size, final String sorting) {
        return new PagingRequest(page, size, sorting);
    }

}
