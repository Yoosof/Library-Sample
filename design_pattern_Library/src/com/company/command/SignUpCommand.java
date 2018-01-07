package com.company.command;

import com.company.dao.DBFacade;
import com.company.ui.LoginPage;
import com.company.ui.Page;
import com.company.ui.SignUpPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 01/02/2017.
 */
public class SignUpCommand implements ActionListener{
    private SignUpPage parent;

    public SignUpCommand(SignUpPage parent){

        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean registered = DBFacade.registerCustomer(parent.getNameTxt(), parent.getNationalCodeTxt(), parent.getEmailTxt(), parent.getMobileTxt(), parent.getAddressTxt(), parent.getPassTxt(), parent.getUserTxt());
        if(registered){
            parent.closePage();
            new LoginPage();
        }else{
            JOptionPane.showMessageDialog(parent, "user could not be created");
        }
    }
}
