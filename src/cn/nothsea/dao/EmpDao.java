package cn.nothsea.dao;

import cn.nothsea.pojo.Emp;
import cn.nothsea.pojo.EmpVo;
import cn.nothsea.pojo.Num;
import cn.nothsea.pojo.PageBean;
import cn.nothsea.utils.JDBCUtils2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDao {
    QueryRunner qr = new QueryRunner(JDBCUtils2.getDataSource());

    public PageBean<EmpVo> findAll(int pageNum, int pageSize) throws SQLException {
        PageBean<EmpVo> pageBean  = new PageBean<>();
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);

        String sql1 = "select count(*) from emp";

        Number o = (Number) qr.query(sql1, new ScalarHandler());
        int total =o.intValue();
        pageBean.setTotal(total);

        String sql2 ="select\n" +
                "    e.eid,e.ename,e.sex,e.salary,e.hobby,e.photo,o.oname\n" +
                "    from emp e,object o\n" +
                "where e.object_id=o.id\n" +
                "order by e.eid\n" +
                "limit ?,?";

        List<EmpVo> list = qr.query(sql2, new BeanListHandler<>(EmpVo.class), (pageNum - 1) * pageSize, pageSize);
        pageBean.setBeanList(list);
        return pageBean;
    }

    public PageBean<EmpVo> like(int pageNum, int pageSize, String likeName) throws SQLException {
        PageBean<EmpVo> pageBean  = new PageBean<>();
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);

        String sql1 = "select count(*) from emp where ename like ?";
        Number o = (Number) qr.query(sql1, new ScalarHandler(),"%"+likeName+"%");
        int total =o.intValue();
        pageBean.setTotal(total);

        String sql2 ="select\n" +
                "    e.eid,e.ename,e.sex,e.salary,e.hobby,e.photo,o.oname\n" +
                "    from emp e,object o\n" +
                "where e.object_id=o.id and e.ename like ?\n" +
                "order by e.eid\n" +
                "limit ?,?";

        List<EmpVo> list = qr.query(sql2, new BeanListHandler<>(EmpVo.class), "%"+likeName+"%",(pageNum - 1) * pageSize, pageSize);
        pageBean.setBeanList(list);
        return pageBean;
    }

    public void addEmp(Emp emp) throws SQLException {
        String sql ="insert into emp values(null,?,?,?,?,?,?)";
        qr.update(sql,emp.getEname(),emp.getSex(),emp.getSalary(),emp.getHobby(),emp.getPhoto(),emp.getObject_id());
    }

    public Emp findById(int eid) throws SQLException {
        String sql = "select * from emp where eid=?";
        return qr.query(sql,new BeanHandler<>(Emp.class),eid);
    }

    public void updateEmp(Emp emp) throws SQLException {
        String sql="update emp set ename=?,sex=?,salary=?,hobby=?,photo=?,object_id=? where eid=?";
        qr.update(sql,emp.getEname(),emp.getSex(),emp.getSalary(),emp.getHobby(),emp.getPhoto(),emp.getObject_id(),emp.getEid());
    }

    public void deleteById(int id) throws SQLException {

        String sql="delete from emp where eid=?";
        qr.update(sql,id);
    }

    public List<Num> echarts() throws SQLException {
        String sql="SELECT ANY_VALUE(o.oname) as 'name',COUNT(*) num\n" +
                "FROM emp as e,object as o \n" +
                "WHERE e.object_id=o.id GROUP BY e.object_id";
        return qr.query(sql,new BeanListHandler<>(Num.class));
    }
}


