package com.company.ui.widget;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class MacTextField {
	private static LookAndFeel mac;

	public static JTextField generateTextField() {
		try {
			LookAndFeel current = UIManager.getLookAndFeel();

			if (mac == null) {
				for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

					if ("Mac OS X".equals(info.getName())) {
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
				mac = UIManager.getLookAndFeel();
			} else
				UIManager.setLookAndFeel(mac);
			JTextField textfield = new JTextField();
			UIManager.setLookAndFeel(current);
			return textfield;
		} catch (Exception e) {
			e.printStackTrace();
			return new JTextField();
		}
	}
}
