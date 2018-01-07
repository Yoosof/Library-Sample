package com.company.ui.widget;

import javax.swing.*;
import java.awt.*;

public class LightButton extends JButton {
	private static final long serialVersionUID = 1L;
	public LightButton(String text) {
		super(text);
		
		setOpaque(true);
		setForeground(Color.LIGHT_GRAY);
		
	}
	
}
