package com.company.request_book.print_request_book;

import com.company.request_book.RequestBook;

/**
 * Created by me on 02/02/2017.
 */
public class RequestBookPrinterWithDate extends RequestBookPrinter{
    private static RequestBookPrinterWithDate uniqueInstance=new RequestBookPrinterWithDate();
    private RequestBookPrinterWithDate(){

    }

    public static RequestBookPrinterWithDate instance(){
        return uniqueInstance;
    }

    @Override
    String printRequestDates(RequestBook requestBook) {
        return ", issued date: " + requestBook.getIssuedDate()+", borrowed date: "+(requestBook.hasBorrowed()?requestBook.getBorrowedDate():"not borrowed")+", returned date: "+(requestBook.hasReturned()?requestBook.getReturnedDate():"not returned");
    }
}
