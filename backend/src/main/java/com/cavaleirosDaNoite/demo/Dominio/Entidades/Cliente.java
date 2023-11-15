package com.cavaleirosDaNoite.demo.Dominio.Entidades;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;

@Entity(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    @JsonManagedReference
    private Set<Pedido> pedidos;

    public Cliente(long id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;

    }

    protected Cliente() {
    }


    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {

        return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha
                + ", pedidos=" + pedidos + "]";
    }
}
