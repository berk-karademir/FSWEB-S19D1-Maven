package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> sortDescByPrice();


    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> sortAscByPrice();


    @Query("SELECT v FROM Vegetable v WHERE v.name LIKE '%:vegetableName%'")
    List<Vegetable> findByVegetableName(String vegetableName);
}
