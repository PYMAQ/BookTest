package Servlet;

import Bean.User;
import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ym
 * @Date: 2019/3/5 12:36
 * @Version 1.0
 */
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //统一格式
        req.setCharacterEncoding("UTF-8");

        //1.获取表单填写的添加信息
        String name = req.getParameter("name");
        String password =req.getParameter("password");

        //2.获取数据库数据
       // List<User>  users =new UserDAO().userslist();

        //2.添加进去数据库
        User user =new User(name,password);
        new UserDAO().create(user);
        System.out.println("11111");

       // resp.setContentType("text/html; charset=UTF-8");




    }
}
