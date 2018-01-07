package com.company.book;

import com.company.dao.DBFacade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by me on 01/02/2017.
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private int quantity;

    private final String sql_name = "name";
    private final String sql_author = "author";
    private final String sql_publisher = "publisher";
    private final String sql_quantity = "quantity";
    private final String sql_id = "id";


    public String toString(){
        return "id: "+id + ", " + "name: "+ name + ", " + "author: "+author + ", " + "publisher: "+publisher + ", " + "quantity: "+ quantity + ", available count: " + DBFacade.getBookAvailableCount(this);
    }

    public Book(ResultSet rs) throws SQLException {
        id = rs.getInt(sql_id);
        name = rs.getString(sql_name);
        author = rs.getString(sql_author);
        publisher = rs.getString(sql_publisher);
        quantity = rs.getInt(sql_quantity);
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }


    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
}
