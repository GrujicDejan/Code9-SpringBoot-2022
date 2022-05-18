package com.levi9.code9.beershop.service;

import com.levi9.code9.beershop.exception.BeerNotFoundException;
import com.levi9.code9.beershop.model.Beer;
import com.levi9.code9.beershop.model.Ingredient;
import com.levi9.code9.beershop.model.IngredientType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DesignBeerService {

    private List<Beer> beers = List.of(
            Beer.builder()
                    .id(101L)
                    .createAt(LocalDateTime.now())
                    .name("Caiman")
                    .ingredients(List.of(Ingredient.builder()
                            .id("AYE")
                            .name("Ale yeast")
                            .type(IngredientType.YEAST)
                            .build()))
                    .build(),
            Beer.builder()
                    .id(102L)
                    .createAt(LocalDateTime.now())
                    .name("Salto")
                    .ingredients(List.of(Ingredient.builder()
                            .id("LYE")
                            .name("Lager yeast")
                            .type(IngredientType.YEAST)
                            .build()))
                    .build()
    );

    public List<Beer> getAllBeers() {
        return beers;
    }

    public Beer getBeerById(final long id) {
        return beers.stream()
                .filter(beer -> beer.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new BeerNotFoundException(String.format("Beer with id: %s not found", id)));
    }

    public Beer saveBeer(final Beer beer) {
        beers.add(beer);
        return beer;
    }

}
