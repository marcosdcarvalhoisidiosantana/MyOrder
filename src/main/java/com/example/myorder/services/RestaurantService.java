package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateRestaurantDto;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired // Annotation para dizer que esse cara é uma variavel de ambiente.
    private RestaurantRepository restaurantRepository;

    public void createRestaurant(CreateRestaurantDto createRestaurantDto) {
        Restaurant restaurant = new Restaurant()
                .setEmail(createRestaurantDto.getEmail())
                .setName(createRestaurantDto.getName())
                .setPhone(createRestaurantDto.getPhone());

        restaurantRepository.save(restaurant);
    }

}
