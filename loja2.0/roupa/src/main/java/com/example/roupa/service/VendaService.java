package com.example.roupa.service;


import com.example.roupa.entity.Produto;
import com.example.roupa.entity.Venda;
import com.example.roupa.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public Optional<List<Venda>> findByCliente(String nome)
    {
        Optional<List<Venda>> lista = this.repository.findByClienteNome(nome);
        return lista;
    }

    public Optional<List<Venda>> findByFuncionario(String nome)
    {
        Optional<List<Venda>> lista = this.repository.findByFuncionarioNome(nome);
        return lista;
    }

    public Optional<List<Venda>> findByEndereco(String endereco)
    {
        Optional<List<Venda>> lista = this.repository.findByEndereco(endereco);
        return lista;
    }

    public Venda findById(Long id)
    {
        Venda venda = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
        return venda;
    }

    public List<Venda> listAll(){

        List<Venda> lista = this.repository.findAll();
        if(lista.isEmpty())
        {
            throw new RuntimeException("lista vazia");
        }
        return lista;
    }

    public Venda save(Venda venda)
    {
        //venda.setValor_total(somaValor(venda.getProdutos()));
        Venda vendaSalvo = this.repository.save(venda);
        return vendaSalvo;
    }

    public Venda update(Long id, Venda venda)
    {
        if(id != venda.getId())
        {
            throw new RuntimeException("ID não coincidem");
        }
        venda.setValor_total(somaValor(venda.getProdutos()));
        Venda vendaSalvo = this.repository.save(venda);
        return vendaSalvo;
    }

    public String delete(Long id)
    {
        Venda venda = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        this.repository.deleteById(id);
        return "Deletado com sucesso";
    }

    private float somaValor(List<Produto> produtos)
    {
        float valorTotal = 0;
        for(Produto produto : produtos)
        {
            valorTotal += produto.getValor();
        }
        return valorTotal;
    }
}
