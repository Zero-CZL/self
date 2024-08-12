package cn.nothsea.servlet;

import cn.nothsea.pojo.User;
import cn.nothsea.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/register")
public class Register extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sheng = req.getParameter("sheng");
        String shi = req.getParameter("shi");

        userService.register(new User(null,username, password, sheng+"-"+shi));

        resp.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
    }
}
