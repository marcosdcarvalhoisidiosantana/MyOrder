package com.example.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateProdutoDto {

    @NotEmpty
    @ApiModelProperty(value= "${produto.create.name}")
    private String name;

    @NotNull
    @Min(value = 1, message = "Valor minimo deve ser 1")
    @ApiModelProperty(value= "${produto.create.valor}")
    private Double valor;

    @NotNull
    @ApiModelProperty(value= "${produto.create.restaurantId}")
    private Integer restaurantId;

    public String getName() {
        return name;
    }

    public CreateProdutoDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public CreateProdutoDto setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public CreateProdutoDto setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }
}
