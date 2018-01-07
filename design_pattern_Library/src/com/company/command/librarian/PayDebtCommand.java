package com.company.command.librarian;

import com.company.request_book.RequestBook;
import com.company.ui.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by me on 02/02/2017.
 */
public class PayDebtCommand implements ActionListener {
    private RequestBook requestBook;
    private Page parent;

    public PayDebtCommand(RequestBook requestBook, Page parent){

        this.requestBook = requestBook;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean payDebt = requestBook.payDebt();
        if(!payDebt){
            JOptionPane.showMessageDialog(parent, "could not pay fine, because either you have not returned the book or you have no fine");
        }else{
            parent.setUpUi();
        }
    }
}
