package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        // statement에 들어갈 값 : namespace.id
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }
}
