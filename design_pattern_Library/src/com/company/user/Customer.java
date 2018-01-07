package com.company.user;

/**
 * Created by me on 01/02/2017.
 */
public class Customer extends User {
    public Customer(int id, String name, int nationalCode, String email, String mobileNumber, String address, String userName)
    {
        this.id = id;
        this.name = name;
        this.nationalCode = nationalCode;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address=address;
        this.userName=userName;
        this.is_admin=false;
    }

}
