package com.company.ui.gui_factory;

import com.company.ui.widget.LightButton;
import com.company.ui.widget.LightTextField;

import javax.swing.*;

public class LightFactory extends GuiFactory {

	private static LightFactory uniqueInstance = new LightFactory();

	public static LightFactory instance() {
		return uniqueInstance;
	}

	private LightFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public JButton makeButton(String label) {
		return new LightButton(label);
	}

	@Override
	public JTextField makeTextField() {
		return new LightTextField();
	}

}
