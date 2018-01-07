package com.company.ui;

import com.company.command.SignUpCommand;
import com.company.ui.gui_factory.GuiFactory;
import com.company.ui.widget.ThemeSelectionList;

import javax.swing.*;

public class SignUpPage extends Page {
	
	
	private static final long serialVersionUID = 1L;
	private String enteredName="", enteredNationalCode="",enteredEmail="",enteredMobileNumber="",
			enteredAddress="",enteredPassword="", enteredUsername="";
	private JLabel nameLabel,nationalCodeLabel,emailLabel, mobileLabel,
			addressLabel, passLabel, userLabel;
	private JButton signUpButton;

    public String getNameTxt() {
        return nameTxt.getText();
    }

    public int getNationalCodeTxt() {
        return Integer.parseInt(nationalCodeTxt.getText());
    }

    public String getEmailTxt() {
        return emailTxt.getText();
    }

    public String getMobileTxt() {
        return mobileTxt.getText();
    }

    public String getAddressTxt() {
        return addressTxt.getText();
    }

    public String getPassTxt() {
        return passTxt.getText();
    }

    public String getUserTxt() {
        return userTxt.getText();
    }

    private JTextField nameTxt, nationalCodeTxt, emailTxt, mobileTxt,
			addressTxt, passTxt, userTxt;
	
	
	public SignUpPage() {
		super();
		setUpUi();
		
	}

	public void setUpUi() {
		getContentPane().removeAll();
		makeWidgets();
		getContentPane().setLayout(null);
		initUI();

		add(nameLabel);
		add(nationalCodeLabel);
		add(emailLabel);
		add(mobileLabel);
		add(addressLabel);
		add(passLabel);
		add(userLabel);
		
		add(signUpButton);
		
		add(nameTxt);
		add(nationalCodeTxt);
		add(emailTxt);
		add(mobileTxt);
		add(addressTxt);
		add(passTxt);
		add(userTxt);
		
		nameLabel.setBounds(5, 5, 90, 30);
		nameTxt.setBounds(80, 5, 200, 30);
		
		nationalCodeLabel.setBounds(5, 40, 90, 30);
		nationalCodeTxt.setBounds(80, 40, 200, 30);
		
		emailLabel.setBounds(5, 75, 90, 30);
		emailTxt.setBounds(80, 75, 200, 30);
		mobileLabel.setBounds(5, 110, 90, 30);
		mobileTxt.setBounds(80, 110, 200, 30);
		addressLabel.setBounds(5, 145, 90, 30);
		addressTxt.setBounds(80, 145, 200, 30);
		passLabel.setBounds(5, 180, 90, 30);
		passTxt.setBounds(80, 180, 200, 30);
		userLabel.setBounds(5, 215, 90, 30);
		userTxt.setBounds(80, 215, 200, 30);
		signUpButton.setBounds(10, 250, 90, 30);
		
		nameTxt.setText(enteredName);
		nationalCodeTxt.setText(enteredNationalCode);
		emailTxt.setText(enteredEmail);
		mobileTxt.setText(enteredMobileNumber);
		addressTxt.setText(enteredAddress);
		passTxt.setText(enteredPassword);
		userTxt.setText(enteredUsername);



		setActions();
	}

	private void makeWidgets() {
		
		nameLabel = getFactory().makeLabel("Name: ");
		nationalCodeLabel = getFactory().makeLabel("National Code: ");
		emailLabel = getFactory().makeLabel("Email: ");
		mobileLabel = getFactory().makeLabel("Phone: ");
		addressLabel = getFactory().makeLabel("Address");
		passLabel = getFactory().makeLabel("Password: ");
		userLabel = getFactory().makeLabel("Username: ");
		
		signUpButton = getFactory().makeButton("Sign Up");
		
		nameTxt = getFactory().makeTextField();
		nationalCodeTxt = getFactory().makeTextField();
		emailTxt = getFactory().makeTextField();
		mobileTxt = getFactory().makeTextField();
		addressTxt = getFactory().makeTextField();
		passTxt = getFactory().makeTextField();
		userTxt = getFactory().makeTextField();
		
		
		
	}

	@Override
	public void resetFactory(GuiFactory factory) {
		setFactory(factory);
		
		enteredName=nameTxt.getText();
		enteredNationalCode=nationalCodeTxt.getText();
		enteredEmail=emailTxt.getText();
		enteredMobileNumber=mobileTxt.getText();
		enteredAddress=addressTxt.getText();
		enteredPassword=passTxt.getText();
		enteredUsername=userTxt.getText();
		
		setUpUi();
	}

	public void setActions(){
		signUpButton.addActionListener(new SignUpCommand(this));
	}
}
