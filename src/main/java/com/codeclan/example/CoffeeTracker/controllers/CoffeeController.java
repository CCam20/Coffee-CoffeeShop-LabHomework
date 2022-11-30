package com.codeclan.example.CoffeeTracker.controllers;

import com.codeclan.example.CoffeeTracker.models.Coffee;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeController {
    @Autowired
    CoffeeRepository coffeeRepository;

//    @GetMapping(value = "/coffee")
//    public ResponseEntity<List<Coffee>> getAllCoffee(){
//        return new ResponseEntity<>(coffeeRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/coffee/{id}")
    public ResponseEntity getCoffee(@PathVariable Long id){
        return new ResponseEntity<>(coffeeRepository.findById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/coffee")
    public ResponseEntity<List<Coffee>>findCoffeeByStrength( @RequestParam(name = "strength", required = false)Integer strength) {
        if (strength != null) {
            return new ResponseEntity<>(coffeeRepository.findByStrength(strength), HttpStatus.OK);
        }
        return new ResponseEntity<>(coffeeRepository.findAll(), HttpStatus.OK);
    }
//    @GetMapping(value = "/coffee/strength")
//    public ResponseEntity<List<Coffee>>findCoffeeByStrength( @RequestParam(name = "strength") Integer strength){
//        return new ResponseEntity<>(coffeeRepository.findByStrength(strength), HttpStatus.OK);
//    }
}
