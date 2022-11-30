package com.codeclan.example.CoffeeTracker;

import com.codeclan.example.CoffeeTracker.repositories.CoffeeRepository;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeShopRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
class CoffeeTrackerApplicationTests {

	@Autowired
	CoffeeRepository coffeeRepository;
	@Autowired
	CoffeeShopRepository coffeeShopRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void GetAllCoffeesHarvestedWithAParticularStrength() {
		assertEquals(3,coffeeRepository.findByStrength(4).size());
	}
	@Test
	public void  GetAllCoffeeShopsStockingCoffeeForAParticularRegion(){
		assertEquals(3, coffeeShopRepository.findByRegion("Jamaica").size());
	}
	@Test
	public void GetCoffeeByAge(){
		assertEquals(5, coffeeRepository.findByAge(1).size());
	}
}
