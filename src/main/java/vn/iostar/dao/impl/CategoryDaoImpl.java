package vn.iostar.dao.impl;

import vn.iostar.configs.DBConnectSQL;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public List<CategoryModel> findAll() {
        String sql = "select * from categories";
        List<CategoryModel> list = new ArrayList<>();
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryId(rs.getInt("categoryid"));
                category.setCategoryName(rs.getString("categoryname"));
                category.setImage(rs.getString("image"));
                category.setStatus(rs.getInt("status"));
                list.add(category);
            }
            conn.close();
            ps.close();
            rs.close();
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryModel findById(int id) {
        String sql = "select * from categories where categoryid = ?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryId(rs.getInt("categoryid"));
                category.setCategoryName(rs.getString("categoryname"));
                category.setImage(rs.getString("image"));
                category.setStatus(rs.getInt("status"));
                return category;
            }
            conn.close();
            ps.close();
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "INSERT INTO categories(categoryname,image,status) values(?,?,?)";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getImage());
            ps.setInt(3, category.getStatus());
            ps.executeUpdate();
            conn.close();
            ps.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "UPDATE categories SET categoryname=?,image=?,status=? WHERE categoryid=?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getImage());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, category.getCategoryId());
            ps.executeUpdate();
            conn.close();
            ps.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM categories WHERE categoryid = ?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.close();
            ps.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        String sql = "select * from categories where categoryname like ?";
        List<CategoryModel> list = new ArrayList<>();
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryId(rs.getInt("categoryid"));
                category.setCategoryName(rs.getString("categoryname"));
                category.setImage(rs.getString("image"));
                category.setStatus(rs.getInt("status"));
                list.add(category);
            }
            conn.close();
            ps.close();
            rs.close();
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
