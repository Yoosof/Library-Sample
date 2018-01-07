package com.company.request_book.print_request_book;

import com.company.request_book.RequestBook;

/**
 * Created by me on 02/02/2017.
 */
public class RequestBookPrinterWithoutDate extends RequestBookPrinter{
    private static RequestBookPrinterWithoutDate uniqueInstance=new RequestBookPrinterWithoutDate();
    private RequestBookPrinterWithoutDate(){

    }

    public static RequestBookPrinterWithoutDate instance(){
        return uniqueInstance;
    }
    @Override
    String printRequestDates(RequestBook requestBook) {
        return "";
    }
}
