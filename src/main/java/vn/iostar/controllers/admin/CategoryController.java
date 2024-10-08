package vn.iostar.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;
import vn.iostar.services.impl.CategoryServiceImpl;
import static vn.iostar.utils.Constant.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
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
            CategoryModel category = new CategoryModel();
            String categoryName = req.getParameter("categoryname");
            String status = req.getParameter("status");
            int statuss = Integer.parseInt(status);
            category.setCategoryName(categoryName);
            category.setStatus(statuss);
            String fname="";
            String uploadPath = DIR; // vì import static nên không cần Constant.DIR
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part part = req.getPart("image");
                if (part.getSize() > 0) {
                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // Doi ten file
                    int index = fileName.lastIndexOf(".");
                    String ext = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + ext;
                    // upload file
                    part.write(uploadPath + "/" +fname);

                    // ghi ten file vao data
                    category.setImage(fname);
                }
                else{
                    category.setImage("avata.png");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            categoryService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
        else if(url.contains("update")){
            int id = Integer.parseInt(req.getParameter("categoryid"));
            String categoryName = req.getParameter("categoryname");
            String status = req.getParameter("status");
            int statuss = Integer.parseInt(status);

            CategoryModel category = new CategoryModel();
            category.setCategoryId(id);
            category.setCategoryName(categoryName);
            category.setStatus(statuss);

            // luu hinh anh cu
            CategoryModel cateold = categoryService.findById(id);
            String fileld = cateold.getImage();
            // xu ly image
            String fname="";
            String uploadPath = DIR; // vì import static nên không cần Constant.DIR
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part part = req.getPart("image");
                if (part.getSize() > 0) {
                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // Doi ten file
                    int index = fileName.lastIndexOf(".");
                    String ext = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + ext;
                    // upload file
                    part.write(uploadPath + "/" +fname);

                    // ghi ten file vao data
                    category.setImage(fname);
                }
                else{
                    category.setImage(fileld);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            categoryService.update(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }
}