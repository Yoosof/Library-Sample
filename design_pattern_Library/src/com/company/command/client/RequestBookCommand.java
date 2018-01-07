package com.company.command.client;

import com.company.book.Book;
import com.company.command.librarian.LibrarianViewBookCommand;
import com.company.dao.DBFacade;
import com.company.ui.Page;
import com.company.user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 01/02/2017.
 */
public class RequestBookCommand implements ActionListener {

    private final Book book;
    private User user;
    private final Page parent;

    public RequestBookCommand(Book book, User user, Page parent){

        this.book = book;
        this.user = user;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean requested = DBFacade.requestBook(book, user);
        if (requested){
            new ClientViewBookCommand(parent).actionPerformed(e);
        }else{
            JOptionPane.showMessageDialog(parent, "the book could not be requested");
        }

    }
}
