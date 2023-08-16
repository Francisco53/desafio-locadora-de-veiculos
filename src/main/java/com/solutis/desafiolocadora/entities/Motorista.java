package com.solutis.desafiolocadora.entities;

import com.solutis.desafiolocadora.enumeration.Sexo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table
public class Motorista extends Pessoa{

    @NotBlank
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0-9]+")
    private String numeroCNH;

    public Motorista(){

    }

    public Motorista(String nome, LocalDate dataNascimento, String cpf, String email, Sexo sexo, String numeroCNH) {
        super(nome, dataNascimento, cpf, email, sexo);
        this.numeroCNH = numeroCNH;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }
}
