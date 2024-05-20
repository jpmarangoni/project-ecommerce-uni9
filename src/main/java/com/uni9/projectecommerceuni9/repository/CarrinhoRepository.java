package com.uni9.projectecommerceuni9.repository;

import com.uni9.projectecommerceuni9.model.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long> {
  @Query("SELECT c FROM CarrinhoModel c WHERE c.statusCarrinho = :status ORDER BY c.id DESC")
  CarrinhoModel getCarrinhoEmAberto(@Param("status") String status);
}