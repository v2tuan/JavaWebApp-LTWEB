package vn.iostar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserService;
import vn.iostar.utils.Constant;

import java.io.IOException;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

    // lấy toàn bộ hàm trong service
    IUserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // Lấy tham số từ view
        String username = req.getParameter("uname");
        String password = req.getParameter("psw");

        String remember = req.getParameter("remember");

        // Kiểm tra tham số
        boolean isRememberMe = false;
        if ("on".equals(remember)) {
            isRememberMe = true;
        }
        String alertMsg = "";
        if (username.isEmpty() || password.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        // sử lý bài toán

        UserModel user = service.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            if (isRememberMe) {
                saveRemeberMe(resp, username);
            }
            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    private void saveRemeberMe(HttpServletResponse resp, String username) {
        // TODO Auto-generated method stub
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30 * 60);
        resp.addCookie(cookie);
    }
}
