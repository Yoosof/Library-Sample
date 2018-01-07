package com.company.ui.widget;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class MotifTextField {
	private static LookAndFeel motif;

	public static JTextField generateTextField() {
		try {
			LookAndFeel current = UIManager.getLookAndFeel();

			if (motif == null) {
				for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

					if ("CDE/Motif".equals(info.getName())) {
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
				motif = UIManager.getLookAndFeel();
			} else
				UIManager.setLookAndFeel(motif);
			JTextField textfield = new JTextField();
			UIManager.setLookAndFeel(current);
			return textfield;
		} catch (Exception e) {
			e.printStackTrace();
			return new JTextField();
		}
	}
}
