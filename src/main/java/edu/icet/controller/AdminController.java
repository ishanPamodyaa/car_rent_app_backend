package edu.icet.controller;


import edu.icet.dto.CarDto;
import edu.icet.dto.SearchCarDto;
import edu.icet.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/car")
    public void addCar(@RequestBody CarDto carDto){
        adminService.addCar(carDto);
    }

    @GetMapping("/getAll")
    public List<CarDto> getAll(){

        return adminService.getAll();
    }

    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id){
        adminService.deleteById(id);

    }

    @GetMapping("/Search-By-Id/{id}")
    public CarDto searchByID(@PathVariable Long id){

        return   adminService.SearchByID(id);
    }

    @PutMapping("/Update-By-Car/{id}")
    public boolean UpdateByCar(@RequestBody CarDto carDto,@PathVariable Long id){
        return adminService.UpdateByCar(carDto,id);

    }
    @GetMapping("car/booking")
    public ResponseEntity<?> getBooking(){
        return ResponseEntity.ok(adminService.getBooking());
    }
    @GetMapping("car/Booking/{bookId}/{bookCarStatus}")
    public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookId,@PathVariable String bookCarStatus){
        boolean sucses=adminService.changeBookingStatus(bookId,bookCarStatus);
        if (sucses)
            return    ResponseEntity.ok().build();

        return  ResponseEntity.notFound().build();

    }
    @GetMapping("/car/ss")
    public  String trgrgtgrg(){
        return "eferfgtrgrg";
    }


    @PostMapping("/search/car")
    public List<CarDto> searchCars(@RequestBody SearchCarDto searchCar) {
        List<CarDto> cars = adminService.searchCar(searchCar);
        return cars;
    }




}
