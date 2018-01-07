package com.company.command.librarian;

import com.company.dao.DBFacade;
import com.company.ui.Page;
import com.company.ui.librarian.ViewUsersPage;
import com.company.user.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by me on 02/02/2017.
 */
public class ViewUsersCommand implements ActionListener {
    private Page parent;

    public ViewUsersCommand(Page parent){

        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.closePage();
        List<User> users = DBFacade.getAllUsers();
        new ViewUsersPage(users);
    }
}
