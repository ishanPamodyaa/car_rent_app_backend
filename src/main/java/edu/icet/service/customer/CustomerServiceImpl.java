package edu.icet.service.customer;

import edu.icet.dto.BookACar;
import edu.icet.dto.CarDto;
import edu.icet.entity.CarEntity;
import edu.icet.dto.SearchCar;
import edu.icet.entity.BookACarEntity;
import edu.icet.repository.CarRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

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
        return null;
    }

    @Override
    public boolean bookCar(Long id, BookACar bookCarACar) {
        return false;
    }

    @Override
    public List<BookACar> getAllBookingsInUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<CarDto> SearchCar(SearchCar searchCar) {
        return List.of();
    }

    @Override
    public List<BookACarEntity> getBookingsForCarBetweenDates(Long carId, Date startDate, Date endDate) {
        return List.of();
    }
}
