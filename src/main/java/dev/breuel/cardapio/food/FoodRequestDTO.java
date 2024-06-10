package dev.breuel.cardapio.food;

public record FoodRequestDTO(String title, String ingredients, String image, String tag, Double price) {
}
