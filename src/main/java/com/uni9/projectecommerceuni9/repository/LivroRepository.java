package com.uni9.projectecommerceuni9.repository;

import com.uni9.projectecommerceuni9.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
    @Query("SELECT l FROM LivroModel l WHERE l.id = :id")
    LivroModel buscaLivroPorId(@Param("id") Long id);
}
