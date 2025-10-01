package edu.icet.controller;


import edu.icet.dto.CarDto;
import edu.icet.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
}
