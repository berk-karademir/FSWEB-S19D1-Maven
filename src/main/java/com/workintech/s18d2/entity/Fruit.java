package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fruit" , schema = "fsweb")

public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Min(value = 1, message = "Id can not be lower than 1 !")
    @jakarta.validation.constraints.NotNull(message = "Fruit id can not be null")
    @NotBlank
    private Long id;

    @Column(name = "name")
    @Size(min = 3, max = 30, message = "Name size must be between 3 to 30")
    @jakarta.validation.constraints.NotNull(message = "Fruit name can not be null")
    @NotBlank
    private String name;


    @Column(name = "price")
    @jakarta.validation.constraints.NotNull
    @NotBlank
    @DecimalMin("9.90")
    private Double price;

    @Column(name = "fruit_type")
    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    private FruitType fruitType;
}
