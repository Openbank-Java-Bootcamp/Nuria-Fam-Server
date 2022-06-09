package com.ironhack.finalprojectserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.finalprojectserver.utils.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Provide a name.")
    private String name;
    @Pattern(regexp = "^\\d{9}$",
            message = "Phone should have 9 numbers.")
    private String phone;
    private String image;
    @Embedded
    @NotNull(message = "You must have a primary address")
    private Address address;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Plate> plates; // One restaurant can have many plates
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Drink> drinks; // One restaurant can have many drinks
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Employee> employees; // One restaurant can have many employees
}
