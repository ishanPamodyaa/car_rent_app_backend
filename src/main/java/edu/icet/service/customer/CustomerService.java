package edu.icet.service.customer;

import edu.icet.dto.BookACar;
import edu.icet.dto.CarDto;
import edu.icet.dto.SearchCar;
import edu.icet.entity.BookACarEntity;

import java.util.Date;
import java.util.List;

public interface CustomerService {
    List<CarDto> getAll();
    CarDto SearchByID(Long id);
    boolean bookCar(Long id, BookACar bookCarACar);
    List<BookACar> getAllBookingsInUserId(Long userId);
    List<CarDto> SearchCar (SearchCar searchCar);
    List<BookACarEntity> getBookingsForCarBetweenDates(Long carId, Date startDate, Date endDate);
}
