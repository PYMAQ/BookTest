package Servlet;

import Bean.User;
import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/3/2 20:53
 * @Version 1.0
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        //1.获取返回的信息
       String name = req.getParameter("name");
       String password = req.getParameter("password");
       //2.匹配
        boolean flag =false;
        List<User> users =new UserDAO().userList();
        for(User user :users){
            if(name.equals(user.getName()) && password.equals(user.getPassword())){
                flag=true;
            }
        }

        //3.根据匹配情况 返回对应结果
       String html =null;
       if(flag){
           html ="<div style='color:green'>登陆成功！</div>";

       }
       else{
           html = "<div style='color:red'>登陆失败 </div>";
       }
        PrintWriter pw =resp.getWriter();
        pw.println(html);

        //控制台输出：
       System.out.println("name:"+name);
       System.out.println("password："+password);

    }
}
