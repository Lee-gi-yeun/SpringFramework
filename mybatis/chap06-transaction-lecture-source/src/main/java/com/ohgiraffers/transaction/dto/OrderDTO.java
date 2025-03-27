package com.ohgiraffers.transaction.dto;

public class OrderDTO {
    private String orderDate;
    private String orderTime;
    private int totalOrderPrice;

    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }
    public void setTotalOrderPrice(int totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }
}