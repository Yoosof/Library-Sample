package com.company.user;

import com.company.dao.DBFacade;
import com.company.request_book.RequestBook;

/**
 * Created by me on 01/02/2017.
 */
public class Librarian extends User {
    public Librarian(User user){
        this.id = user.id;
        this.name = user.name;
        this.nationalCode = user.nationalCode;
        this.email = user.email;
        this.mobileNumber = user.mobileNumber;
        this.address=user.address;
        this.userName = user.userName;
        this.is_admin=true;

    }
    public Librarian(int id, String name, int nationalCode, String email, String mobileNumber, String address, String userName)
    {
        this.id = id;
        this.name = name;
        this.nationalCode = nationalCode;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address=address;
        this.userName = userName;
        this.is_admin=true;
    }

    public boolean deliverBookToUser(RequestBook requestBook){
        if(DBFacade.getBookAvailableCount(requestBook.getBook()) > 0 && !requestBook.hasBorrowed()){
            return DBFacade.deliverBookToUser(requestBook);
        }
        return false;
    }

    public boolean receiveBookFromUser(RequestBook requestBook){
        if(!requestBook.hasReturned() && requestBook.hasBorrowed()){

            boolean hasReturned = DBFacade.receiveBookFromUser(requestBook);
            requestBook.refresh();
            if(hasReturned){
                if(requestBook.computeDebt() == 0){
                    DBFacade.payDebt(requestBook);
                }
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
