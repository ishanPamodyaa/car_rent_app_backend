package edu.icet.service.customer;

import edu.icet.dto.BookACarDto;
import edu.icet.dto.CarDto;
import edu.icet.entity.CarEntity;
import edu.icet.dto.SearchCarDto;
import edu.icet.entity.BookACarEntity;
import edu.icet.entity.UserEntity;
import edu.icet.enums.BookCarStatus;
import edu.icet.repository.BookACarRepository;
import edu.icet.repository.CarRepository;

import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final BookACarRepository bookACarRepository;


    @Override
    public List<CarDto> getAll() {
        List<CarDto>carList=new ArrayList<>();
        List<CarEntity>carEntities=carRepository.findAll();
        carEntities.forEach(CarEntity ->{
            carList.add(modelMapper.map(CarEntity, CarDto.class));
        } );
        return carList;
    }

    @Override
    public CarDto SearchByID(Long id) {
        CarEntity carEntity=carRepository.findById(id).orElseThrow(()->new RuntimeException("Car Not find"+id));
        return modelMapper.map(carEntity, CarDto.class);
    }

    @Override
    public boolean bookCar(Long id, BookACarDto bookACarDto) {
        Optional<UserEntity> optionalUserEntity=(userRepository.findById(bookACarDto.getUserId()));
        Optional<CarEntity>optionalCarEntity=carRepository.findById(id);
        if (optionalCarEntity.isPresent() && optionalCarEntity.isPresent()){
            BookACarEntity bookACarEntity=new BookACarEntity();
            long difMilliSecond=bookACarDto.getToDate().getTime() -bookACarDto.getFromDate().getTime();


            long days = difMilliSecond / 86400000;


            bookACarEntity.setDays(days);
            bookACarEntity.setUser(optionalUserEntity.get());
            bookACarEntity.setCar(optionalCarEntity.get());
            bookACarEntity.setAmount(Integer.parseInt(optionalCarEntity.get().getRentalPrice()) * days);
            bookACarEntity.setFromDate(bookACarDto.getFromDate());
            bookACarEntity.setToDate(bookACarDto.getToDate());
            bookACarEntity.setBookStatus(BookCarStatus.PENDING);
            bookACarRepository.save(bookACarEntity);
            return true;
        }
        return  false;
    }


    @Override
    public List<BookACarDto> getAllBookingsInUserId(Long userId) {

        return bookACarRepository.findByUserId(userId).stream().map(BookACarEntity::getBookingCars).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> SearchCar(SearchCarDto searchCar) {

        List<CarEntity> carEntities = carRepository.findAll().stream()
                .filter(car -> searchCar.getBrand() == null ||
                        car.getBrand().toLowerCase().contains(searchCar.getBrand().toLowerCase()))
                .filter(car -> searchCar.getType() == null ||
                        car.getType().toLowerCase().contains(searchCar.getType().toLowerCase()))
                .filter(car -> searchCar.getTransmission() == null ||
                        car.getTransmission().toLowerCase().contains(searchCar.getTransmission().toLowerCase()))
                .filter(car -> searchCar.getColor() == null ||
                        car.getColor().toLowerCase().contains(searchCar.getColor().toLowerCase()))
                .collect(Collectors.toList());

        return carEntities.stream()
                .map(entity -> modelMapper.map(entity, CarDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookACarEntity> getBookingsForCarBetweenDates(Long carId, Date startDate, Date endDate) {

        Calendar cal = Calendar.getInstance();


        cal.setTime(startDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date adjustedStartDate = cal.getTime();


        cal.setTime(endDate);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Date adjustedEndDate = cal.getTime();


        List<BookACarEntity> bookings = bookACarRepository.findByCarIdAndDateRange(
                carId,
                (java.sql.Date) adjustedStartDate,
                adjustedEndDate
        );

        return bookings;
    }
}
