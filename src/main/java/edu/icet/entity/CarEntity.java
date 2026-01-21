package edu.icet.entity;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String modelYear;
    private String color;
    private String fuelType;
    private String transmission;
    private Double mileage;
//  private String type;
    private String type;
    private String rentalPrice;
    private Integer seats;
//   private String modelDate;
    private String description;
//  private String price;
    private String image;




}
