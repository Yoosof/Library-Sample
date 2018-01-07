package com.company.ui.widget;

import com.company.dao.BookDao;
import com.company.dao.UserDao;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by me on 02/02/2017.
 */
public class UserInfoObserver extends JLabel implements Observer {
    public UserInfoObserver(){
        update(UserDao.instance(), null);
    }
    @Override
    public void update(Observable o, Object arg) {
        try {
            int allUserCount = ((UserDao) o).getAllUserCount();
            int allCustomerCount = ((UserDao) o).getAllCustomerCount();
            setText("all user count: "+allUserCount+", all customer count: "+allCustomerCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
