package com.company.request_book;

import java.util.Date;

/**
 * Created by me on 01/02/2017.
 */
public class LightComputeDebtStrategy implements ComputeDebtStrategy {
    private static LightComputeDebtStrategy uniqueInstance = new LightComputeDebtStrategy();
    private LightComputeDebtStrategy(){

    }
    public static LightComputeDebtStrategy instance(){
        return uniqueInstance;
    }
    @Override
    public int computeDebt(Date borrowDate, Date returnDate, int borrowMaxDayCount) {
        try{
            int diffInDays = (int) ((returnDate.getTime() - borrowDate.getTime())
                    / (1000 * 60 * 60 * 24));
            return Math.max(diffInDays - borrowMaxDayCount, 0);
        }catch (Exception e){
            return 0;
        }
    }
}
