package com.codeclan.example.CoffeeTracker.controllers;

import com.codeclan.example.CoffeeTracker.models.Coffee;
import com.codeclan.example.CoffeeTracker.models.CoffeeShop;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeRepository;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeShopController {

    @Autowired
    CoffeeShopRepository coffeeShopRepository;
    @Autowired
    CoffeeRepository coffeeRepository;

//    @GetMapping(value = "/coffeeshop")
//    public ResponseEntity<List<CoffeeShop>> getAllCoffeeShops() {
//        return new ResponseEntity<>(coffeeShopRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/coffeeshop/{id}")
    public ResponseEntity getCoffeeShop(@PathVariable Long id) {
        return new ResponseEntity<>(coffeeShopRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/coffeeshop")
    public ResponseEntity<List<CoffeeShop>> findCoffeeShopBy(@RequestParam(name = "region", required = false) String region, @RequestParam(name = "name", required = false)String name, @RequestParam(name= "age", required = false) Integer age) {
        if (region != null) {
            return new ResponseEntity<>(coffeeShopRepository.findByRegion(region), HttpStatus.OK);
        }
        if(name !=null){
            return new ResponseEntity<>(coffeeShopRepository.findByName(name), HttpStatus.OK);
        }
        if(name !=null && age!=null){
            return new ResponseEntity<>(coffeeShopRepository.findByName(name),HttpStatus.OK);
//            return new ResponseEntity<>(coffeeRepository.findByAge(age),HttpStatus.OK);
        }
        return new ResponseEntity<>(coffeeShopRepository.findAll(), HttpStatus.OK);

    }
//    public ResponseEntity<List<CoffeeShop>> findCoffeeShopBy(@RequestParam(name = "name", required = false)String name, @RequestParam()){
//    if(name !=null){
//        return new ResponseEntity<>(coffeeShopRepository.findByName(name), HttpStatus.OK);
//    }
//        return new ResponseEntity<>(coffeeShopRepository.findAll(), HttpStatus.OK);
//
//    }

}



//    Get all the coffee shops stocking coffee for a particular region.
