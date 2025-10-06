package edu.icet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.icet.dto.BookACar;
import edu.icet.enums.BookCarStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BookACar")
public class BookACarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private Date fromDate;
    private Date toDate;
    private Long days;
    private Long amount;
    @Enumerated(EnumType.STRING)
    private BookCarStatus bookStatus;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserEntity user;
    

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "carId" ,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CarEntity car;


    public BookACar getBookingCars () {

        BookACar bookACar =  new BookACar();

        bookACar.setBookId(bookId);
        bookACar.setFromDate(fromDate);
        bookACar.setToDate(toDate);
        bookACar.setDays(days);
        bookACar.setAmount(amount);
        bookACar.setBookCarStatus(bookStatus);
        bookACar.setEmail(user.getEmail());
        bookACar.setUserName(user.getName());

        return bookACar;
    }

}
