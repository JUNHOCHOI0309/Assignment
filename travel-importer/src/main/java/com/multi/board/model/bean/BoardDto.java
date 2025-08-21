package com.multi.board.model.bean;

public class BoardDto {
    private int articleNo;
    private String subject;
    private String content;
    private String userId;
    private String registerTime;

    @Override
    public String toString() {
        return "BoardDto[" +
                "articleNo=" + articleNo +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ']';
    }

    public void setArticleNo(int articleNo) {
        this.articleNo = articleNo;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public int getArticleNo() {
        return articleNo;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public String getRegisterTime() {
        return registerTime;
    }
}
