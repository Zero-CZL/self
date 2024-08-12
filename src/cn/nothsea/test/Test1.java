package cn.nothsea.test;
import cn.nothsea.utils.JDBCUtils;
import cn.nothsea.utils.JDBCUtils2;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;

public class Test1 {
    public static boolean login(String username, String password) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from user where username=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
    public static void main(String[] args) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils2.getDataSource());
        String[] strs={"叶霖","时零","张零","王零"};
        String sql="insert into emp values(null,?,?,?,?,?,?)";
        for(int i=0;i<=30;i++){
            qr.update(sql,strs[(int)Math.random()*4],25,"男","上海",182,(int)Math.random()*4+1);
        }
    }
}