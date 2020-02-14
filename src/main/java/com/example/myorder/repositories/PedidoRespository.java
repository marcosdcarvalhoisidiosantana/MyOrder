package com.example.myorder.repositories;

import com.example.myorder.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRespository extends JpaRepository<Pedido, Integer> {

}
