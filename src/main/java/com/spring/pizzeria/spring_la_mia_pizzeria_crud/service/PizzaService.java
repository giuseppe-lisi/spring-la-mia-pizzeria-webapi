package com.spring.pizzeria.spring_la_mia_pizzeria_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.pizzeria.spring_la_mia_pizzeria_crud.models.Pizza;
import com.spring.pizzeria.spring_la_mia_pizzeria_crud.repositories.PizzaRepository;

@Service
public class PizzaService {
    
    @Autowired
    private PizzaRepository repo;
    
    public List<Pizza> findAll() {
        return repo.findAll();
    }

    public List<Pizza> findAllSortedByTitle() {
        return repo.findAll(Sort.by("name"));
    }

    public List<Pizza> findAllByNameContaining(String name) {
        return repo.findByNameContaining(name);
    }

    public Optional<Pizza> getById(Integer id) {
        return repo.findById(id);
    }

    public void save(Pizza pizza) {
        repo.save(pizza);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
