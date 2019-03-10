package Servlet.Creat;

import Bean.User;
import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/3/2 21:12
 * @Version 1.0
 */
public class RegisterServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //格式utf-8
        req.setCharacterEncoding("UTF-8");

        //1.获取表单填写的添加信息
        String name = req.getParameter("name");
        String password =req.getParameter("password");
        String passwordAgain  = req.getParameter("passwordAgain");

        System.out.println(name);
        System.out.println(password);
        System.out.println(passwordAgain);
        //2.匹配数据库
        List<User> users =new UserDAO().userList();
        //数据库还没有该用户的name，可以注册
        boolean flag =false;
        String html =null;
        for(User user :users){
            if(name.equals(user.getName())){
                //数据库已经有用户的name了。
                flag = true;
                break;
            }
        }
        //3.添加进去数据库
        if(!flag && password.equals(passwordAgain)){
            html="<div align='color:green'>注册成功，请跳转</div>";
            User user =new User(name,password);
            new UserDAO().create(user);
            resp.sendRedirect("/login.html");
        }
        /*else if((!flag) &&(password!=passwordAgain) ){
            html="<div align='color:green'>注册失败，密码不一致</div>";
            resp.sendRedirect("/register.html");
        }*/
        else{
            html="<div align='color:green'>注册失败，已有用户</div>";
        }

        //返回的时候返回中文
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write(html);




    }
}
