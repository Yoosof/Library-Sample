package com.company.dao;

import com.company.book.Book;
import com.company.request_book.RequestBook;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Created by me on 01/02/2017.
 */
public class BookDao extends Observable {
    private static BookDao uniqueInstance = new BookDao();
    private BookDao(){

    }
    public static BookDao instance(){
        return uniqueInstance;
    }

    public int addBook(String name, String author, String publisher, int quantity) throws SQLException {
        int status=0;
        Connection con=DB.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into book(name,author,publisher,quantity) values(?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,author);
        ps.setString(3,publisher);
        ps.setInt(4,quantity);
        status=ps.executeUpdate();

        con.close();

        if(status != 0){
            this.setChanged();
            this.notifyObservers();
        }

        return status;
    }

    public List<Book> getAllBooks() throws SQLException {
        Connection con=DB.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM book ORDER BY id ASC;");
        ResultSet rs = st.executeQuery(sql);
        List<Book> resultBooks = new LinkedList<>();
        while(rs.next()) {
            Book b = new Book(rs);
            resultBooks.add(b);
        }
        con.close();
        return resultBooks;
    }

    public Book getBook(int id) throws SQLException {
        Connection con=DB.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM book where id = " + id + " limit 1;");
        ResultSet rs = st.executeQuery(sql);
        Book book;
        if(rs.next()) {
            book = new Book(rs);
        }else{
            throw new SQLException();
        }
        con.close();
        return book;
    }

    public int deleteBook(int id)throws  SQLException{
        int status = 0;
        Connection con=DB.getConnection();
        String query = "delete from book where id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);

        // execute the preparedstatement
        status = preparedStmt.executeUpdate();
        if(status != 0){
            this.setChanged();
            this.notifyObservers();
        }

        con.close();
        return status;
    }

    public int getBooksCount() throws SQLException {
        Connection con=DB.getConnection();
        String query = "select count(*) from book";
        Statement stm = con.createStatement();

        // execute the preparedstatement
        ResultSet resultSet = stm.executeQuery(query);
        int count = 0;
        if(resultSet.next()){
            count = resultSet.getInt(1);
        }

        con.close();
        return count;

    }
}
