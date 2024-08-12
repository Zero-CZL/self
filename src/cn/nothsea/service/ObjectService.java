package cn.nothsea.service;

import cn.nothsea.dao.ObjectDao;
import cn.nothsea.pojo.Object;

import java.sql.SQLException;
import java.util.List;

public class ObjectService {
    ObjectDao objectDao=new ObjectDao();

    public List<Object> findAll() {
        try {
            return objectDao.findAll();
        }catch (SQLException e){
            e.printStackTrace();
        }return null;
    }
}
