package cn.nothsea.service;

import cn.nothsea.dao.CityDao;
import cn.nothsea.pojo.City;

import java.sql.SQLException;
import java.util.List;

public class CityService {

    CityDao cityDao=new CityDao();

    public List<City> findCityByPid(int pid) {
        try {
            return cityDao.findCityByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }

    public List<City> findCityByName(String name) {

        try {
            City city= null;

            city = cityDao.findCityByName(name);

            return cityDao.findCityByPid(city.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }
}
