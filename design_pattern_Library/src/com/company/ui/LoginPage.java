package com.company.ui;


import com.company.command.LoginCommand;
import com.company.ui.gui_factory.GuiFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends Page {

	private static final long serialVersionUID = 1L;
	private String enteredUser="", enteredPass="";
	private JButton login,signUp;
	private JLabel userLabel,passLabel;
	private JTextField username,password;
	public LoginPage() throws HeadlessException {
		super();
		setUpUi();

	}
	private void makeWidgets() {
		this.login = getFactory().makeButton("Login");
		this.username = getFactory().makeTextField(); 
		this.password = getFactory().makeTextField();
		this.signUp = getFactory().makeButton("Sign Up");
		this.userLabel = getFactory().makeLabel("Username: ");
		this.passLabel = getFactory().makeLabel("Password: ");
	}
	public void setUpUi(){
		getContentPane().removeAll();
		makeWidgets();
		getContentPane().setLayout(null);
        initUI();

		add(userLabel);
		userLabel.setBounds(5, 5, 90, 30);
		add(username);
		username.setBounds(80, 5, 200, 30);
		add(passLabel);
		passLabel.setBounds(5, 40, 90, 30);
		add(password);
		password.setBounds(80, 40, 200, 30);
		add(login);
		login.setBounds(10, 75, 90, 30);
		add(signUp);
		signUp.setBounds(10, 110, 90, 30);
		username.setText(enteredUser);
		password.setText(enteredPass);
        setActions();
	}
	public void resetFactory(GuiFactory factory) {
		setFactory(factory);
		enteredUser = username.getText();
		enteredPass = password.getText();
		setUpUi();
	}

	public String getUserName(){
        return username.getText();
    }

	public String getPassword(){
        return password.getText();
    }

	public void setActions(){
        login.addActionListener(new LoginCommand(this));
        signUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new SignUpPage();
                closePage();
            }
        });
    }

}
