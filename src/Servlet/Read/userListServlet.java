package Servlet.Read;

import Bean.Hero;
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
 * @Date: 2019/3/4 20:28
 * @Version 1.0
 */
public class userListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        List<User> users =  new UserDAO().userList();
        //获取全部用户数量 作为请求发出去给浏览器
       // int userToal =new UserDAO()


        //格式化
        StringBuffer sb = new StringBuffer();
        sb.append("<title>注册用户列表</title>");
        sb.append("<h1 align='center' >已经注册用户列表</h1>");
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td><td>password</td><td>Update</td><td>delete</td></tr>\r\n");

        String trFormat = "<tr><td>%d</td><td>%s</td><td>%s</td><td><a href='UpdateUser.html?id=%d'>edit</a></td><td><a href='deleteUser?id=%d'>delete</a></td>\r\n";
      //  System.out.println("UserListServlet第1步");

        for (User user : users) {
            String tr = String.format(trFormat, user.getId(), user.getName(),user.getPassword(),user.getId(),user.getId());
            sb.append(tr);
        }
      //  System.out.println("UserListServlet第2步");
        sb.append("</table>");
        //表格
      //  System.out.println("UserListServlet第3步");

        response.setContentType("text/html; charset=UTF-8");

        response.getWriter().write(sb.toString());
      //  System.out.println("UserListServlet第4步");

        //发出去resp
        //StringBuffer stringBuffer =new StringBuffer();
        //stringBuffer.append(userToal);
        //response.getWriter().write(stringBuffer.toString());
    }
}
