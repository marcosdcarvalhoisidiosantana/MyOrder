package com.example.myorder.entities;

import javax.persistence.*;

@Entity
@Table(name = "Pedido_do_item")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "USER_PEDIDO_ID", nullable = false)
    private Pedido pedido;

    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "PRODUTO", nullable = false)
    private Produto produto;

    public Integer getId() {
        return id;
    }

    public ItemPedido setId(Integer id) {
        this.id = id;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public ItemPedido setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ItemPedido setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ItemPedido setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }
}
