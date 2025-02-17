package com.workintech.s18d2.controller;


import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;


    @GetMapping
    public List<Fruit> getAllByAscPrice() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable("id") Long id) {
        return  fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getAllByDescPrice() {
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit saveOrUpdate(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@PathVariable("name") String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit deleteById(Long id) {
        return fruitService.delete(id);
    }

}
