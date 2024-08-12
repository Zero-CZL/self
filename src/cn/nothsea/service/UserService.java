package cn.nothsea.service;

import cn.nothsea.dao.UserDao;
import cn.nothsea.pojo.User;

import java.sql.SQLException;

//业务层
public class UserService {

    UserDao userDao = new UserDao();

    public User login(String username, String password) {
        try {
            return userDao.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }

    public User findUserByName(String username) {
        try {
            return userDao.findUserByName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void register(User user) {
        try {
            userDao.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
