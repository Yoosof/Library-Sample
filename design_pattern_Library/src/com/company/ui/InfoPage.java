package com.company.ui;

import com.company.Repository;
import com.company.dao.BookDao;
import com.company.dao.UserDao;
import com.company.request_book.RequestBook;
import com.company.ui.gui_factory.GuiFactory;
import com.company.ui.widget.BookInfoObserver;
import com.company.ui.widget.RequestPrinterSelectionList;
import com.company.ui.widget.ThemeSelectionList;
import com.company.ui.widget.UserInfoObserver;

import javax.swing.*;
import java.awt.*;

/**
 * Created by me on 02/02/2017.
 */
public class InfoPage  extends JFrame {
    private static final long serialVersionUID = 1L;

    public InfoPage(){
        initUI();
    }

    private void initUI(){
        getContentPane().removeAll();
        getContentPane().setLayout(null);

        BookInfoObserver bookInfoObserver = new BookInfoObserver();
        BookDao.instance().addObserver(bookInfoObserver);
        add(bookInfoObserver);
        bookInfoObserver.setBounds(5, 5, 300, 50);

        UserInfoObserver userInfoObserver = new UserInfoObserver();
        UserDao.instance().addObserver(userInfoObserver);
        add(userInfoObserver);
        userInfoObserver.setBounds(5, 60, 300, 50);

        setSize(305, 305);
        setBounds(new Rectangle(1010, 0, 305, 305));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        validate();
        setVisible(true);

    }

}
