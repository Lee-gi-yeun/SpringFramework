package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.jdbc.SQL;

public class SqlBuilderProvider {

    public String insertMenu(MenuDTO menuDTO) {
        return new SQL()
                .INSERT_INTO("tbl_menu")
                .VALUES("menu_name", "#{menuName}")
                .VALUES("menu_price", "#{menuPrice}")
                .VALUES("category_code", "#{categoryCode}")
                .VALUES("orderable_status", "#{orderableStatus}")
                .toString();
    }

    // 전달 파라미터가 유효한 값(문자열의 경우 빈 문자열이 아니여야 하고 숫자의 경우 0 이상)을 가질
    // 경우에만 수정에 반영하는 동적 쿼리로 구현
    public String updateMenu(MenuDTO menuDTO) {
        SQL sql = new SQL().UPDATE("tbl_menu");

        if (menuDTO.getMenuName() != null && !menuDTO.getMenuName().isEmpty()) {
            sql.SET("menu_name = #{menuName}");
        }
        if (menuDTO.getMenuPrice() > 0) {
            sql.SET("menu_price = #{menuPrice}");
        }
        if (menuDTO.getCategoryCode() > 0) {
            sql.SET("category_code = #{categoryCode}");
        }
        if (menuDTO.getOrderableStatus() != null && !menuDTO.getOrderableStatus().isEmpty()) {
            sql.SET("orderable_status = #{orderableStatus}");
        }
        sql.WHERE("menu_code = #{menuCode}");

        return sql.toString();
    }

    public String deleteMenu() {
        return new SQL()
                .DELETE_FROM("tbl_menu")
                .WHERE("menu_code = #{menuCode}")
                .toString();
    }
}
