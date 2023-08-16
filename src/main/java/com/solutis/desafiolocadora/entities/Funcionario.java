package com.solutis.desafiolocadora.entities;

import com.solutis.desafiolocadora.enumeration.Sexo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Funcionario extends Pessoa{

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    private String matricula;

    public Funcionario() {
    }

    public Funcionario(String nome, LocalDate dataNascimento, String cpf, String email, Sexo sexo, String matricula) {
        super(nome, dataNascimento, cpf, email, sexo);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
