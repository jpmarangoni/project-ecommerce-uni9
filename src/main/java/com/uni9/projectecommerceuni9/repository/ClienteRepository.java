package com.uni9.projectecommerceuni9.repository;

import com.uni9.projectecommerceuni9.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

  @Query("SELECT c FROM ClienteModel c WHERE c.id = :id")
  ClienteModel getById(@Param("id") Long id);
}
