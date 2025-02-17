package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }


    @Override
    public List<Fruit> getByPriceAsc() {
        List<Fruit> fruits = fruitRepository.getByPriceAsc();
        if(!fruits.isEmpty()) {
            return fruits;
        } else {
            throw new PlantException("There is not any fruits here yet :(", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        List<Fruit> fruits = fruitRepository.getByPriceDesc();
        if(!fruits.isEmpty()) {
            return fruits;
        } else {
            throw new PlantException("There is not any fruits here yet :(", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Fruit getById(Long id) {
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if(fruit.isPresent()) {
            return fruit.get();
        } else {
            throw new PlantException("Can not found any fruit with id: " + id , HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruitToRemove = this.getById(id);
        fruitRepository.delete(fruitToRemove);
        return fruitToRemove;
    }

    @Override
    public List<Fruit> searchByName(String fruitName) {
        return fruitRepository.searchByName(fruitName);
    }
}
