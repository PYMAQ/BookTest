package Servlet.Delete;

import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ym
 * @Date: 2019/3/5 20:33
 * @Version 1.0
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.中文格式
        req.setCharacterEncoding("UTF-8");

        //2.删除
        int id = Integer.parseInt(req.getParameter("id"));

        new UserDAO().delete(id);
        //3.返回更新的用户列表
        resp.setContentType("text/html; charset=UTF-8");
        resp.sendRedirect("/user");
    }
}
