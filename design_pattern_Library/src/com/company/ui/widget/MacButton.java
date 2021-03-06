package com.company.ui.widget;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class MacButton extends JButton{

	private static final long serialVersionUID = 1L;

	public MacButton(String text) {
		try {
			LookAndFeel current = UIManager.getLookAndFeel();
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Mac OS X".equals(info.getName())) {
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
