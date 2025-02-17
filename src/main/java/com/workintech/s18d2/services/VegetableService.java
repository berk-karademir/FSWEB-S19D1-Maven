package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;


public interface VegetableService {

    List<Vegetable> getByPriceAsc();

    Vegetable getById(Long id);

    List<Vegetable> getByPriceDesc();

    Vegetable save(Vegetable fruit);

    List<Vegetable> searchByName(String vegetableName);

    Vegetable delete(Long id);



}
