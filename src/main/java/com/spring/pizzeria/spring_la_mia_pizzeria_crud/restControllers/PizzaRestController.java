package com.spring.pizzeria.spring_la_mia_pizzeria_crud.restControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pizzeria.spring_la_mia_pizzeria_crud.models.Pizza;
import com.spring.pizzeria.spring_la_mia_pizzeria_crud.service.PizzaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("/api/pizzas")
public class PizzaRestController {
    
    @Autowired 
    public PizzaService service; 

    @GetMapping
    public List<Pizza> index(@RequestParam(required = false) String name) {
        if (name != null) {
            List<Pizza> pizzas = service.findAllByNameContaining(name);
            return pizzas;
        }
        
        List<Pizza> pizzas = service.findAll();

        return pizzas;
    }

    @GetMapping("{id}")
    public ResponseEntity<Pizza> show(@PathVariable Integer id) {
        
        Optional<Pizza> pizzaOpt = service.getById(id);
        
        if (pizzaOpt.isPresent()) {
            return new ResponseEntity<Pizza>(pizzaOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Pizza> store(@Valid @RequestBody Pizza pizza) {
        return new ResponseEntity<Pizza>(service.save(pizza), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pizza> update(@Valid @RequestBody Pizza pizza, Integer id) {
        pizza.setId(id);

        return new ResponseEntity<Pizza>(service.save(pizza) ,HttpStatus.OK);
    }
    
}
