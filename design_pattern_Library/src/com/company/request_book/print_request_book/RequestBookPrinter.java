package com.company.request_book.print_request_book;

import com.company.request_book.RequestBook;

/**
 * Created by me on 02/02/2017.
 */
public abstract class RequestBookPrinter {
    public String printRequest(RequestBook requestBook){
        String requestBookString = requestBook.getBaseInfoString();
        requestBookString += printRequestDates(requestBook);
        return requestBookString;
    }

    abstract String printRequestDates(RequestBook requestBook);
}
