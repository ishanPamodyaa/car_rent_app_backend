package edu.icet.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarDto {

    private Long id;
    private String name;
    private String brand;
    private String modelYear;
    private String color;
    private String fuelType;
    private String transmission;
    private Double mileage;
    private String type;
    private String rentalPrice;
    private Integer seats;
    private String description;
    private String image;

}