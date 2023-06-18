package com.example.booo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HelloController", value = "/api/hello")
public class HelloController extends HttpServlet {
    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println("hello world");
        out.close();
//        out.println("<h1>Hello</h1>");
//        out.println("</body></html>");

    }

//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        PrintWriter out = response.getWriter();
//        out.println("Resource Created");
//        response.setStatus(200);
//        out.close();
//    }

    @Override
    public void destroy() {
    }
}