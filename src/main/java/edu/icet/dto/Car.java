package edu.icet.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {
    private Long id;
    private String name;
    private String color;
    private String transmission;
    private String brand;
    private String type;
    private String modelDate;
    private String description;
    private String price;
    private String image;


}