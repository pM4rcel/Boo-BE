package com.example.booo.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/users", "/users/*"})
public class UserController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        if(request.getRequestURI().split("/").length == 5){

            //TODO get user by id
            out.println("single user " + request.getRequestURI().split("/")[4]);

        }else if (request.getRequestURI().split("/").length == 4){
            //out.println(request.getRequestURI().split("/")[1]);

            //TODO get all users

            out.println("all users");
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
