package com.company;

import com.company.request_book.ComputeDebtStrategy;
import com.company.request_book.LightComputeDebtStrategy;
import com.company.ui.gui_factory.GuiFactory;
import com.company.ui.gui_factory.MacFactory;
import com.company.user.Librarian;
import com.company.user.User;

/**
 * Created by me on 01/02/2017.
 */
public class Repository {
    private static Repository uniqueInstance = new Repository();
    private Repository(){}
    public static Repository instance(){
        return uniqueInstance;
    }

    private User user;
    private Librarian librarian;
    private GuiFactory guiFactory = MacFactory.instance();
    private ComputeDebtStrategy computeDebtStrategy = LightComputeDebtStrategy.instance();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GuiFactory getGuiFactory() {
        return guiFactory;
    }

    public void setGuiFactory(GuiFactory guiFactory) {
        this.guiFactory = guiFactory;
    }

    public ComputeDebtStrategy getComputeDebtStrategy() {
        return computeDebtStrategy;
    }

    public void setComputeDebtStrategy(ComputeDebtStrategy computeDebtStrategy) {
        this.computeDebtStrategy = computeDebtStrategy;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }
}
