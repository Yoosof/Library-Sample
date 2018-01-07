package com.company.dao;

import com.company.book.Book;
import com.company.user.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Created by me on 01/02/2017.
 */
public class UserDao extends Observable{
    private static UserDao uniqueInstance = new UserDao();
    private UserDao(){

    }
    public static UserDao instance(){
        return uniqueInstance;
    }

    public int registerUser(String name, int nationalCode, String email, String mobileNumber, String address, String password, String userName, int is_admin) throws SQLException {
        int status=0;
        Connection con=DB.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into user(name,password,is_admin,national_code,email,mobile_number,address,username) values(?,?,?,?,?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,password);
        ps.setInt(3,is_admin);
        ps.setInt(4,nationalCode);
        ps.setString(5,email);
        ps.setString(6,mobileNumber);
        ps.setString(7,address);
        ps.setString(8,userName);
        status=ps.executeUpdate();
        if(status != 0){
            this.setChanged();
            this.notifyObservers();
        }

        con.close();
        return status;
    }

    public User login(String userName, String password) throws SQLException {
        Connection con=DB.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM user where username='"+ userName + "' and password='" +password + "' limit 1;");
        ResultSet rs = st.executeQuery(sql);
        User u;
        if(rs.next()) {
            u = new User(rs);
        }else {
            throw new SQLException();
        }
        con.close();
        return u;
    }

    public int deleteUser(int id)throws  SQLException{
        int status = 0;
        Connection con=DB.getConnection();
        String query = "delete from user where id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);

        // execute the preparedstatement
        status = preparedStmt.executeUpdate();
        if(status != 0){
            this.setChanged();
            this.notifyObservers();
        }

        con.close();
        return status;
    }

    public User getUser(int userId) throws SQLException {
        Connection con=DB.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM user where id = " +userId + " limit 1;");
        ResultSet rs = st.executeQuery(sql);
        User u;
        if(rs.next()) {
            u = new User(rs);
        }else {
            throw new SQLException();
        }
        con.close();
        return u;

    }

    public List<User> getAllUsers() throws SQLException {
        Connection con=DB.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM user");
        ResultSet rs = st.executeQuery(sql);
        List<User> users = new LinkedList<>();
        while(rs.next()) {
            users.add(new User(rs));
        }
        con.close();
        return users;

    }

    public int getAllUserCount() throws SQLException {
        Connection con=DB.getConnection();
        String query = "select count(*) from user";
        Statement stm = con.createStatement();

        // execute the preparedstatement
        ResultSet resultSet = stm.executeQuery(query);
        int count = 0;
        if(resultSet.next()){
            count = resultSet.getInt(1);
        }

        con.close();
        return count;

    }

    public int getAllCustomerCount() throws SQLException {
        Connection con=DB.getConnection();
        String query = "select count(*) from user where is_admin=0";
        Statement stm = con.createStatement();

        // execute the preparedstatement
        ResultSet resultSet = stm.executeQuery(query);
        int count = 0;
        if(resultSet.next()){
            count = resultSet.getInt(1);
        }

        con.close();
        return count;

    }

}
