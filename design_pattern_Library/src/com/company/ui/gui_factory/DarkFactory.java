package com.company.ui.gui_factory;

import com.company.ui.widget.DarkButton;
import com.company.ui.widget.DarkTextField;

import javax.swing.*;

public class DarkFactory extends GuiFactory {
	
	private static DarkFactory uniqueInstance = new DarkFactory();
	
	public static DarkFactory instance() {
	    return uniqueInstance;
	}
	private DarkFactory() {
		
	} 

	@Override
	public JButton makeButton(String label) {
		return new DarkButton(label);
	}

	@Override
	public JTextField makeTextField() {
		return new DarkTextField();
	}

}
