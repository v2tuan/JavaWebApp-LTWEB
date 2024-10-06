package vn.iostar.services.impl;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDaoImpl;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    public ICategoryDao cateDao = new CategoryDaoImpl();
    @Override
    public List<CategoryModel> findAll() {
        return cateDao.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return cateDao.findById(id);
    }

    @Override
    public void insert(CategoryModel category) {
        cateDao.insert(category);
    }

    @Override
    public void update(CategoryModel category) {
        CategoryModel cate = new CategoryModel();
        cate = cateDao.findById(category.getCategoryId());
        if(cate != null) {
            cateDao.update(category);
        }
    }

    @Override
    public void delete(int id) {
        CategoryModel cate = new CategoryModel();
        cate = cateDao.findById(id);
        if(cate != null) {
            cateDao.delete(id);
        }
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        return cateDao.findName(keyword);
    }
}
