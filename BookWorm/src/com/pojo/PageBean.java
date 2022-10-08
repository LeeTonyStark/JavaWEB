package com.pojo;

import java.util.List;

/**
 * 分页
 * @author lifeng
 * @create 2022-09-24 15:48
 */
public class PageBean<T> {
    //当前页码
    private int pageNo;
    //总页数
    private int pages;
    //每页显示条数
    private int pageSize;
    //每页的数据
    private List<T> list;
    //总条数
    private int count;

    public PageBean() {
    }

    public PageBean(int pageNo, int pages, int pageSize, List<T> list, int count) {
        this.pageNo = pageNo;
        this.pages = pages;
        this.pageSize = pageSize;
        this.list = list;
        this.count = count;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNo=" + pageNo +
                ", pages=" + pages +
                ", pageSize=" + pageSize +
                ", list=" + list +
                ", count=" + count +
                '}';
    }
}
