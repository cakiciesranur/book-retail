package com.eny.bookretail.repository;

import com.eny.bookretail.enums.OrderStatus;
import com.eny.bookretail.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findById(long id);

    List<OrderEntity> findAll();

    Optional<OrderEntity> findOrderEntityByIdAndStatus(long id, OrderStatus status);
}