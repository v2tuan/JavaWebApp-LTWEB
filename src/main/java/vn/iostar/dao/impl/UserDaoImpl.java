package vn.iostar.dao.impl;

import vn.iostar.configs.DBConnectSQL;
import vn.iostar.dao.IUserDao;
import vn.iostar.models.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBConnectSQL implements IUserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<UserModel> findAll() {
        String sql = "select * from [Users]";

        List<UserModel> list = new ArrayList<>();

        try {
            conn = super.getConnection(); // mở kết nối
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
                        rs.getString("password"), rs.getString("fullname"), rs.getString("avatar"), rs.getInt("roleid"),
                        rs.getString("phone"), rs.getDate("createdDate")));
            }
            return list;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel findByID(int id) {
        String sql = "SELECT * FROM [UserS] WHERE id = ? ";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("avatar"));
                user.setRoleID(Integer.parseInt(rs.getString("roleid")));
                user.setPhone(rs.getString("phone"));
                user.setCreateDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO Users(email, username, fullname, password, avatar, roleid, phone, createdDate)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = super.getConnection();

            ps = conn.prepareStatement(sql);

//			ps.setInt(1, user.getId());
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getImage());
            ps.setInt(6, user.getRoleID());
            ps.setString(7, user.getPhone());
            ps.setDate(8, user.getCreateDate());

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public UserModel findByUserName(String username) {
        String sql = "SELECT * FROM [UserS] WHERE username = ? ";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("avatar"));
                user.setRoleID(Integer.parseInt(rs.getString("roleid")));
                user.setPhone(rs.getString("phone"));
                user.setCreateDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkExistUsername(String username) {
        boolean duplicate = false;
        String query = "select * from [user] where username = ?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
        }
        return duplicate;
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        String query = "select * from [user] where email = ?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
        }
        return duplicate;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        boolean duplicate = false;
        String query = "select * from [user] where phone = ?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
        }
        return duplicate;
    }
}
