package com.example.demo.core.util;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public class PagingResponse<T> {

    private List<T> items;
    private int totalPages;
    private int page;
    private int size;

    public PagingResponse(final List<T> items, final int totalPages, final int page, final int size){
        this.items = items;
        this.totalPages = totalPages;
        this.page = page;
        this.size = size;
    }

}
