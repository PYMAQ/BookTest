package DAO;

import Bean.Hero;
import Bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/3/2 21:41
 * @Version 1.0
 */
public class UserDAO {
    public UserDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
                "admin");
    }

    /**
     * 获取全部用户数量
     * @return
     */
    public int getTotal(){
        int total=0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from user";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }

            System.out.println("total users:" + total);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }


    /**
     *userList获取用户列表
     */
    public List<User> userList() { return userList(0, Short.MAX_VALUE);}
    public List<User> userList(int start,int count) {
        List<User> users = new ArrayList<User>();

        String sql = "select * from user order by id limit ?,? ";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            //范围//start//count
            //从第一列的第四个开始
            ps.setInt(1, start);
            //从第一列的第四个开始共5个
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                //试试1String password = rs.getString(3);
                //int damage = rs.getInt(4);
                user.id = id;
                user.name = name;
                user.password = password;
                users.add(user);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return users;
    }

    /**
     * 新增Creat
     */
    public void create(User user) {
        //如果添加过主键自增（PRINARY KEY AUTO_INCREMENT）第一列在增加数据的时候，可以写为0或者null，
        // 这样添加数据可以自增， 从而可以添加全部数据，而不用特意规定那几列添加数据。
        String sql = "insert into user values(null,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, user.name);
            ps.setString(2, user.password);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id =rs.getInt(1);
                user.id = id;
               /* String  name =rs.getString(1);
                String password =rs.getString(2);
                user.name = name;
                user.password = password;*/
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * 删除Delete
     */
    public void delete(int id){
        //1.sql语句
        try(Connection c = getConnection();Statement s =c.createStatement();){
            String sql ="delete from user where id = " + id;
            s.execute(sql);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 更新update
     */
    public  void update(User user){
        System.out.println("更新第1步");
        String sql = "update user set name=?,password=? where name=? ";
        System.out.println("更新第2步");
        try(Connection c = getConnection();PreparedStatement ps =c.prepareStatement(sql);){
            System.out.println("更新第3步");
            ps.setString(1,user.name);
            ps.setString(2,user.password);
            ps.setString(3,user.name);

            ps.execute();
        }catch (Exception e){
            System.out.println("更新第4步");
            e.printStackTrace();
        }

    }

    /**
     * 获取用户id
     */
    public User get(int id) {
        User user = null;

        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from user where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                user = new User();
                String name = rs.getString(1);
                String password = rs.getString(2);
                user.name = name;
                user.password=password;
                user.id = id;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return user;
    }


}
