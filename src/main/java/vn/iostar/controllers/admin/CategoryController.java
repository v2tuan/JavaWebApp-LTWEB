package vn.iostar.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;
import vn.iostar.services.impl.CategoryServiceImpl;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/categories",
        "/admin/category/add",
        "/admin/category/insert",
        "/admin/category/edit",
        "/admin/category/update",
        "/admin/category/delete",
        "/admin/category/search"})
public class CategoryController extends HttpServlet {

    public ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(url.contains("categories")){
            List<CategoryModel> list = categoryService.findAll();
            req.setAttribute("listcase", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        }
        else if(url.contains("add")){
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        }
        else if(url.contains("edit")){
            String id = req.getParameter("id");
            CategoryModel category = categoryService.findById(Integer.parseInt(id));
            req.setAttribute("cate", category);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        }
        else if(url.contains("delete")){
            String id = req.getParameter("id");
            categoryService.delete(Integer.parseInt(id));
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (url.contains("insert")) {
            String categoryName = req.getParameter("categoryname");
            String status = req.getParameter("status");
            int statuss = Integer.parseInt(status);
            String image = "https://www.apple.com/newsroom/images/2024/09/apple-introduces-iphone-16-and-iphone-16-plus/article/geo/Apple-iPhone-16-finish-lineup-geo-240909_big.jpg.medium_2x.jpg";

            CategoryModel category = new CategoryModel();
            category.setCategoryName(categoryName);
            category.setImage(image);
            category.setStatus(statuss);

            categoryService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
        else if(url.contains("update")){
            int id = Integer.parseInt(req.getParameter("categoryid"));
            String categoryName = req.getParameter("categoryname");
            String status = req.getParameter("status");
            int statuss = Integer.parseInt(status);
            String image = "https://www.apple.com/newsroom/images/2024/09/apple-introduces-iphone-16-and-iphone-16-plus/article/geo/Apple-iPhone-16-finish-lineup-geo-240909_big.jpg.medium_2x.jpg";

            CategoryModel category = new CategoryModel();
            category.setCategoryId(id);
            category.setCategoryName(categoryName);
            category.setImage(image);
            category.setStatus(statuss);

            categoryService.update(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }
}