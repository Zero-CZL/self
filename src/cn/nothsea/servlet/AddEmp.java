package cn.nothsea.servlet;

import cn.nothsea.pojo.Emp;
import cn.nothsea.pojo.Object;
import cn.nothsea.service.EmpService;
import cn.nothsea.service.ObjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/servlet/addEmp")
@MultipartConfig //解析二进制表单
public class AddEmp extends HttpServlet {
    ObjectService objectService = new ObjectService();
    EmpService empService = new EmpService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object> objectList=objectService.findAll();

        req.setAttribute("objectList", objectList);

        req.getRequestDispatcher("/jsp/addEmp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ename = req.getParameter("ename");
        String sex =req.getParameter("sex");
        String salary = req.getParameter("salary");
        String[] hobbies = req.getParameterValues("hobby");
        String s = Arrays.toString(hobbies);
        String hobby = s.substring(1, s.length()-1);
        String photo = "default.jpg";
        Part file = req.getPart("file");
        if (file.getSize()>0) {
            photo = System.currentTimeMillis() + ".jpg";
            String realPath=getServletContext().getRealPath("/static/img");
            file.write(realPath+"/"+photo);
            /*new Date().getTime();
            System.currentTimeMillis();
            Calendar.getInstance().getTimeInMillis();*/
            /*
        String photo = "default.jpg";
        Part file=req.getPart("file");
        if(file.getSize()>0){
            photo=System.currentTimeMillis()+".jpg";
        }
        */
        }
        String object_id = req.getParameter("object_id");


        empService.addEmp(new Emp(null,ename,sex,Double.parseDouble(salary),hobby,photo,Integer.parseInt(object_id)));

        resp.sendRedirect(req.getContextPath()+"/servlet/empShow");
    }
}
