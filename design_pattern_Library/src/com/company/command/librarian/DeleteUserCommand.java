package com.company.command.librarian;

import com.company.Repository;
import com.company.dao.DBFacade;
import com.company.ui.Page;
import com.company.user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 02/02/2017.
 */
public class DeleteUserCommand implements ActionListener {
    private final Page parent;
    private final User user;

    public DeleteUserCommand(Page parent, User user){

        this.parent = parent;
        this.user = user;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(user.equals(Repository.instance().getUser())){
            JOptionPane.showMessageDialog(parent, "you cant delete yourself");
        }else{
            boolean deleteUser = DBFacade.deleteUser(user);
            if(deleteUser){
                new ViewUsersCommand(parent).actionPerformed(e);
            }else{
                JOptionPane.showMessageDialog(parent, "could not delete user");
            }
        }
    }
}
