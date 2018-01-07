package com.company.ui.widget;

import com.company.Repository;
import com.company.request_book.ComputeDebtStrategy;
import com.company.request_book.LightComputeDebtStrategy;
import com.company.request_book.RequestBook;
import com.company.request_book.StrictComputeDebtStrategy;
import com.company.request_book.print_request_book.RequestBookPrinterWithDate;
import com.company.request_book.print_request_book.RequestBookPrinterWithoutDate;
import com.company.ui.Page;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by me on 02/02/2017.
 */
public class ComputeDebtStrategySelectionList extends JList<String> {
    private static final long serialVersionUID = 1L;
    private static final String[] strategiesName = { "light", "strict"};
    private static final ComputeDebtStrategy[] strategies = {LightComputeDebtStrategy.instance(), StrictComputeDebtStrategy.instance()};
    public ComputeDebtStrategySelectionList() {
        super(strategiesName);
        setVisibleRowCount(2);
        setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Repository.instance().setComputeDebtStrategy(strategies[getSelectedIndex()]);
            }
        });


    }


}
