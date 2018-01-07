package com.company.ui.librarian;

import com.company.command.librarian.LibrarianViewBookCommand;
import com.company.command.librarian.LibrarianViewRequestsCommand;
import com.company.command.librarian.ViewUsersCommand;
import com.company.ui.gui_factory.GuiFactory;
import com.company.ui.widget.ComputeDebtStrategySelectionList;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibrarianHomePage extends LibrarianPage{
	
	private static final long serialVersionUID = 1L;

	private JButton viewBooksButton,
				viewRequestedBookButton, newBookButton, viewUsersButton;
	public LibrarianHomePage() {
		super();
		setUpUi();
		
	}

	public void setUpUi() {
		
		getContentPane().removeAll();
		makeWidgets();
		getContentPane().setLayout(null);
		addMenuItems();
        initUI();
        initComputeDebtStrategySelector();

		add(viewBooksButton);
		viewBooksButton.setBounds(10, 40, 180, 30);

		add(viewRequestedBookButton);
		viewRequestedBookButton.setBounds(10, 75, 180, 30);
		add(newBookButton);
		newBookButton.setBounds(10, 110, 180, 30);
		add(viewUsersButton);
		viewUsersButton.setBounds(10, 145, 180, 30);
		setActions();

    }

	private void makeWidgets() {
		viewBooksButton = getFactory().makeButton("View Books");
		viewRequestedBookButton = getFactory().makeButton("View Requested Books");
		newBookButton = getFactory().makeButton("New Book");

		viewUsersButton = getFactory().makeButton("view users");
		
	}

    public void initComputeDebtStrategySelector(){

        JScrollPane jSPane = new JScrollPane(new ComputeDebtStrategySelectionList());
        JLabel strategySelectorLabel = getFactory().makeLabel("strategy selector");
        add(strategySelectorLabel);
        strategySelectorLabel.setBounds(10, 180, 200, 30);
        add(jSPane);
        jSPane.setBounds(10, 215, 70, 50);
    }

    @Override
	public void resetFactory(GuiFactory factory) {
		setFactory(factory);
		setUpUi();
		
	}
    public void setActions(){
        viewBooksButton.addActionListener(new LibrarianViewBookCommand(this));
        viewUsersButton.addActionListener(new ViewUsersCommand(this));
        viewRequestedBookButton.addActionListener(new LibrarianViewRequestsCommand(this));
        newBookButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                closePage();
                new NewBookPage();
            }
        });

    }
}
