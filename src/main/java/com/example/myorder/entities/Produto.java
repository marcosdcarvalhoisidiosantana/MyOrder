package com.example.myorder.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "VALOR", nullable = false)
    @NotNull
    private Double valor;

    @ManyToOne
    @JoinColumn(name="RESTAURANT", nullable = false)
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Produto setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Produto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Produto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public Produto setValor(Double valor) {
        this.valor = valor;
        return this;
    }
}
