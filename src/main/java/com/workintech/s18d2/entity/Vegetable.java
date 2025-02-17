package com.workintech.s18d2.entity;


import jakarta.persistence.*;
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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
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
