package com.company.ui.librarian;

import com.company.book.Book;
import com.company.ui.gui_factory.GuiFactory;
import com.company.user.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

public class ViewUsersPage extends LibrarianPage {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private List<User> users;

	public ViewUsersPage(List<User> users) {
		super();
		this.users = users;

        setUpUi();
	}


	public void setUpUi(){
        addMenuItems();
        initUI();

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);


        //should be filled from DB
        String data[][]=createData();
        String column[]={"Name","Username"};
        table = getFactory().makeTable(data,column);

        JScrollPane sp=new JScrollPane(table);
        contentPane.add(sp, BorderLayout.CENTER);
        setActions();
    }
	private String[][] createData() {
		String data[][] = new String[users.size()][2];
		Iterator userIterator = users.iterator();
		int i=0;
		while(userIterator.hasNext()){
			User user = (User)userIterator.next();
			data[i][0] = user.getName();
			data[i][1] = user.getUserName();
			i++;
		}
		return data;
	}

	@Override
	public void resetFactory(GuiFactory factory) {
		setFactory(factory);

	}


    public void setActions(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new LibrarianUserClickPage(users.get(table.getSelectedRow()));
                closePage();
            }
        });
    }

}
