package com.ironhack.finalprojectserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Provide a name.")
    private String name;
    @NotEmpty(message = "Provide ingredients.")
    private String ingredients;
    @NotNull(message = "Provide a price.")
    private double price;
    private String image;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private PlateCategory category;
}
