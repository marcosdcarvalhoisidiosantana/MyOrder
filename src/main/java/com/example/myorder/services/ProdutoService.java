package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateProdutoDto;
import com.example.myorder.api.dtos.ProdutoResponseDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.entities.Produto;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.repositories.ProdutoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ProdutoRespository produtoRespository;

    public ProdutoResponseDto create(CreateProdutoDto createProdutoDto) {

        Restaurant restaurant = restaurantService.findById(createProdutoDto.getRestaurantId());

        Produto produto = new Produto()
                .setName(createProdutoDto.getName())
                .setValor(createProdutoDto.getValor())
                .setRestaurant(restaurant);

        produto = produtoRespository.save(produto);

        RestaurantResponseDto restaurantResponseDto = new RestaurantResponseDto()
                .setName(produto.getRestaurant().getName())
                .setEmail(produto.getRestaurant().getEmail())
                .setPhone(produto.getRestaurant().getPhone())
                .setId(produto.getRestaurant().getId());

        return new ProdutoResponseDto()
                .setName(produto.getName())
                .setValue(produto.getValor())
                .setRestaurant(restaurantResponseDto);
    }

}
