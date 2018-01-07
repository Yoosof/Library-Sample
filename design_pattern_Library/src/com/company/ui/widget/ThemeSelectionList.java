package com.company.ui.widget;

import com.company.ui.Page;
import com.company.ui.gui_factory.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ThemeSelectionList extends JList<String> {
	
	private static final long serialVersionUID = 1L;
	private static final String[] themes = { "Dark", "Light", "Mac OS",
		      "Metal", "Motif"};
	private static final GuiFactory[] factories = {DarkFactory.instance(), LightFactory.instance(),
			MacFactory.instance(), MetalFactory.instance(), MotifFactory.instance()};
	public ThemeSelectionList() {
		super(themes);
		setVisibleRowCount(5);
		setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				((Page)SwingUtilities.getRoot(ThemeSelectionList.this)).resetFactory(factories[getSelectedIndex()]);
			}
		});
		
		
	}
}
