package cn.nothsea.servlet;

import cn.nothsea.pojo.User;
import cn.nothsea.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//控制层
@WebServlet("/servlet/login")
public class Login extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //处理请求
        User user=userService.login(username,password);
        //完成响应
        if(user==null){
            //登录失败 保存失败信息 转发到登录界面
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        }else {
            //登陆成功 利用session保存用户信息 重定向
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"/servlet/empShow");
        }
    }
}
