package com.company.ui.client;

import com.company.Repository;
import com.company.command.client.ClientViewBookCommand;
import com.company.command.client.ClientViewRequestsCommand;
import com.company.ui.gui_factory.GuiFactory;

import javax.swing.*;

public class ClientHomePage extends ClientPage {

	private static final long serialVersionUID = 1L;


	private JButton viewBooksButton,
				viewRequestedBookButton;
	
	
	public ClientHomePage() {
		super();
		setUpUi();
		
	}

	public void setUpUi() {
		getContentPane().removeAll();
		makeWidgets();
		getContentPane().setLayout(null);
		addMenuItems();
        initUI();

		add(viewBooksButton);
		viewBooksButton.setBounds(10, 40, 180, 30);

		add(viewRequestedBookButton);
		viewRequestedBookButton.setBounds(10, 75, 180, 30);

        setActions();

    }


	private void makeWidgets() {
		viewBooksButton = getFactory().makeButton("View Books");
		
		viewRequestedBookButton = getFactory().makeButton("View Requested Books");
		
		
	}

	@Override
	public void resetFactory(GuiFactory factory) {
		setFactory(factory);
		setUpUi();
	}
    public void setActions(){
        viewBooksButton.addActionListener(new ClientViewBookCommand(this));
        viewRequestedBookButton.addActionListener(new ClientViewRequestsCommand(this, Repository.instance().getUser()));
    }

}
