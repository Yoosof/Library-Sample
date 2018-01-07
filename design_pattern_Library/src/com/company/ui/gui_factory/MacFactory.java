package com.company.ui.gui_factory;

import com.company.ui.widget.MacButton;
import com.company.ui.widget.MacTextField;

import javax.swing.*;

public class MacFactory extends GuiFactory {

	private static MacFactory uniqueInstance = new MacFactory();

	public static MacFactory instance() {
		return uniqueInstance;
	}

	private MacFactory() {
	}

	@Override
	public JButton makeButton(String label) {
		return new MacButton(label);
	}

	@Override
	public JTextField makeTextField() {
		return MacTextField.generateTextField();
	}

}
