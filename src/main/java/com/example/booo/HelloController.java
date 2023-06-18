package com.example.booo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/hello"})
public class HelloController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        if(request.getRequestURI().equals("/hello")){
            out.println("hello world");
        }else{
            out.println(request.getRequestURI().split("/")[1]);
        }
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        out.println("Resource Created");
        out.close();
    }
}