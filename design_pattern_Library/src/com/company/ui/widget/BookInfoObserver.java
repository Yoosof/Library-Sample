package com.company.ui.widget;

import com.company.dao.BookDao;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by me on 02/02/2017.
 */
public class BookInfoObserver extends JLabel implements Observer {
    public BookInfoObserver(){
        update(BookDao.instance(), null);
    }
    @Override
    public void update(Observable o, Object arg) {
        try {
            int size = ((BookDao) o).getBooksCount();
            setText("book count: "+size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
