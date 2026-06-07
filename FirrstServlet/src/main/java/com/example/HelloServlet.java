package com.example;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    public void service(HttpServletRequest req,HttpServletResponse res) {
        try{
//            PrintWriter out =res.getWriter();
//            out.println("<h1>Hello World!</h1>");
            res.sendRedirect("hello.html");
        }catch(Exception e){
            System.out.println(e);
        }

    }
}