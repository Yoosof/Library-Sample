package com.company.dao;

import com.company.book.Book;
import com.company.request_book.RequestBook;
import com.company.user.User;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by me on 01/02/2017.
 */
public class RequestBookDao {
    private static RequestBookDao uniqueInstance = new RequestBookDao();
    private RequestBookDao(){

    }
    public static RequestBookDao instance(){
        return uniqueInstance;
    }


    public int requestBook(int bookId, int userId) throws SQLException {
        int status = 0;
        Connection con = DB.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into requestbook(book_id,user_id,issued_date) values(?,?,?)");
        ps.setInt(1, bookId);
        ps.setInt(2, userId);
        ps.setDate(3, new Date(new java.util.Date().getTime()));
        status = ps.executeUpdate();

        con.close();
        return status;
    }

    public List<RequestBook> getRequestBooksTakenUnReturned(int bookId) throws SQLException {
        Connection con=DB.getConnection();
        String query = "select * from requestbook where book_id = "+bookId+" and has_borrowed=1 and has_returned=0;";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);

        List<RequestBook> requestBooks = new LinkedList<>();

        while(rs.next()) {
            RequestBook rb = new RequestBook(rs);
            requestBooks.add(rb);
        }

        con.close();
        return requestBooks;

    }

    public List<RequestBook> getUserRequestBooks(int userId) throws SQLException {
        Connection con=DB.getConnection();
        String query = "select * from requestbook where user_id="+userId+";";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);

        List<RequestBook> requestBooks = new LinkedList<>();

        while(rs.next()) {
            RequestBook rb = new RequestBook(rs);
            requestBooks.add(rb);
        }

        con.close();
        return requestBooks;

    }

    public List<RequestBook> getAllRequestBooks() throws SQLException {
        Connection con=DB.getConnection();
        String query = "select * from requestbook;";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);

        List<RequestBook> requestBooks = new LinkedList<>();

        while(rs.next()) {
            RequestBook rb = new RequestBook(rs);
            requestBooks.add(rb);
        }

        con.close();
        return requestBooks;

    }

    public int payDebt(int requestBookId) throws SQLException {
        int status = 0;
        Connection con=DB.getConnection();
        String query = "update requestbook set has_debt=0 where id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, requestBookId);

        // execute the preparedstatement
        status = preparedStmt.executeUpdate();

        con.close();
        return status;
    }

    public int deleteRequestBooksByBook(int bookId) throws SQLException {
        int status = 0;
        Connection con=DB.getConnection();
        String query = "delete from requestbook where book_id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, bookId);

        // execute the preparedstatement
        status = preparedStmt.executeUpdate();

        con.close();
        return status;

    }

    public int deleteRequestBooksByUser(int userId) throws SQLException {
        int status = 0;
        Connection con=DB.getConnection();
        String query = "delete from requestbook where user_id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, userId);

        // execute the preparedstatement
        status = preparedStmt.executeUpdate();

        con.close();
        return status;

    }

    public int deleteRequestBook(int requestBookId) throws SQLException {
        int status = 0;
        Connection con=DB.getConnection();
        String query = "delete from requestbook where id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, requestBookId);

        // execute the preparedstatement
        status = preparedStmt.executeUpdate();

        con.close();
        return status;

    }

    public int deliverBookToUser(int requestBookId) throws SQLException {
        int status = 0;
        Connection con=DB.getConnection();
        String query = "update requestbook set has_borrowed=1, borrowed_date=? where id=?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setDate(1, new Date(new java.util.Date().getTime()));
        preparedStmt.setInt(2, requestBookId);

//        // execute the preparedstatement
        status = preparedStmt.executeUpdate();
        con.close();
        return status;

    }

    public int receiveBookFromUser(int requestBookId) throws SQLException {
        int status = 0;
        Connection con=DB.getConnection();
        con.setAutoCommit(false);
        String query = "update requestbook set has_returned=1, returned_date=?, has_debt=1 where id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setDate(1, new Date(new java.util.Date().getTime()));
        preparedStmt.setInt(2, requestBookId);

        // execute the preparedstatement
        status = preparedStmt.executeUpdate();
        con.commit();
        preparedStmt.close();
        con.close();
        return status;
    }


    public RequestBook getRequestBookById(int id) throws SQLException {
        Connection con=DB.getConnection();
        String query = "select * from requestbook where id="+id+" limit 1;";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);

        RequestBook requestBook;

        if(rs.next()) {
            requestBook = new RequestBook(rs);
        }else{
            requestBook = null;
        }

        con.close();
        return requestBook;

    }
}
