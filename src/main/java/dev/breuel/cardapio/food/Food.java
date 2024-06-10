package dev.breuel.cardapio.food;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String ingredients;
    private String image;
    private String tag;
    private Double price;


    public Food(FoodResponseDTO responseDTO) {
        this.title = responseDTO.title();
        this.ingredients = responseDTO.ingredients();
        this.image = responseDTO.image();
        this.tag = responseDTO.tag();
        this.price = responseDTO.price();
    }

    public Food(FoodRequestDTO requestDTO) {
        this.title = requestDTO.title();
        this.ingredients = requestDTO.ingredients();
        this.image = requestDTO.image();
        this.tag = requestDTO.tag();
        this.price = requestDTO.price();
    }


}
