package edu.icet.controller;


import edu.icet.dto.CarDto;
import edu.icet.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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

//    @GetMapping("/getAll")
//    public List <CarDto> getAll(){
//    return CarDto;
//    }



}
