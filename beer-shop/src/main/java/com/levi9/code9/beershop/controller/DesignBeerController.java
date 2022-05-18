package com.levi9.code9.beershop.controller;

import com.levi9.code9.beershop.exception.BeerNotFoundException;
import com.levi9.code9.beershop.model.Beer;
import com.levi9.code9.beershop.service.DesignBeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/beers")
public class DesignBeerController {

    @Autowired
    public DesignBeerService designBeerService;

    @GetMapping("/{id}")
    public Beer getBeerById(@PathVariable final long id) {
        try {
            return designBeerService.getBeerById(id);
        } catch (BeerNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Beer not found", ex);
        }
    }

    @PostMapping
    public Beer saveBeer(@RequestBody final Beer beer) {
        return designBeerService.saveBeer(beer);
    }

}
