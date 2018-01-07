package com.company.command;

import com.company.Repository;
import com.company.ui.LoginPage;
import com.company.ui.Page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 01/02/2017.
 */
public class LogoutCommand implements ActionListener {
    private Page parentPage;

    public LogoutCommand(Page parentPage){

        this.parentPage = parentPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Repository.instance().setUser(null);
        parentPage.closePage();
        new LoginPage();
    }
}
