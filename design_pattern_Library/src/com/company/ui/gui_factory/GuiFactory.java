package com.company.ui.gui_factory;

import javax.swing.*;

public abstract class GuiFactory {
	public abstract JButton makeButton(String label);
	public abstract JTextField makeTextField();
	public JLabel makeLabel(String label){
		return new JLabel(label);
	}
	public JMenuBar makeMenubar(){
        return new JMenuBar();
    }
    public JMenu makeMenu(String label){
        return new JMenu(label);
    }
    public JMenuItem makeMenuItem(String label){
        return new JMenuItem(label);
    }
    public JTable makeTable(Object[][] data, Object[] columns){
        return new JTable(data, columns);
    }
}
