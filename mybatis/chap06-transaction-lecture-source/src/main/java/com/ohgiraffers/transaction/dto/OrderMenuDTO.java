package com.ohgiraffers.transaction.dto;

public class OrderMenuDTO {
    private int menuCode;
    private int orderAmount;

    public int getMenuCode() {
        return menuCode;
    }
    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }
    public int getOrderAmount() {
        return orderAmount;
    }
    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}