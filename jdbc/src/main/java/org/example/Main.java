package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root","*Siddarth29");
            System.out.println("connection established");

            Statement stm=conn.createStatement();
            System.out.println("Statement created");

            String query="select id,name from actors";
            ResultSet rs= stm.executeQuery(query);

            while(rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
            conn.close();
            stm.close();
            rs.close();
            System.out.println("Resources closed");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
