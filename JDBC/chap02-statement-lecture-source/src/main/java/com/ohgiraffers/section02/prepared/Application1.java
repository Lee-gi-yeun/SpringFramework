package com.ohgiraffers.section02.prepared;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        // PreparedStatement : 쿼리를 운반하고 결과를 반환하는 객체
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        // 객체 생성 시 수행할 sql 구문을 설정해서 생성한다
        try {
            pstmt = con.prepareStatement("select * from employee");
            // 객체 생성 시 이미 sql 구문은 전달 되었으므로 구문을 전달하지 않는다
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.print(rset.getString("emp_name") + " ");
                System.out.println(rset.getString("salary"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
