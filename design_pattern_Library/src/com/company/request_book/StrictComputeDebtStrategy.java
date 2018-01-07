package com.company.request_book;

import java.util.Date;

/**
 * Created by me on 01/02/2017.
 */
public class StrictComputeDebtStrategy implements ComputeDebtStrategy {
    private static StrictComputeDebtStrategy uniqueInstance = new StrictComputeDebtStrategy();

    private StrictComputeDebtStrategy() {

    }

    public static StrictComputeDebtStrategy instance() {
        return uniqueInstance;
    }

    @Override
    public int computeDebt(Date borrowDate, Date returnDate, int borrowMaxDayCount) {
        try {
            int diffInDays = (int) ((returnDate.getTime() - borrowDate.getTime())
                    / (1000 * 60 * 60 * 24));

            return (int) Math.pow(Math.max(diffInDays - borrowMaxDayCount, 0), 2);
        } catch (Exception e) {
            return 0;
        }
    }
}
