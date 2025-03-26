package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.getSqlSession;

public class SqlBuilderService {
    public void registMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        SqlBuilderMapper mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.insertMenu(menuDTO);

        if(result > 0){
            sqlSession.commit();
            System.out.println("신규 메뉴 등록 완료");

        }else {
            sqlSession.rollback();
            System.out.println("신규 메노 등록 실패");
        }
        sqlSession.close();
    }


    public void modifyMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        SqlBuilderMapper mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.updateMenu(menuDTO);

        if(result > 0){
            sqlSession.commit();
            System.out.println("메뉴 정보 변경을 완료했습니다.");

        }else {
            sqlSession.rollback();
            System.out.println("메뉴 정보 변경에 실패했습니다.");
        }
        sqlSession.close();

    }

    public void deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        SqlBuilderMapper mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.deleteMenu(menuCode);

        if(result > 0){
            sqlSession.commit();
            System.out.println("메뉴 삭제를 완료했습니다.");

        }else {
            sqlSession.rollback();
            System.out.println("메뉴 삭제에 실패했습니다.");
        }
        sqlSession.close();
    }
}
