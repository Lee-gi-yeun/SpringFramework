package com.ohgiraffers.handlermethod;

// 커멘드 객체로 사용하기 위해서는 name 속성 값과 필드명이 일치하도록 작성해야 한다
public class MenuDTO {

    private String name;
    private int price;
    private int categoryCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
}
