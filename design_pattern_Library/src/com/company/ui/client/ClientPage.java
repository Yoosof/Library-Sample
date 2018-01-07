package com.company.ui.client;

import com.company.Repository;
import com.company.command.client.ClientViewRequestsCommand;
import com.company.command.LogoutCommand;
import com.company.command.client.ClientViewBookCommand;
import com.company.ui.Page;

import javax.swing.*;

/**
 * Created by me on 01/02/2017.
 */
public abstract class ClientPage extends Page {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem signOutMenuItem, viewBooksMenuItem,
            viewRequestedBooksMenuItem;

    void addMenuItems() {
        menuBar = getFactory().makeMenubar();
        menu = getFactory().makeMenu("Orders");
        signOutMenuItem = getFactory().makeMenuItem("Sign Out");
        viewBooksMenuItem = getFactory().makeMenuItem("View Books");
        viewRequestedBooksMenuItem = getFactory().makeMenuItem("View Requested Books");

        menuBar.add(menu);
        menu.add(signOutMenuItem);
        menu.add(viewBooksMenuItem);
        menu.add(viewRequestedBooksMenuItem);
        setJMenuBar(menuBar);

        setMenuActions();
    }

    private void setMenuActions(){
        signOutMenuItem.addActionListener(new LogoutCommand(this));
        viewBooksMenuItem.addActionListener(new ClientViewBookCommand(this));
        viewRequestedBooksMenuItem.addActionListener(new ClientViewRequestsCommand(this, Repository.instance().getUser()));
    }

}
