package com.company.ui.librarian;

import com.company.book.Book;
import com.company.command.librarian.DeleteBookCommand;
import com.company.command.librarian.DeleteUserCommand;
import com.company.ui.gui_factory.GuiFactory;
import com.company.user.User;

import javax.swing.*;

/**
 * Created by me on 02/02/2017.
 */
public class LibrarianUserClickPage extends LibrarianPage{
    private JLabel userInfo;
    private JButton deleteUser;
    private User user;
    public LibrarianUserClickPage(User user) {
        super();
        this.user = user;
        setUpUi();
    }

    public void setUpUi() {
        getContentPane().removeAll();
        makeWidgets();
        getContentPane().setLayout(null);
        addMenuItems();
        initUI();

        add(userInfo);
        add(deleteUser);
        userInfo.setBounds(5, 5, 900, 150);
        deleteUser.setBounds(160, 160, 120, 30);

        setActions();
    }
    private void makeWidgets() {
        userInfo = getFactory().makeLabel(user.toString());
        deleteUser = getFactory().makeButton("Delete User");

    }

    @Override
    public void resetFactory(GuiFactory factory) {
        setFactory(factory);
        setUpUi();
    }
    public void setActions(){
        deleteUser.addActionListener(new DeleteUserCommand(this, user));
    }
}
