package com.spring.pizzeria.spring_la_mia_pizzeria_crud.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pizzeria.spring_la_mia_pizzeria_crud.models.Pizza;
import com.spring.pizzeria.spring_la_mia_pizzeria_crud.service.PizzaService;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
