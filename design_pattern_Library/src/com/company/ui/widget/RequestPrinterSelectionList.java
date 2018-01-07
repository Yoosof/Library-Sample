package com.company.ui.widget;

import com.company.request_book.RequestBook;
import com.company.request_book.print_request_book.RequestBookPrinter;
import com.company.request_book.print_request_book.RequestBookPrinterWithDate;
import com.company.request_book.print_request_book.RequestBookPrinterWithoutDate;
import com.company.ui.Page;
import com.company.ui.gui_factory.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by me on 02/02/2017.
 */
public class RequestPrinterSelectionList extends JList<String> {
    private static final long serialVersionUID = 1L;
    private static final String[] printersName = { "with date", "without date"};
    private static final RequestBookPrinter[] printers = {RequestBookPrinterWithDate.instance(), RequestBookPrinterWithoutDate.instance()};
    public RequestPrinterSelectionList(RequestBook requestBook) {
        super(printersName);
        setVisibleRowCount(2);
        setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                requestBook.setRequestBookPrinter(printers[getSelectedIndex()]);
                ((Page)SwingUtilities.getRoot(RequestPrinterSelectionList.this)).setUpUi();
            }
        });


    }

}
