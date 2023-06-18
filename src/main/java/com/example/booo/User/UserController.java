package com.example.booo.User;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;

@WebServlet(urlPatterns = {"/users", "/users/*"})
public class UserController extends HttpServlet {
    private final UserService userService = new UserService();

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
