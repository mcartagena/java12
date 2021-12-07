package com.mcartagena.learnjava.exceptions;

import java.io.IOException;

public class IncidentReportException extends RuntimeException{
    public IncidentReportException(Exception ex){
        super(ex);
    }
    public static void main(String[] args) throws Exception {
        try {
            throw new IncidentReportException(new IOException());
        } catch (RuntimeException e) {
            System.out.println(e.getCause());
        }
    }
}
