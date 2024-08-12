package cn.nothsea.servlet;

import cn.nothsea.pojo.Num;
import cn.nothsea.service.EmpService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/echarts")
public class Echarts extends HttpServlet {
    EmpService empService = new EmpService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Num> numList=empService.echarts();

        JSONArray jsonArray = JSONArray.fromObject(numList);
        req.setAttribute("numList", jsonArray.toString());
        req.getRequestDispatcher("/jsp/echarts.jsp").forward(req, resp);
    }
}
