package com.javatechie.spring.mongo.embeded.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.embeded.api.model.User;
import com.javatechie.spring.mongo.embeded.api.repository.FlipkartRepository;

@RestController
@RequestMapping("/order-service")
public class FlipkartOMController {

	@Autowired
	private FlipkartRepository repository;

	@PostMapping("/placedOrderNow")
	public String placeOrder(@RequestBody User user) {
		repository.save(user);
		return "Order placed successfully...";
	}

	@GetMapping("/getUserByName/{name}")
	public List<User> getUserbyName(@PathVariable String name) {
		return repository.findByName(name);
	}

	@GetMapping("/getUserByAddress/{city}")
	public List<User> getUserbyAddress(@PathVariable String city) {
		return repository.findByCity(city);
	}

}
