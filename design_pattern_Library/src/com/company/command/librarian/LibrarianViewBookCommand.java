package com.company.command.librarian;

import com.company.book.Book;
import com.company.dao.DBFacade;
import com.company.ui.Page;
import com.company.ui.client.ClientViewBooksPage;
import com.company.ui.librarian.LibrarianViewBooksPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by me on 01/02/2017.
 */
public class LibrarianViewBookCommand implements ActionListener{
    private Page parentPage;

    public LibrarianViewBookCommand(Page parentPage){

        this.parentPage = parentPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parentPage.closePage();
        List<Book> books = DBFacade.getAllBooks();
        new LibrarianViewBooksPage(books);
    }
}
