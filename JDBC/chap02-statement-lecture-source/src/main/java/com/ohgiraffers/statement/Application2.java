package com.ohgiraffers.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

// 사번을 Scanner로 입력 받아서 사원의 정보를 출력하는 프로그램
// 사원의 정보 : emp_id, emp_name, salary
// 없는 사번이면 "해당 사원의 조회 결과가 없습니다." 출력
public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회하고 싶은 사번 : ");
        int empId = sc.nextInt();

        try {
            // Statement stmt = 쿼리를 운반하고 그 결과를 반환하는 객체
            stmt = con.createStatement();
            // ResultSet : Statement 객체를 통해 조회 처리 된 결과를 다루는 객체2
            rset = stmt.executeQuery("SELECT emp_id, emp_name, salary FROM employee WHERE emp_id = " + empId);

            if(rset.next()) {
                String empName = rset.getString("emp_name");
                int salary = rset.getInt("salary");
                System.out.println(empId + " " + empName + " " + salary);
            } else {
                System.out.println("해당 사원의 조회 결과가 없습니다.");
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
