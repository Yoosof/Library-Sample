package com.company.ui.librarian;

import com.company.request_book.RequestBook;
import com.company.ui.client.ClientRequestClickPage;
import com.company.ui.gui_factory.GuiFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

/**
 * Created by me on 02/02/2017.
 */
public class LibrarianViewRequestsPage extends LibrarianPage{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private List<RequestBook> requestBooks;

    public LibrarianViewRequestsPage(List<RequestBook> requestBooks) {
        super();
        this.requestBooks = requestBooks;

        setUpUi();
    }

    public void setUpUi(){
        addMenuItems();
        initUI();

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        //should be filled from DB
        String data[][]=createData();
//        setBounds(100, 100, 450, 25*(data.length+1));
        String column[]={"Book Name","User","Issued Date"};
        table = getFactory().makeTable(data,column);

        JScrollPane sp=new JScrollPane(table);
        contentPane.add(sp, BorderLayout.CENTER);

        setActions();
    }
    private String[][] createData() {
        String data[][] = new String[requestBooks.size()][3];
        Iterator requestBookIterator = requestBooks.iterator();
        int i=0;
        while(requestBookIterator.hasNext()){
            RequestBook requestBook = (RequestBook)requestBookIterator.next();
            data[i][0] = requestBook.getBook().getName();
            data[i][1] = requestBook.getUser().getName();
            data[i][2] = requestBook.getIssuedDate().toString();
            i++;
        }
        return data;
    }

    @Override
    public void resetFactory(GuiFactory factory) {

    }
    public void setActions(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new LibrarianRequestClickPage(requestBooks.get(table.getSelectedRow()));
                closePage();
            }
        });
    }
}
