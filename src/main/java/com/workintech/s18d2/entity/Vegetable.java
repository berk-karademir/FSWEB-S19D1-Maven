package com.workintech.s18d2.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vegetable" , schema = "fsweb")

public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "grown_on_tree")
    private Boolean isGrownOnTree;


    public Boolean getGrownOnTree() {
        return isGrownOnTree;
    }

    public void setGrownOnTree(Boolean grownOnTree) {
        isGrownOnTree = grownOnTree;
    }
}
