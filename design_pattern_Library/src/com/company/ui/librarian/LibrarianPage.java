package com.company.ui.librarian;

import com.company.command.LogoutCommand;
import com.company.command.client.ClientViewBookCommand;
import com.company.command.librarian.LibrarianViewBookCommand;
import com.company.command.librarian.LibrarianViewRequestsCommand;
import com.company.command.librarian.ViewUsersCommand;
import com.company.ui.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by me on 01/02/2017.
 */
public abstract class LibrarianPage extends Page {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem signOutMenuItem, viewBooksMenuItem,
            viewRequestedBooksMenuItem,newBookMenuItem, viewUsersMenuItem;

    void addMenuItems() {
        menuBar = getFactory().makeMenubar();
        menu = getFactory().makeMenu("Orders");
        signOutMenuItem = getFactory().makeMenuItem("Sign Out");
        viewBooksMenuItem = getFactory().makeMenuItem("View Books");
        viewRequestedBooksMenuItem = getFactory().makeMenuItem("View Requested Books");
        newBookMenuItem = getFactory().makeMenuItem("New Book");
        viewUsersMenuItem = getFactory().makeMenuItem("view users");

        menuBar.add(menu);
        menu.add(signOutMenuItem);
        menu.add(viewBooksMenuItem);
        menu.add(viewRequestedBooksMenuItem);
        menu.add(newBookMenuItem);
        menu.add(viewUsersMenuItem);
        setJMenuBar(menuBar);

        setMenuActions();
    }

    private void setMenuActions(){
        signOutMenuItem.addActionListener(new LogoutCommand(this));
        viewBooksMenuItem.addActionListener(new LibrarianViewBookCommand(this));
        viewUsersMenuItem.addActionListener(new ViewUsersCommand(this));
        viewRequestedBooksMenuItem.addActionListener(new LibrarianViewRequestsCommand(this));
//        newBookMenuItem.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                closePage();
//                new NewBookPage();
//            }
//        });
        newBookMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closePage();
                new NewBookPage();
            }
        });
    }

}
