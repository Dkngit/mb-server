package com.example.mbserver.pojo;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @since 2019/12/8
 */
public class MBPageRequest {

    private int pageIndex;
    private int pageSize;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Pageable pageable() {
//        System.out.println("page:" + this.pageIndex + "-" + this.pageSize);
        return PageRequest.of(this.pageIndex, this.pageSize);
    }
}
