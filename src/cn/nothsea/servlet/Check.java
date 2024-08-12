package cn.nothsea.servlet;

import cn.nothsea.pojo.User;
import cn.nothsea.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/check")
public class Check extends HttpServlet {
    UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = userService.findUserByName(username);
        if (user == null) {
            resp.getWriter().write("OK");
        } else {
            resp.getWriter().write("ERROR");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = userService.findUserByName(username);
        if (user == null) {
            resp.getWriter().write("OK");
        } else {
            resp.getWriter().write("ERROR");
        }
    }
}
