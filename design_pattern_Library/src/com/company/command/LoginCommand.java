package com.company.command;

import com.company.Repository;
import com.company.dao.DBFacade;
import com.company.ui.client.ClientHomePage;
import com.company.ui.librarian.LibrarianHomePage;
import com.company.ui.LoginPage;
import com.company.user.Librarian;
import com.company.user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 01/02/2017.
 */
public class LoginCommand implements ActionListener {

    private final LoginPage loginPage;

    public LoginCommand(LoginPage loginPage){
        this.loginPage = loginPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User user = DBFacade.login(loginPage.getUserName(), loginPage.getPassword());
        if(user != null){
            Repository.instance().setUser(user);
            loginPage.closePage();
            if(user.is_admin()){
                Librarian librarian = new Librarian(user);
                Repository.instance().setLibrarian(librarian);
                new LibrarianHomePage();
            }else{
                new ClientHomePage();
            }
        }else{
            JOptionPane.showMessageDialog(loginPage, "wrong username or password");
        }
    }
}
