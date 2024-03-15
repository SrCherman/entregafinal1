package com.example.roupa.repository;

import com.example.roupa.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query("SELECT c FROM Cliente c WHERE c.nome = :nome")
    public Optional<List<Cliente>> findByNome(@Param("nome") String nome);

    public Optional<List<Cliente>> findByIdade(int idade);

    public Optional<List<Cliente>> findByCpf(String cpf);

}
