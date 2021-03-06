package com.example.myorder.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel("Objeto referente a criacao do produto")
public class ProdutoResponseDto {

    @ApiModelProperty(value= "${product.response.name}")
    private String name;

    @ApiModelProperty(value= "${product.response.value}")
    private Double value;

    @ApiModelProperty(value= "${product.response.restaurant}")
    private RestaurantResponseDto restaurant;

    public String getName() {
        return name;
    }

    public ProdutoResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ProdutoResponseDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public RestaurantResponseDto getRestaurant() {
        return restaurant;
    }

    public ProdutoResponseDto setRestaurant(RestaurantResponseDto restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
