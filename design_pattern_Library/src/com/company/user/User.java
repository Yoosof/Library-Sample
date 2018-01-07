package com.company.user;

import com.company.util.MyUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by me on 01/02/2017.
 */
public class User {
    int id;
    String name;
    int nationalCode;
    String email;
    String userName;
    String mobileNumber;
    String address;
    boolean is_admin;

    String sql_id = "id";
    String sql_name = "name";
    String sql_nationalCode = "national_code";
    String sql_email = "email";
    String sql_userName = "userName";
    String sql_mobileNumber = "mobile_number";
    String sql_address = "address";
    String sql_is_admin = "is_admin";


    public String toString(){
        return "id: "+id + ", "+"name: " + name + ", "+"nationalCode: " + nationalCode + ", "+"email: " +email + ", "+"username: " +userName + ", "+"mobile: " +mobileNumber + ", "+"address: " +address + ", "+"isAdmin: " +(is_admin?"yes":"no");
    }

    public User(ResultSet rs) throws SQLException {
        this.id = rs.getInt(sql_id);
        this.name = rs.getString(sql_name);
        this.nationalCode = rs.getInt(sql_nationalCode);
        this.email = rs.getString(sql_email);
        this.userName = rs.getString(sql_userName);
        this.mobileNumber = rs.getString(sql_mobileNumber);
        this.address = rs.getString(sql_address);
        int is_admin_int = rs.getInt(sql_is_admin);
        this.is_admin = MyUtils.getBooleanFromInt(is_admin_int);
    }

    public User(){

    }

    public String getUserName() {
        return userName;
    }

    public boolean is_admin() {
        return is_admin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o){
        return ((User)o).getId() == getId();
    }
}
