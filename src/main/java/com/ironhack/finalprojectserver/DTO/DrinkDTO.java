package com.ironhack.finalprojectserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrinkDTO {
    private String name;
    private String information;
    private double price;
    private String image;
    private Long restaurantId;
    private Long category;
}
