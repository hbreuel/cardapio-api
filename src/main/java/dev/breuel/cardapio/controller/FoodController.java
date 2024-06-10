package dev.breuel.cardapio.controller;

import dev.breuel.cardapio.exception.ResourceNotFoundException;
import dev.breuel.cardapio.food.Food;
import dev.breuel.cardapio.food.FoodRepository;
import dev.breuel.cardapio.food.FoodRequestDTO;
import dev.breuel.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList;
        foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();

        return foodList;
    }

    @GetMapping("/{id}")
    public FoodResponseDTO getById(@PathVariable UUID id) {
        Food food = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food not found"));
        return new FoodResponseDTO(food);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void addFood(@RequestBody FoodRequestDTO data) {
        Food food = new Food(data);
        repository.save(food);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        Food food = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food not found with id " + id));
        repository.delete(food);
    }

    @PutMapping("/{id}")
    public FoodResponseDTO updateFood(@PathVariable UUID id, @RequestBody FoodRequestDTO data) {
        Food food = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food not found with id " + id));


        food.setTitle(data.title());
        food.setIngredients(data.ingredients());
        food.setTag(data.tag());
        food.setImage(data.image());
        food.setPrice(data.price());

        repository.save(food);

        return new FoodResponseDTO(food);

    }







}



