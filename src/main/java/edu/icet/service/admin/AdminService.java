package edu.icet.service.admin;

import edu.icet.dto.BookACarDto;
import edu.icet.dto.CarDto;
import edu.icet.dto.SearchCarDto;

import java.util.List;

public interface AdminService {

    void addCar(CarDto carDto);
    List<CarDto> getAll();

    void deleteById(Long id);
    CarDto SearchByID(Long id);
    boolean  UpdateByCar(CarDto carDto,Long id);
    List<BookACarDto> getBooking();
    boolean changeBookingStatus(Long bookingId,String status);
    List<CarDto> searchCar(SearchCarDto searchCar);
}
