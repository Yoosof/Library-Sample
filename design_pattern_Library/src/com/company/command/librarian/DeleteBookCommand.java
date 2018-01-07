package com.company.command.librarian;

import com.company.book.Book;
import com.company.dao.DBFacade;
import com.company.ui.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 01/02/2017.
 */
public class DeleteBookCommand implements ActionListener{
    private Book book;
    private Page parent;

    public DeleteBookCommand(Book book, Page parent){
        this.book = book;

        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean deleted = DBFacade.deleteBook(book);
        if (deleted){
            new LibrarianViewBookCommand(parent).actionPerformed(e);
        }else{
            JOptionPane.showMessageDialog(parent, "the book could not be deleted");
        }

    }
}
