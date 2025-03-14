package com.ohgiraffers.section02.update;

public class Menu {

    private int menuCode;
    private String menuName;
    private int menuPrice;

    public Menu(int menuCode, String menuName, int menuPrice) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCode = menuCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                '}';
    }
}
