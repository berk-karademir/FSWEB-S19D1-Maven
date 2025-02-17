package com.workintech.s18d2.controller;


import com.workintech.s18d2.dto.VegetableResponse;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private VegetableService vegetableService;


    @GetMapping
    public VegetableResponse getAllByAscPrice() {
        return new VegetableResponse("Sorted all vegetables in ASC order: ", (Data) vegetableService.getByPriceAsc());
    }

    @GetMapping("/{id}")
    public VegetableResponse getById(@PathVariable("id") Long id) {
       return new VegetableResponse("Get successful!", (Data) vegetableService.getById(id));
    }

    @GetMapping("/desc")
    public VegetableResponse getAllByDescPrice() {
        return new VegetableResponse("Sorted all vegetables in DESC order: ", (Data) vegetableService.getByPriceDesc());
    }

    @PostMapping
    public VegetableResponse saveOrUpdate(@RequestBody Vegetable vegetable) {
        return new VegetableResponse( vegetable.getName() + " created successfully!", (Data) vegetable);
    }

    @GetMapping("/name/{name}")
    public VegetableResponse getByName(@PathVariable("name") String name) {
        return new VegetableResponse("Found by name:" , (Data) vegetableService.searchByName(name));
    }

    @DeleteMapping("/{id}")
    public VegetableResponse deleteById(Long id) {
        return new VegetableResponse("Deleted successfully!", (Data) vegetableService.delete(id));
    }

}
