package com.company.command.librarian;

import com.company.dao.DBFacade;
import com.company.ui.librarian.LibrarianHomePage;
import com.company.ui.librarian.NewBookPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 02/02/2017.
 */
public class NewBookCommand implements ActionListener{
    private final NewBookPage parent;

    public NewBookCommand(NewBookPage parent){

        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean bookAdded = DBFacade.addBook(parent.getNameTxt(), parent.getAuthorTxt(), parent.getPublisherTxt(), parent.getQuantityInt());
        if (bookAdded){
            parent.closePage();
            new LibrarianHomePage();
        }else{
            JOptionPane.showMessageDialog(parent, "the book could not be added");
        }
    }
}
