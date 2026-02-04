package edu.icet.controller;

import edu.icet.dto.BookACarDto;
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
    public void addCar(@RequestBody CarDto carDto) {
        adminService.addCar(carDto);
    }

    @GetMapping("/getAll")
    public List<CarDto> getAll() {

        return adminService.getAll();
    }

    @DeleteMapping("/car/{id}")
    public void delete(@PathVariable Long id) {
        adminService.deleteById(id);

    }

    @GetMapping("/car/{id}")
    public CarDto searchByID(@PathVariable Long id) {

        return adminService.SearchByID(id);
    }

    @PutMapping("/car/{id}")
    public boolean UpdateByCar(@RequestBody CarDto carDto, @PathVariable Long id) {
        return adminService.UpdateByCar(carDto, id);

    }

    @GetMapping("car/booking")
    public ResponseEntity<?> getBooking() {
        List<BookACarDto> resEntity = adminService.getBooking();
        System.out.println(resEntity);
        return ResponseEntity.ok(resEntity);
    }

    @GetMapping("car/booking/{bookId}/{bookCarStatus}")
    public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookId, @PathVariable String bookCarStatus) {
        try {
            boolean sucses = adminService.changeBookingStatus(bookId, bookCarStatus);
            if (sucses)
                return ResponseEntity.ok().build();

            return ResponseEntity.notFound().build();
        } catch (edu.icet.exception.BookingConflictException ex) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String errorMessage = String.format(
                    "Cannot approve: This vehicle is already booked from %s to %s. Please select a different date range or reject this booking.",
                    sdf.format(ex.getConflictFromDate()),
                    sdf.format(ex.getConflictToDate()));
            return ResponseEntity.status(org.springframework.http.HttpStatus.CONFLICT)
                    .body(java.util.Collections.singletonMap("message", errorMessage));
        }

    }

    @GetMapping("/car/ss")
    public String trgrgtgrg() {
        return "eferfgtrgrg";
    }

    @PostMapping("/search/car")
    public List<CarDto> searchCars(@RequestBody SearchCarDto searchCar) {
        List<CarDto> cars = adminService.searchCar(searchCar);
        return cars;
    }

}
