package com.company.command.client;

import com.company.Repository;
import com.company.dao.DBFacade;
import com.company.request_book.RequestBook;
import com.company.ui.Page;
import com.company.ui.client.ClientViewRequestsPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 02/02/2017.
 */
public class ClientDeleteRequestCommand implements ActionListener {
    private final Page parent;
    private final RequestBook requestBook;

    public ClientDeleteRequestCommand(Page parent, RequestBook requestBook){

        this.parent = parent;
        this.requestBook = requestBook;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DBFacade.deleteRequestBook(requestBook);
        new ClientViewRequestsCommand(parent, Repository.instance().getUser()).actionPerformed(e);
    }
}
