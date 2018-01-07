package com.company.ui.widget;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class MetalButton extends JButton {

	private static final long serialVersionUID = 1L;

	public MetalButton(String text) {
		try {
			LookAndFeel current = UIManager.getLookAndFeel();
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			setModel(new DefaultButtonModel());

			init(text, null);
			UIManager.setLookAndFeel(current);
		} catch (Exception e) {

		}
	}

}
