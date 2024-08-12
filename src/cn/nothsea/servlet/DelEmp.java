package cn.nothsea.servlet;

import cn.nothsea.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/delEmp")
public class DelEmp extends HttpServlet {
    EmpService empService = new EmpService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("ids");
        String[] split = ids.split("-");
        for (String id:split) {
            empService.deleteById(Integer.parseInt(id));
        }
        resp.sendRedirect(req.getContextPath() + "/servlet/empShow");
    }
}
