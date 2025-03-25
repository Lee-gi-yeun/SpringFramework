package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService(){
        this.menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int menuCode) {
        return null;
    }

    public boolean registMenu(MenuDTO menu) {
        return false;
    }

    public boolean modifyMenu(MenuDTO menu) {
        return false;
    }

    public boolean deleteMenu(int menuCode) {
        return false;
    }

}
