package com.example.roupa.repository;

import com.example.roupa.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome")
    public Optional<List<Funcionario>> findByNome(@Param("nome") String nome);

    public Optional<List<Funcionario>> findByIdade(int idade);

    public Optional<List<Funcionario>> findByMatricula(String matricula);

}
