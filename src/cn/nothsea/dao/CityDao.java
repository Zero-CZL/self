package cn.nothsea.dao;

import cn.nothsea.pojo.City;
import cn.nothsea.utils.JDBCUtils2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CityDao {
    QueryRunner qr =new QueryRunner(JDBCUtils2.getDataSource());

    public List<City> findCityByPid(int pid) throws SQLException {
        String sql = "select * from city where pid=?";
        return qr.query((sql), new BeanListHandler<>(City.class), pid);
    }

    public City findCityByName(String name) throws SQLException {
        String sql = "select * from city where name=?";
        return qr.query(sql, new BeanHandler<>(City.class),name);
    }
}
