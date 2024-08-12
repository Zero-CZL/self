package cn.nothsea.service;

import cn.nothsea.dao.EmpDao;
import cn.nothsea.pojo.Emp;
import cn.nothsea.pojo.EmpVo;
import cn.nothsea.pojo.Num;
import cn.nothsea.pojo.PageBean;

import java.sql.SQLException;
import java.util.List;

public class EmpService {
    EmpDao empDao = new EmpDao();

    
    public PageBean<EmpVo> findAll(int pageNum, int pageSize) {
        try {
            return empDao.findAll (pageNum,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PageBean<EmpVo> like(int pageNum, int pageSize, String likeName) {
        try {
            return empDao.like (pageNum,pageSize,likeName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addEmp(Emp emp) {
        try {
            empDao.addEmp(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Emp findById(int eid) {
        try {
            return empDao.findById(eid);
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }

    public void updateEmp(Emp emp) {
        try {
            empDao.updateEmp(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id){
        try {
            empDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Num> echarts() {
        try {
            return empDao.echarts();
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }
}
