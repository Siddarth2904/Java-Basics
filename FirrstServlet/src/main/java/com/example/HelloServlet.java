package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Initialized - Connecting to Database");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db",
                    "root",
                    "password"
            );

            System.out.println("Database Connected Successfully!");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found!");
            throw new ServletException("JDBC Driver not found", e);
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            throw new ServletException("Database connection failed", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Service Method Called - Processing Request");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Get the ID parameter from HTML form
        String idParam = request.getParameter("id");

        // Validate input
        if (idParam == null || idParam.trim().isEmpty()) {
            out.print("{\"error\": \"Please provide a student ID\"}");
            out.close();
            return;
        }

        try {
            int studentId = Integer.parseInt(idParam);

            // Query the database
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, studentId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Student found - return JSON data
                String jsonResponse = String.format(
                        "{" +
                                "\"id\": %d," +
                                "\"roll_number\": \"%s\"," +
                                "\"student_name\": \"%s\"," +
                                "\"class\": \"%s\"," +
                                "\"parent_contact\": \"%s\"" +
                                "}",
                        rs.getInt("id"),
                        rs.getString("roll_number"),
                        rs.getString("student_name"),
                        rs.getString("class"),
                        rs.getString("parent_contact") != null ? rs.getString("parent_contact") : ""
                );
                out.print(jsonResponse);
                System.out.println("Student found - ID: " + studentId);
            } else {
                // Student not found
                out.print("{\"error\": \"No student found with ID: " + studentId + "\"}");
                System.out.println("Student not found - ID: " + studentId);
            }

            rs.close();
            pstmt.close();

        } catch (NumberFormatException e) {
            out.print("{\"error\": \"Invalid ID format. Please enter a number.\"}");
        } catch (SQLException e) {
            out.print("{\"error\": \"Database error: " + e.getMessage() + "\"}");
            e.printStackTrace();
        }

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed - Closing Database Connection");
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.destroy();
    }
}
