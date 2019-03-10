package Servlet.Update;

import Bean.User;
import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ym
 * @Date: 2019/3/6 14:37
 * @Version 1.0
 */
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserUpdateServlet第1步");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
       // User user = new UserDAO().update(id);

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        System.out.println(name);
        System.out.println(password);
        System.out.println("UserUpdateServlet第2步");

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        //new UserDAO().create(user);
        System.out.println("UserUpdateServlet第3步");

        new UserDAO().update(user);
        System.out.println("UserUpdateServlet第4步");

        //3.返回更新的用户列表
        resp.setContentType("text/html; charset=UTF-8");
        resp.sendRedirect("/user");





    }
}
