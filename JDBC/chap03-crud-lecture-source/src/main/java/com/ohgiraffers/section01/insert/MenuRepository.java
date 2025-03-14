package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

// Repository 계층 ( insert ~~ , update ~~, delete ~~ )
// DBMS를 통해 수행 되는 CRUD 작업 단위의 메소드를 정의
public class MenuRepository {

    public int insertMenu(Connection con, Menu menu) {
        PreparedStatement pstmt = null;
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src/main/com/ohgiraffers/section01/insert/MenuMapper.xml"));
            String sql = properties.getProperty("insertMenu");
            pstmt = con.prepareStatement(sql);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
