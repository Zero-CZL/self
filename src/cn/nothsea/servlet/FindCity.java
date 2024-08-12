package cn.nothsea.servlet;

import cn.nothsea.pojo.City;
import cn.nothsea.service.CityService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/findCity")
public class FindCity extends HttpServlet {
CityService cityService = new CityService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid=req.getParameter("pid");
        List<City> shengList=cityService.findCityByPid(Integer.parseInt(pid));
        JSONArray jsonArray = JSONArray.fromObject(shengList);
        resp.getWriter().write(jsonArray.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        List<City> cityList=cityService.findCityByName(name);
        JSONArray jsonArray = JSONArray.fromObject(cityList);
        resp.getWriter().write(jsonArray.toString());
    }
}
