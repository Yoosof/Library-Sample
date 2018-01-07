package com.company.ui.librarian;

import com.company.book.Book;
import com.company.command.librarian.LibrarianViewBookCommand;
import com.company.dao.DBFacade;
import com.company.ui.gui_factory.GuiFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class LibrarianViewBooksPage extends LibrarianPage {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private List<Book> books;

    public LibrarianViewBooksPage(List<Book> books) {
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
//		setBounds(100, 100, 450, 25*(data.length+1));
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
        setFactory(factory);

	}

	public void setActions(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new LibrarianBookClickPage(books.get(table.getSelectedRow()));
                closePage();
            }
        });
    }
}
