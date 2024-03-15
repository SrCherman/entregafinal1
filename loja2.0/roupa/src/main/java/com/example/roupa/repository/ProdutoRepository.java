package com.example.roupa.repository;

import com.example.roupa.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    public Optional<List<Produto>> findByNome(@Param("nome") String nome);

    public Optional<List<Produto>> findByValor(float valor);


}
