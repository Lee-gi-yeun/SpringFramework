package com.ohgiraffers.statement;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        try {
            // Statement stmt = 쿼리를 운반하고 그 결과를 반환하는 객체
            stmt = con.createStatement();
            // ResultSet : Statement 객체를 통해 조회 처리 된 결과를 다루는 객체
            rset = stmt.executeQuery("SELECT * FROM employee");

            while (rset.next()) {
                System.out.println(rset.getString("emp_name") + " ");
                System.out.println(rset.getString("salary"));
                System.out.println(rset.getString("emp_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
