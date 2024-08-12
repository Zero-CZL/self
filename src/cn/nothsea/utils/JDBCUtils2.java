package cn.nothsea.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils2 {
    private static ComboPooledDataSource dataSource=null;
    static {
        dataSource=new ComboPooledDataSource();
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
