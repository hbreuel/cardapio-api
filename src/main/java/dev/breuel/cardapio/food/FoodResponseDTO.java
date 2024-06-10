package dev.breuel.cardapio.food;

import java.util.UUID;

public record FoodResponseDTO(UUID id, String title, String ingredients, String tag, String image, Double price) {


    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getTitle(), food.getIngredients(), food.getTag(), food.getImage(), food.getPrice());
    }


}
