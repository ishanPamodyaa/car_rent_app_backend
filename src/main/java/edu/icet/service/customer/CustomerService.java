package edu.icet.service.customer;

import edu.icet.dto.BookACarDto;
import edu.icet.dto.CarDto;
import edu.icet.dto.SearchCarDto;
import edu.icet.entity.BookACarEntity;

import java.util.Date;
import java.util.List;

public interface CustomerService {
    List<CarDto> getAll();
    CarDto SearchByID(Long id);
    boolean bookCar(Long id, BookACarDto bookCarACar);
    List<BookACarDto> getAllBookingsInUserId(Long userId);
    List<CarDto> SearchCar (SearchCarDto searchCar);
    List<BookACarEntity> getBookingsForCarBetweenDates(Long carId, Date startDate, Date endDate);
}
