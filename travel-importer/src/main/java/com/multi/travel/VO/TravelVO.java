package com.multi.travel.VO;

public class TravelVO {
    private int no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;

    public int getNo() {
        return no;
    }

    public String getDistrict() {
        return district;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "TravelVO[" +
                "no=" + no +
                ", district='" + district + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ']';
    }
}
