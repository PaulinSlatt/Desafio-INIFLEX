package com.empresa.model;

import java.math.BigDecimal;

public class Funcionario extends Pessoa {
    private BigDecimal salário;
    private String função;

    public Funcionario(String nome, String dataNascimento, BigDecimal salário, String função) {
        super(nome, dataNascimento);
        this.salário = salário;
        this.função = função;
    }

    public BigDecimal getSalário() {
        return salário;
    }

    public void setSalário(BigDecimal salário) {
        this.salário = salário;
    }

    public String getFunção() {
        return função;
    }
}

