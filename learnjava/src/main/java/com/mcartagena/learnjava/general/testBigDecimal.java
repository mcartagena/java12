package com.mcartagena.learnjava.general;

import java.math.BigDecimal;

public class testBigDecimal {

    public static void main(String[] args) {

        System.out.println("Emuliting the issue...");

        String reqAuthorizationAmount = "0.03";
        String reqSettlementAmount = "0.03";

        if(new BigDecimal(reqAuthorizationAmount).intValue() > 0
                && new BigDecimal(reqSettlementAmount).intValue() > 0)
            System.out.println("is ok");
        else
            System.out.println("error");

        if(new BigDecimal(reqAuthorizationAmount).compareTo(BigDecimal.ZERO) > 0
            && new BigDecimal(reqSettlementAmount).compareTo(BigDecimal.ZERO) > 0)
            System.out.println("new is ok");
        else
            System.out.println("new error");                
    }
}