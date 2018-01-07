package com.company.ui.client;

import com.company.book.Book;
import com.company.ui.gui_factory.GuiFactory;
import com.company.ui.librarian.LibrarianBookClickPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created by me on 01/02/2017.
 */
public class ClientViewBooksPage  extends ClientPage {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private List<Book> books;

    public ClientViewBooksPage(List<Book> books) {
        super();
        this.books = books;

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
        String column[]={"Name","Author","Publisher"};
        table = getFactory().makeTable(data,column);

        JScrollPane sp=new JScrollPane(table);
        contentPane.add(sp, BorderLayout.CENTER);

        setActions();

    }
    private String[][] createData() {
        String data[][] = new String[books.size()][3];
        Iterator bookIterator = books.iterator();
        int i=0;
        while(bookIterator.hasNext()){
            Book book = (Book)bookIterator.next();
            data[i][0] = book.getName();
            data[i][1] = book.getAuthor();
            data[i][2] = book.getPublisher();
            i++;
        }
        return data;
    }

    @Override
    public void resetFactory(GuiFactory factory) {
        // TODO Auto-generated method stub

    }

    public void setActions(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ClientBookClickPage(books.get(table.getSelectedRow()));
                closePage();
            }
        });
    }

}
