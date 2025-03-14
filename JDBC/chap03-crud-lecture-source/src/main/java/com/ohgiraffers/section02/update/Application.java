package com.ohgiraffers.section02.update;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("업데이트 할 메뉴 번호 : ");
        int menuCode = sc.nextInt();
        System.out.print("새로운 메뉴 명 : ");
        String menuName = sc.next();
        System.out.print("새로운 메뉴 가격 : ");
        int menuPrice = sc.nextInt();

        Menu menu = new Menu(menuCode, menuName, menuPrice);

        MenuService menuService = new MenuService();
        menuService.updateMenu(menu);
    }
}
