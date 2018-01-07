package com.company.ui.librarian;

import com.company.command.client.ClientDeleteRequestCommand;
import com.company.command.librarian.DeliverBookCommand;
import com.company.command.librarian.PayDebtCommand;
import com.company.command.librarian.ReceiveBookCommand;
import com.company.dao.DBFacade;
import com.company.request_book.RequestBook;
import com.company.ui.gui_factory.GuiFactory;

import javax.swing.*;

/**
 * Created by me on 02/02/2017.
 */
public class LibrarianRequestClickPage extends LibrarianPage{
    private static final long serialVersionUID = 1L;

    private JLabel requestInfo;
    private JButton payDebtRequest, deliverBookTorUser, receieveBookFromUser ;
    private RequestBook requestBook;

    public LibrarianRequestClickPage(RequestBook requestBook){
        super();
        this.requestBook=requestBook;
        setUpUi();
    }

    public void setUpUi() {
        requestBook.refresh();
        getContentPane().removeAll();
        makeWidgets();
        getContentPane().setLayout(null);
        addMenuItems();
        initRequestBookPrinterSelection(requestBook);
        initUI();


        add(requestInfo);
        add(payDebtRequest);
        add(deliverBookTorUser);
        add(receieveBookFromUser);
        requestInfo.setBounds(5, 5, 900, 150);
        payDebtRequest.setBounds(160, 160, 120, 30);
        deliverBookTorUser.setBounds(160,195,120,30);
        receieveBookFromUser.setBounds(160,230,120,30);


        setActions();
    }
    private void makeWidgets() {
        requestInfo = getFactory().makeLabel(requestBook.toString());
        payDebtRequest = getFactory().makeButton("pay debt");
        deliverBookTorUser = getFactory().makeButton("Deliver Book");
        receieveBookFromUser = getFactory().makeButton("Receive Book");

    }

    @Override
    public void resetFactory(GuiFactory factory) {
        setFactory(factory);
        setUpUi();
    }
    public void setActions(){
        payDebtRequest.addActionListener(new PayDebtCommand(requestBook, this));
        deliverBookTorUser.addActionListener(new DeliverBookCommand(requestBook, this));
        receieveBookFromUser.addActionListener(new ReceiveBookCommand(requestBook, this));
    }

}
