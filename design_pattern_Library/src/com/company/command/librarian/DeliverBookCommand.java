package com.company.command.librarian;

import com.company.Repository;
import com.company.dao.DBFacade;
import com.company.request_book.RequestBook;
import com.company.ui.Page;
import com.company.user.Librarian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 02/02/2017.
 */
public class DeliverBookCommand implements ActionListener {
    private final RequestBook requestBook;
    private final Page parent;

    public DeliverBookCommand(RequestBook requestBook, Page parent){

        this.requestBook = requestBook;
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Librarian librarian = Repository.instance().getLibrarian();
        boolean deliverBookToUser = librarian.deliverBookToUser(requestBook);
        if(!deliverBookToUser){
            JOptionPane.showMessageDialog(parent, "could not deliver book, not available");
        }else{
            parent.setUpUi();
        }

    }
}
