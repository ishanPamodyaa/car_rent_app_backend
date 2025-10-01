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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<CarDto> carList = new ArrayList<>();
        List<CarEntity> all = carRepository.findAll();
        all.forEach(CarEntity -> {
            carList.add(modelMapper.map(CarEntity, CarDto.class));
        });
        return carList;
    }

    @Override
    public void deleteById(Long id) {
            carRepository.deleteById(id);
    }

    @Override
    public CarDto SearchByID(Long id) {
        return modelMapper.map(carRepository.findById(id), CarDto.class);
    }

    @Override
    public boolean UpdateByCar(CarDto carDto, Long id) {
        if (carDto == null || id == null) {
            return false;
        }
        Optional<CarEntity> optionalExistingCar = carRepository.findById(id);
        if (optionalExistingCar.isPresent()) {
            CarEntity existingCar = optionalExistingCar.get();
            existingCar.setName(carDto.getName());
            existingCar.setDescription(carDto.getDescription());
            existingCar.setType(carDto.getType());
            existingCar.setBrand(carDto.getBrand());
            existingCar.setImage(carDto.getImage());
            existingCar.setTransmission(carDto.getTransmission());
            existingCar.setColor(carDto.getColor());
            existingCar.setModelDate(carDto.getModelDate());
            existingCar.setPrice(carDto.getPrice());

            carRepository.save(existingCar);
            return true;
        } else {
            return false;
        }
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
