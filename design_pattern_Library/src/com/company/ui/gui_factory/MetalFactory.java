package com.company.ui.gui_factory;

import com.company.ui.widget.MetalButton;
import com.company.ui.widget.MetalTextField;

import javax.swing.*;

public class MetalFactory extends GuiFactory {

	private static MetalFactory uniqueInstance = new MetalFactory();

	public static MetalFactory instance() {
		return uniqueInstance;
	}

	private MetalFactory() {
		
	}

	@Override
	public JButton makeButton(String label) {
		return new MetalButton(label);
	}

	@Override
	public JTextField makeTextField() {
		return MetalTextField.generateTextField();
	}

}
