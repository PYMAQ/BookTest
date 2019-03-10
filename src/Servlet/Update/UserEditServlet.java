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
 * @Date: 2019/3/10 21:01
 * @Version 1.0
 */
public class UserEditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        User user = new UserDAO().get(id);

    }
}
