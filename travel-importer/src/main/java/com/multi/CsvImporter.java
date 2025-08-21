package com.multi;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import com.opencsv.CSVReader;

public class CsvImporter {
    static final String URL = "jdbc:mysql://localhost:3306/travel_db?useSSL=false&serverTimezone=Asia/Seoul&characterEncoding=utf8";
    static final String USER = "jdbctest";
    static final String PASS = "jdbctest";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            conn.setAutoCommit(false);
            String sql = "INSERT INTO travel(district, title, description, address, phone) VALUES(?,?,?,?,?)";

            try(PreparedStatement ps = conn.prepareStatement(sql);
                CSVReader reader = new CSVReader(
                        new InputStreamReader(
                                CsvImporter.class.getResourceAsStream("/travel.csv"), StandardCharsets.UTF_8
                        )
                )
            ){
                String [] row;
                boolean headerSkipped = false;
                while((row = reader.readNext()) != null){
                    if(!headerSkipped){ headerSkipped = true; continue;}
                    ps.setString(1, row[1]);
                    ps.setString(2, row[2]);
                    ps.setString(3, row[3]);
                    ps.setString(4, row[4]);
                    ps.setString(5, row[5]);
                    ps.addBatch();
                }
                ps.executeBatch();
                conn.commit();
                System.out.println("success");
            } catch(Exception e){
                conn.rollback();
                throw e;
            }
        }
    }


}
