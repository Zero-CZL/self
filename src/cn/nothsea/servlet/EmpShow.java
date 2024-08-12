package cn.nothsea.servlet;

import cn.nothsea.pojo.EmpVo;
import cn.nothsea.pojo.PageBean;
import cn.nothsea.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/empShow")
public class EmpShow extends HttpServlet {
    EmpService empService = new EmpService();

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String likeName=req.getParameter("likeName");
         String pageNum1 = req.getParameter("pageNum");
         int pageNum = (pageNum1 == null ||pageNum1.trim()=="")?1:Integer.parseInt(pageNum1);
         int pageSize =3;
         PageBean<EmpVo> pageBean=null;
         if (likeName==null||likeName.trim()==""){
             pageBean=empService.findAll(pageNum,pageSize);
         }else {

             pageBean=empService.like(pageNum,pageSize,likeName);
             req.setAttribute("likeName", likeName);
         }

        //做出响应
        req.setAttribute("pageBean", pageBean);
        req.getRequestDispatcher("/jsp/empList.jsp").forward(req, resp);

    }
}
