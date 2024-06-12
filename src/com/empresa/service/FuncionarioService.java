package com.empresa.service;
import com.empresa.model.Funcionario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class FuncionarioService {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    public List<Funcionario> inserirFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", "18/10/2000", new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente"));
        return funcionarios;
    }

    public void removerFuncionarioPorNome(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + funcionario.getDataNascimento().format(dateFormatter));
            System.out.println("Salário: R$" + decimalFormat.format(funcionario.getSalário()));
            System.out.println("Função: " + funcionario.getFunção());
            System.out.println();
        }
    }

    public void aumentarSalario(List<Funcionario> funcionarios, BigDecimal percentual) {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalário().multiply(percentual);
            funcionario.setSalário(funcionario.getSalário().add(aumento));
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            funcionariosPorFuncao.computeIfAbsent(funcionario.getFunção(), k -> new ArrayList<>()).add(funcionario);
        }
        return funcionariosPorFuncao;
    }

    public void imprimirAgrupadosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        System.out.println("Funcionários agrupados por função:");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                System.out.println("Nome: " + funcionario.getNome() + ", Salário: R$" + decimalFormat.format(funcionario.getSalário()));
            }
            System.out.println();
        }
    }

    public void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
        Set<Integer> mesesSet = new HashSet<>();
        for (int mes : meses) {
            mesesSet.add(mes);
        }
        System.out.println("Funcionários com aniversário nos meses especificados:");
        for (Funcionario funcionario : funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            if (mesesSet.contains(mesAniversario)) {
                System.out.println("Nome: " + funcionario.getNome() + ", Data de Nascimento: " + funcionario.getDataNascimento().format(dateFormatter));
            }
        }
    }

    public void imprimirMaisVelho(List<Funcionario> funcionarios) {
        LocalDate hoje = LocalDate.now();
        Funcionario maisVelho = Collections.max(funcionarios, Comparator.comparing(f -> f.getDataNascimento().until(hoje).getYears()));
        int idade = maisVelho.getDataNascimento().until(hoje).getYears();
        System.out.println("Funcionário mais velho:");
        System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade);
    }

    public void imprimirPorOrdemAlfabetica(List<Funcionario> funcionarios) {
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("Lista de funcionários por ordem alfabética:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
        }
    }

    public void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal totalSalarios = funcionarios.stream().map(Funcionario::getSalário).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários dos funcionários: R$" + decimalFormat.format(totalSalarios));
    }

    public void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        System.out.println("Salários em relação ao salário mínimo:");
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salariosMinimos = funcionario.getSalário().divide(salarioMinimo, 2, BigDecimal.ROUND_DOWN);
            System.out.println("Nome: " + funcionario.getNome() + ", Salários Mínimos: " + salariosMinimos);
        }
    }
}
