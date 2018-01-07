package com.company.ui.client;

import com.company.Repository;
import com.company.book.Book;
import com.company.command.client.ClientDeleteRequestCommand;
import com.company.command.client.RequestBookCommand;
import com.company.dao.DBFacade;
import com.company.request_book.RequestBook;
import com.company.ui.gui_factory.GuiFactory;

import javax.swing.*;

/**
 * Created by me on 02/02/2017.
 */
public class ClientRequestClickPage extends ClientPage{

    private static final long serialVersionUID = 1L;

    private JLabel requestInfo;
    private JButton deleteRequest;
    private RequestBook requestBook;



    public ClientRequestClickPage(RequestBook requestBook) {
        super();
        this.requestBook=requestBook;
        setUpUi();
    }
    public void setUpUi() {
        getContentPane().removeAll();
        makeWidgets();
        getContentPane().setLayout(null);
        addMenuItems();
        initRequestBookPrinterSelection(requestBook);
        initUI();

        add(requestInfo);
        add(deleteRequest);
        requestInfo.setBounds(5, 5, 900, 150);
        deleteRequest.setBounds(160, 160, 120, 30);


        setActions();
    }

    private void makeWidgets() {
        requestInfo = getFactory().makeLabel(requestBook.toString());
        deleteRequest = getFactory().makeButton("Delete Request");

    }

    @Override
    public void resetFactory(GuiFactory factory) {
        setFactory(factory);
        setUpUi();
    }
    public void setActions(){
        deleteRequest.addActionListener(new ClientDeleteRequestCommand(this, requestBook));
    }
}
