package com.levi9.code9.beershop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beer {

    private Long id;

    private LocalDateTime createAt = LocalDateTime.now();

    private String name;

    private List<Ingredient> ingredients;

}
