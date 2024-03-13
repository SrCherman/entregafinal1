package com.example.roupa.controller;

import com.example.roupa.entity.Cliente;
import com.example.roupa.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping("/nome")
    public ResponseEntity<Optional<List<Cliente>>> findByNome(@RequestParam String n){
        try {
            Optional<List<Cliente>> lista = this.service.findByNome(n);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/idade")
    public ResponseEntity<Optional<List<Cliente>>> findByIdade(@RequestParam int i){
        try {
            Optional<List<Cliente>> lista = this.service.findByIdade(i);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Optional<List<Cliente>>> findByCpf(@RequestParam String cpf){
        try {
            Optional<List<Cliente>> lista = this.service.findByCpf(cpf);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@RequestParam Long id)
    {
        try {
            Cliente cliente = this.service.findById(id);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> listAll(){
        try {
            List<Cliente> lista = this.service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente)
    {
        try {
            Cliente clienteSalvo = this.service.save(cliente);
            return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestParam Long id ,@RequestBody Cliente cliente)
    {
        try {
            Cliente clienteSalvo = this.service.update(id, cliente);
            return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Long id)
    {
        try {
            String mensagem = this.service.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
