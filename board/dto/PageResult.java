package com.multi.board.dto;

import java.util.List;

public class PageResult<T> {
    private List<T> content;
    private int total;
    private int page;
    private int size;
    private int totalPage;

    public PageResult() {

    }

    public PageResult(List<T> content, PageRequest pageRequest, int total) {
        this.content = content;
        this.total = total;
        this.page = pageRequest.getPage();
        this.size = pageRequest.getSize();
        this.totalPage = (int) Math.ceil((double) total / size);
    }

    public List<T> getContent() {
        return content;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getTotalPage() {
        return totalPage;
    }
    public boolean hasNext() {
        return page < totalPage;
    }
    public boolean hasPrevious() {
        return page > 1;
    }
}
