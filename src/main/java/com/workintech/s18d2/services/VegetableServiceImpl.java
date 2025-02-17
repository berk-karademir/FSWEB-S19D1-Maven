package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VegetableServiceImpl implements  VegetableService{

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        List<Vegetable> vegs = vegetableRepository.sortDescByPrice();
        if(!vegs.isEmpty()) {
            return vegs;
        } else {
            throw new PlantException("There is not any vegetables here yet :(", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        List<Vegetable> vegs = vegetableRepository.sortDescByPrice();
        if(!vegs.isEmpty()) {
            return vegs;
        } else {
            throw new PlantException("There is not any vegetables here yet :(", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Vegetable getById(Long id) {
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if(vegetable.isPresent()) {
            return vegetable.get();
        } else {
            throw new PlantException("Can not found any vegetables with id: " + id , HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetableToRemove = this.getById(id);
        if(vegetableToRemove == null) {
            throw new PlantException("Cannot find a vegetable to remove with id: " + id, HttpStatus.BAD_REQUEST);
        }
        vegetableRepository.delete(vegetableToRemove);
        return vegetableToRemove;
    }

    @Override
    public List<Vegetable> searchByName(String vegetableName) {
        return vegetableRepository.findByVegetableName(vegetableName);
    }


}
