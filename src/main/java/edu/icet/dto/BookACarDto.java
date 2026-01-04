package edu.icet.dto;

import edu.icet.enums.BookCarStatus;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookACarDto {
    private Long bookId;
    private Date fromDate;
    private Date toDate;
    private Long days;
    private Long amount;
    private BookCarStatus bookCarStatus;
    private Long userId;
    private String email;
    private String userName;
}