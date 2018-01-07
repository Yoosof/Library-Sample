package com.company.command.client;

import com.company.book.Book;
import com.company.dao.DBFacade;
import com.company.request_book.RequestBook;
import com.company.ui.Page;
import com.company.ui.client.ClientPage;
import com.company.ui.client.ClientViewBooksPage;
import com.company.ui.client.ClientViewRequestsPage;
import com.company.user.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by me on 02/02/2017.
 */
public class ClientViewRequestsCommand implements ActionListener {
    private Page parentPage;
    private User user;

    public ClientViewRequestsCommand(Page parentPage, User user) {
        this.parentPage = parentPage;
        this.user = user;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parentPage.closePage();
        List<RequestBook> requestBooks = DBFacade.getUserRequestBooks(user);
        new ClientViewRequestsPage(requestBooks);

    }
}
