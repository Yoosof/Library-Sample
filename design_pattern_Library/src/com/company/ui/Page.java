package com.company.ui;

import com.company.Repository;
import com.company.dao.BookDao;
import com.company.request_book.RequestBook;
import com.company.ui.gui_factory.GuiFactory;
import com.company.ui.widget.BookInfoObserver;
import com.company.ui.widget.RequestPrinterSelectionList;
import com.company.ui.widget.ThemeSelectionList;

import javax.swing.*;

public abstract class Page extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public GuiFactory getFactory() {
		return Repository.instance().getGuiFactory();
	}
    public abstract void setUpUi();
	public void setFactory(GuiFactory factory) {
		Repository.instance().setGuiFactory(factory);
	}
	public abstract void resetFactory(GuiFactory factory);

    public void initUI(){
        JScrollPane jSPane = new JScrollPane(new ThemeSelectionList());
        JLabel themeSelectorLabel = getFactory().makeLabel("theme selector");
        add(themeSelectorLabel);
        themeSelectorLabel.setBounds(800, 515, 200, 30);

        add(jSPane);
        jSPane.setBounds(800, 550, 70, 50);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        setVisible(true);

    }

    public void initRequestBookPrinterSelection(RequestBook requestBook){
        JScrollPane jSPane = new JScrollPane(new RequestPrinterSelectionList(requestBook));
        JLabel requestBookPrinterSelectorLabel = getFactory().makeLabel("requestBook printer selector");
        add(requestBookPrinterSelectorLabel);
        requestBookPrinterSelectorLabel.setBounds(600, 515, 200, 30);

        add(jSPane);
        jSPane.setBounds(600, 550, 70, 50);
    }

	public void closePage(){
		this.setVisible(false);
        dispose();
	}

}
