package com.company.ui.librarian;

import com.company.command.librarian.NewBookCommand;
import com.company.ui.gui_factory.GuiFactory;

import javax.swing.*;

public class NewBookPage extends LibrarianPage {

	private static final long serialVersionUID = 1L;
	private String enteredName="", enteredAuthor="",enteredPublisher="",enteredQuantity="";
	private JLabel nameLabel,authorLabel,publisherLabel, quantityLabel;
	private JButton addButton;
	private JTextField nameTxt;
    private JTextField authorTxt;
    private JTextField publisherTxt;
    private JTextField quantityTxt;

    public String getNameTxt() {
        return nameTxt.getText();
    }

    public String getAuthorTxt() {
        return authorTxt.getText();
    }

    public String getPublisherTxt() {
        return publisherTxt.getText();
    }

    public int getQuantityInt() {
        return Integer.parseInt(quantityTxt.getText());
    }


	public NewBookPage() {
		super();
		setUpUi();
		
	}

	public void setUpUi() {
		getContentPane().removeAll();
		makeWidgets();
		getContentPane().setLayout(null);
		addMenuItems();
		initUI();

		add(nameLabel);
		add(authorLabel);
		add(publisherLabel);
		add(quantityLabel);
		add(nameTxt);
		add(authorTxt);
		add(publisherTxt);
		add(quantityTxt);
		add(addButton);
		nameLabel.setBounds(5, 5, 90, 30);
		nameTxt.setBounds(80, 5, 200, 30);
		authorLabel.setBounds(5, 40, 90, 30);
		authorTxt.setBounds(80, 40, 200, 30);
		publisherLabel.setBounds(5, 75, 90, 30);
		publisherTxt.setBounds(80, 75, 200, 30);
		quantityLabel.setBounds(5, 110, 90, 30);
		quantityTxt.setBounds(80, 110, 200, 30);
		addButton.setBounds(10, 145, 90, 30);
		nameTxt.setText(enteredName);
		authorTxt.setText(enteredAuthor);
		publisherTxt.setText(enteredPublisher);
		quantityTxt.setText(enteredQuantity);

		setActions();
	}

	private void makeWidgets() {
		nameLabel = getFactory().makeLabel("Name: ");
		authorLabel = getFactory().makeLabel("Author: ");
		publisherLabel = getFactory().makeLabel("Publisher: ");
		quantityLabel = getFactory().makeLabel("Quantity: ");
		addButton = getFactory().makeButton("Add");
		nameTxt = getFactory().makeTextField();
		authorTxt = getFactory().makeTextField();
		publisherTxt = getFactory().makeTextField();
		quantityTxt = getFactory().makeTextField();
		
		
		
	}

	@Override
	public void resetFactory(GuiFactory factory) {
		setFactory(factory);
		enteredName = nameTxt.getText();
		enteredAuthor = authorTxt.getText();
		enteredPublisher = publisherTxt.getText();
		enteredQuantity = quantityTxt.getText();
		setUpUi();
	}

	public void setActions(){
		addButton.addActionListener(new NewBookCommand(this));
	}

}
