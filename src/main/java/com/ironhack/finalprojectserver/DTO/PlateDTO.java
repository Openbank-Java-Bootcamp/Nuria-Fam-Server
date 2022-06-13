package com.ironhack.finalprojectserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlateDTO {
    private String name;
    private String ingredients;
    private double price;
    private String image;
    private Long plateCategoryId;
}
