package com.company.request_book;

import java.util.Date;

/**
 * Created by me on 01/02/2017.
 */
public interface ComputeDebtStrategy {
    public int computeDebt(Date borrowDate, Date returnDate, int borrowMaxDayCount);
}
