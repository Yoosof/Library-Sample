package com.company.ui.librarian;

import com.company.book.Book;
import com.company.command.librarian.DeleteBookCommand;
import com.company.ui.gui_factory.GuiFactory;

import javax.swing.*;

public class LibrarianBookClickPage extends LibrarianPage{


	private static final long serialVersionUID = 1L;
	
	private JLabel bookInfo;
	private JButton deleteBook;
	private Book book;

	public LibrarianBookClickPage(Book book) {
		super();
		this.book = book;
		setUpUi();

	}
	
	public void setUpUi() {
		getContentPane().removeAll();
		makeWidgets();
		getContentPane().setLayout(null);
        addMenuItems();
		initUI();

		add(bookInfo);
		add(deleteBook);
		bookInfo.setBounds(5, 5, 900, 150);
		deleteBook.setBounds(160, 160, 120, 30);

		setActions();
	}
	
	private void makeWidgets() {
		bookInfo = getFactory().makeLabel(book.toString());
		deleteBook = getFactory().makeButton("Delete Book");
		
	}

	@Override
	public void resetFactory(GuiFactory factory) {
		setFactory(factory);
		setUpUi();
	}

	public void setActions(){
        deleteBook.addActionListener(new DeleteBookCommand(book, this));
	}
}
