package com.ohgiraffers.common;


import com.mysql.cj.protocol.Resultset;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {
        Properties properties = new Properties();
        Connection con = null;

        try {
            properties.load(new FileReader("src/main/java/com/ohgiraffers/config/jdbc-config.properties"));
            String url = properties.getProperty("url");
            con = DriverManager.getConnection(url,properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    // Connection을 닫는 개념은 별도의 메소드로 분리하고 실제 닫는 시점은 Service 계층에서 진행
    public static void close(Connection con){
        try {
            if(con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt){
        try {
            if(stmt != null && !stmt.isClosed()) stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset){
        try {
            if(rset != null && !rset.isClosed()) rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}