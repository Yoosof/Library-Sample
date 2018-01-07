package com.company.dao;

import com.company.book.Book;
import com.company.request_book.RequestBook;
import com.company.user.User;
import com.company.util.MyUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by me on 01/02/2017.
 */
public class DBFacade {
    public static User login(String userName, String password){
        try {
            return UserDao.instance().login(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean registerCustomer(String name, int nationalCode, String email, String mobileNumber, String address, String password, String userName){
        try {
            int flagInt = UserDao.instance().registerUser(name, nationalCode, email, mobileNumber, address, password, userName, 0);
            return MyUtils.getBooleanFromInt(flagInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean registerLibrarian(String name, int nationalCode, String email, String mobileNumber, String address, String password, String userName){
        try {
            int flagInt = UserDao.instance().registerUser(name, nationalCode, email, mobileNumber, address, password, userName, 1);
            return MyUtils.getBooleanFromInt(flagInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteUser(User user){
        try {
            int userDeletedInt = UserDao.instance().deleteUser(user.getId());
            boolean userDeleted = MyUtils.getBooleanFromInt(userDeletedInt);
            if(userDeleted){
                int requestBooksDeletedInt = RequestBookDao.instance().deleteRequestBooksByUser(user.getId());
                MyUtils.getBooleanFromInt(requestBooksDeletedInt);
                return true;

            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteBook(Book book){
        try {
            int bookDeletedInt = BookDao.instance().deleteBook(book.getId());
            boolean bookDeleted= MyUtils.getBooleanFromInt(bookDeletedInt);
            if(bookDeleted){
                int requestBooksDeletedInt = RequestBookDao.instance().deleteRequestBooksByBook(book.getId());
                MyUtils.getBooleanFromInt(requestBooksDeletedInt);
                return true;

            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Book getBook(Book book){
        try {
            return BookDao.instance().getBook(book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User getUser(User user){
        try {
            return UserDao.instance().getUser(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean addBook(String name, String author, String publisher, int quantity){
        try {
            int flagInt = BookDao.instance().addBook(name, author, publisher, quantity);
            return MyUtils.getBooleanFromInt(flagInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static List<Book> getAllBooks(){
        try {
            return BookDao.instance().getAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean requestBook(Book book, User user) {
        try {
            int flagInt = RequestBookDao.instance().requestBook(book.getId(), user.getId());
            return MyUtils.getBooleanFromInt(flagInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static int getBookAvailableCount(Book book){
        try {
            int issuedCount = RequestBookDao.instance().getRequestBooksTakenUnReturned(book.getId()).size();
            return book.getQuantity()-issuedCount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<RequestBook> getUserRequestBooks(User user){
        try {
            return RequestBookDao.instance().getUserRequestBooks(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<RequestBook> getAllRequestBooks(){
        try {
            return RequestBookDao.instance().getAllRequestBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean payDebt(RequestBook requestBook){
        try {
            int flagInt = RequestBookDao.instance().payDebt(requestBook.getId());
            return MyUtils.getBooleanFromInt(flagInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static boolean receiveBookFromUser(RequestBook requestBook){
        try {
            int flagInt = RequestBookDao.instance().receiveBookFromUser(requestBook.getId());
            return MyUtils.getBooleanFromInt(flagInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static List<User> getAllUsers() {
        try {
            return UserDao.instance().getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean deleteRequestBook(RequestBook requestBook) {
        try {
            int requestBookDeletedInt = RequestBookDao.instance().deleteRequestBook(requestBook.getId());
            return MyUtils.getBooleanFromInt(requestBookDeletedInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static boolean deliverBookToUser(RequestBook requestBook) {
        try {
            int flagInt = RequestBookDao.instance().deliverBookToUser(requestBook.getId());
            return MyUtils.getBooleanFromInt(flagInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static RequestBook getRequestBookByRequestBook(RequestBook requestBook) {
        try {
            return RequestBookDao.instance().getRequestBookById(requestBook.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
