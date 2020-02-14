package com.example.myorder.entities;

import com.example.myorder.enums.OrderStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TOTAL_VALUE", nullable = false)
    @NotNull
    private Double totalValue;

    @OrderBy("id ASC")
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> listaProduto;

    @Column(name = "STATUS", nullable = false)
    @NotNull
    private OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public Pedido setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Pedido setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public Pedido setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Pedido setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Pedido setUser(User user) {
        this.user = user;
        return this;
    }
}
