package com.ironhack.finalprojectserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    private String name;
    private String phone;
    private String street;
    private int number;
    private String city;
    private String country;
    private String postalCode;
    private String image;
    private Long userId;
}
