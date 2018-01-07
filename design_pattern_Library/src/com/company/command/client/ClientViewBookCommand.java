package com.company.command.client;

import com.company.book.Book;
import com.company.dao.DBFacade;
import com.company.ui.Page;
import com.company.ui.client.ClientViewBooksPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by me on 01/02/2017.
 */
public class ClientViewBookCommand implements ActionListener{
    private Page parentPage;

    public ClientViewBookCommand(Page parentPage){

        this.parentPage = parentPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parentPage.closePage();
        List<Book> books = DBFacade.getAllBooks();
        new ClientViewBooksPage(books);
    }


}
