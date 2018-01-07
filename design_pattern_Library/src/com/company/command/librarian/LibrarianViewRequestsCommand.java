package com.company.command.librarian;

import com.company.dao.DBFacade;
import com.company.request_book.RequestBook;
import com.company.ui.Page;
import com.company.ui.client.ClientViewRequestsPage;
import com.company.ui.librarian.LibrarianPage;
import com.company.ui.librarian.LibrarianViewRequestsPage;
import com.company.user.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by me on 02/02/2017.
 */
public class LibrarianViewRequestsCommand implements ActionListener {
    private Page parentPage;

    public LibrarianViewRequestsCommand(Page parentPage) {
        this.parentPage = parentPage;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parentPage.closePage();
        List<RequestBook> requestBooks = DBFacade.getAllRequestBooks();
        new LibrarianViewRequestsPage(requestBooks);

    }
}
