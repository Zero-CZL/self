package cn.nothsea.pojo;

import java.util.List;

public class PageBean<T>{
    private int pageNum;
    private int pageSize;
    private int total;
    private List<T> beanList;

    public int getPages(){
        int pages = total/pageSize;
        return total%pageSize==0?pages:pages+1;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
