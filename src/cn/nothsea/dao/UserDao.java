package cn.nothsea.dao;

import cn.nothsea.pojo.User;
import cn.nothsea.utils.JDBCUtils2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

//持久层
public class UserDao {

    QueryRunner qr = new QueryRunner(JDBCUtils2.getDataSource());

    public User login(String username, String password) throws SQLException {
        String sql = "select * from user where username=? and password=?";
        return qr. query(sql, new BeanHandler<User>(User.class), username, password);
    }

    public User findUserByName(String username) throws SQLException {
        String sql = "select * from user where username=?";
        return qr.query(sql,new BeanHandler<>(User.class),username);
    }

    public void register(User user) throws SQLException {
        String sql="insert into user values(null,?,?,?)";
        qr.update(sql,user.getUsername(),user.getPassword(),user.getAddress());
    }
}
