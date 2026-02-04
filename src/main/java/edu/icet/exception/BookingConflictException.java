package edu.icet.exception;

import lombok.Getter;

import java.util.Date;

@Getter
public class BookingConflictException extends RuntimeException {
    private final Date conflictFromDate;
    private final Date conflictToDate;

    public BookingConflictException(String message, Date conflictFromDate, Date conflictToDate) {
        super(message);
        this.conflictFromDate = conflictFromDate;
        this.conflictToDate = conflictToDate;
    }
}
