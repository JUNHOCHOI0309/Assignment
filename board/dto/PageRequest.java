package com.multi.board.dto;

public class PageRequest {
    private int page;
    private int size;

    public PageRequest() {
        this.page = 1;
        this.size = 10;
    }

    public PageRequest(int page, int size) {
        this.page = page <= 0 ? 1 : page;
        this.size = size <= 0 ? 10 : size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOffset() {
        return (page - 1) * size;
    }
}
