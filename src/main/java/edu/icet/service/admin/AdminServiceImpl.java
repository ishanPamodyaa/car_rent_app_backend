package edu.icet.service.admin;

import edu.icet.dto.BookACar;
import edu.icet.dto.CarDto;
import edu.icet.dto.SearchCar;
import edu.icet.entity.CarEntity;
import edu.icet.repository.BookACarRepository;
import edu.icet.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final BookACarRepository bookACarRepository;

    @Override
    public void addCar(CarDto carDto) {
        carRepository.save(modelMapper.map(carDto, CarEntity.class));
    }

    @Override
    public List<CarDto> getAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public CarDto SearchByID(Long id) {
        return null;
    }

    @Override
    public boolean UpdateByCar(CarDto carDto, Long id) {
        return false;
    }

    @Override
    public List<BookACar> getBooking() {
        return List.of();
    }

    @Override
    public boolean changeBookingStatus(Long bookingId, String status) {
        return false;
    }

    @Override
    public List<CarDto> searchCar(SearchCar searchCar) {
        return List.of();
    }
}
