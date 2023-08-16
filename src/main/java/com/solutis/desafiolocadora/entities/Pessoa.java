package com.solutis.desafiolocadora.entities;

import com.solutis.desafiolocadora.enumeration.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "inc")
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;
    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Pessoa(){

    }

    public Pessoa(String nome, LocalDate dataNascimento, String cpf, String email, Sexo sexo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}

