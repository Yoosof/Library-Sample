package com.company.ui.client;

import com.company.Repository;
import com.company.book.Book;
import com.company.command.client.RequestBookCommand;
import com.company.ui.gui_factory.GuiFactory;

import javax.swing.*;

public class ClientBookClickPage extends ClientPage {

	private static final long serialVersionUID = 1L;

	private JLabel bookInfo;
	private JButton requestBook;
	private Book book;

	public ClientBookClickPage(Book book) {
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
		add(requestBook);
		bookInfo.setBounds(5, 5, 900, 150);
		requestBook.setBounds(160, 160, 120, 30);


		setActions();
	}

	private void makeWidgets() {
		bookInfo = getFactory().makeLabel(book.toString());
		requestBook = getFactory().makeButton("Request Book");
		
	}

	@Override
	public void resetFactory(GuiFactory factory) {

		setFactory(factory);
		setUpUi();
	}

	public void setActions(){
		requestBook.addActionListener(new RequestBookCommand(book, Repository.instance().getUser(), this));
	}

}
