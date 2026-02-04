package edu.icet.dto;

import edu.icet.enums.BookCarStatus;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookACarDto {
  
    private Long id;
    private Date fromDate;
    private Date toDate;
    private Long days;
    private Long amount;
    private BookCarStatus bookCarStatus;
    private Long userId;
    private String email;
    private String userName;

    private Long carId;
    // private String carName;
    // private String brand;
    // private String image;
}