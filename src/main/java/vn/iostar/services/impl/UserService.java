package vn.iostar.services.impl;

import vn.iostar.dao.IUserDao;
import vn.iostar.dao.impl.UserDaoImpl;
import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;

public class UserService implements IUserService {

    // Lấy toàn bộ hàm trong tầng Dao của user
    IUserDao userDao = new UserDaoImpl();

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.findByUserName(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public UserModel findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public void insert(UserModel user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        UserModel user = new UserModel(username, email, password, fullname, null, 5, phone, date);
        System.out.println(user);
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    // main dùng để test
    public static void main(String[] args) {
        System.out.print(new UserService().login("1", "1"));
    }
}
