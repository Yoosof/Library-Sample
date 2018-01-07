package com.company.ui.widget;

import javax.swing.*;
import java.awt.*;

public class DarkButton extends JButton {
	private static final long serialVersionUID = 1L;
	public DarkButton(String text) {
		super(text);
		setOpaque(true);
		setForeground(Color.DARK_GRAY);
	}
}
