package com.company.ui.gui_factory;

import com.company.ui.widget.MotifButton;
import com.company.ui.widget.MotifTextField;

import javax.swing.*;

public class MotifFactory extends GuiFactory {
	
	
private static MotifFactory uniqueInstance = new MotifFactory();
	
	public static MotifFactory instance() {
	    return uniqueInstance;
	}
	private MotifFactory() {
		
	} 

	@Override
	public JButton makeButton(String label) {
		return new MotifButton(label);
	}

	@Override
	public JTextField makeTextField() {
		return MotifTextField.generateTextField();
	}

}
