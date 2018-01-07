package com.company.request_book;

import com.company.Repository;
import com.company.book.Book;
import com.company.dao.BookDao;
import com.company.dao.DBFacade;
import com.company.dao.UserDao;
import com.company.request_book.print_request_book.RequestBookPrinter;
import com.company.request_book.print_request_book.RequestBookPrinterWithoutDate;
import com.company.user.User;
import com.company.util.MyUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by me on 01/02/2017.
 */
public class RequestBook {
    private RequestBookPrinter requestBookPrinter=RequestBookPrinterWithoutDate.instance();
    private ComputeDebtStrategy computeDebtStrategy;
    private int borrowMaxDayCount = 14;

    int id;
    Book book;
    User user;
    boolean hasDebt;
    boolean hasBorrowed;
    boolean hasReturned;
    Date issuedDate;
    Date borrowedDate;
    Date returnedDate;

    String sql_id = "id";
    String sql_bookId = "book_id";
    String sql_userId = "user_id";
    String sql_hasDebt = "has_debt";
    String sql_hasBorrowed = "has_borrowed";
    String sql_hasReturned = "has_returned";
    String sql_issuedDate = "issued_date";
    String sql_borrowedDate = "borrowed_date";
    String sql_returnedDate = "returned_date";

    public String getBaseInfoString(){
        computeDebtStrategy= Repository.instance().getComputeDebtStrategy();
        return "id: "+id+", book name: "+book.getName()+", user name: "+user.getName()+", fine: "+computeDebt();
    }
    public String toString(){
        return requestBookPrinter.printRequest(this);
    }

    public RequestBook(ResultSet rs) throws SQLException {
        this.id = rs.getInt(sql_id);
        int bookId = rs.getInt(sql_bookId);
        this.book = BookDao.instance().getBook(bookId);
        int userId = rs.getInt(sql_userId);
        this.user = UserDao.instance().getUser(userId);
        int hasDebtInt = rs.getInt(sql_hasDebt);
        this.hasDebt = MyUtils.getBooleanFromInt(hasDebtInt);
        int hasBorrowedtInt = rs.getInt(sql_hasBorrowed);
        this.hasBorrowed = MyUtils.getBooleanFromInt(hasBorrowedtInt);
        int hasReturnedtInt = rs.getInt(sql_hasReturned);
        this.hasReturned = MyUtils.getBooleanFromInt(hasReturnedtInt);
        this.issuedDate = rs.getDate(sql_issuedDate);
        this.borrowedDate = rs.getDate(sql_borrowedDate);
        this.returnedDate = rs.getDate(sql_returnedDate);
    }

    public RequestBook(int id, Book book, User user, boolean hasDebt, boolean hasBorrowed, boolean hasReturned, Date issuedDate, Date borrowedDate, Date returnedDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.hasDebt = hasDebt;
        this.hasBorrowed = hasBorrowed;
        this.hasReturned = hasReturned;
        this.issuedDate = issuedDate;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public boolean hasDebt() {
        return hasDebt;
    }

    public boolean hasBorrowed() {
        return hasBorrowed;
    }

    public boolean hasReturned() {
        return hasReturned;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public boolean payDebt(){
        if(hasReturned){
            return DBFacade.payDebt(this);
        }else{
            return false;
        }
    }

    public int computeDebt(){
        if(hasDebt){
            return computeDebtStrategy.computeDebt(borrowedDate, returnedDate, borrowMaxDayCount);
        }else{
            return 0;
        }
    }

    public RequestBookPrinter getRequestBookPrinter() {
        return requestBookPrinter;
    }

    public void setRequestBookPrinter(RequestBookPrinter requestBookPrinter) {
        this.requestBookPrinter = requestBookPrinter;
    }

    public void refresh() {
        RequestBook newRb = DBFacade.getRequestBookByRequestBook(this);
        this.book = newRb.book;
        this.user = newRb.user;
        this.hasDebt = newRb.hasDebt;
        this.hasBorrowed = newRb.hasBorrowed;
        this.hasReturned = newRb.hasReturned;
        this.issuedDate = newRb.issuedDate;
        this.borrowedDate = newRb.borrowedDate;
        this.returnedDate = newRb.returnedDate;

    }
}
