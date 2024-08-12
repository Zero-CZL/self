package cn.nothsea.dao;

import cn.nothsea.pojo.Object;
import cn.nothsea.utils.JDBCUtils2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ObjectDao {
    QueryRunner qr = new QueryRunner(JDBCUtils2.getDataSource());

    public List<Object> findAll() throws SQLException {
        String sql = "select * from object";
        return qr.query(sql, new BeanListHandler<>(Object.class));
    }
}
