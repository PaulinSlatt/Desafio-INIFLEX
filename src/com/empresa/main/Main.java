package com.empresa.main;

import com.empresa.model.Funcionario;
import com.empresa.service.FuncionarioService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FuncionarioService service = new FuncionarioService();

        // 3.1 - Inserir todos os funcionários
        List<Funcionario> funcionarios = service.inserirFuncionarios();

        // 3.2 - Remover o funcionário “João” da lista
        service.removerFuncionarioPorNome(funcionarios, "João");

        // 3.3 - Imprimir todos os funcionários com todas suas informações
        service.imprimirFuncionarios(funcionarios);

        // 3.4 - Os funcionários receberam 10% de aumento de salário
        service.aumentarSalario(funcionarios, new BigDecimal("0.10"));

        // 3.5 - Agrupar os funcionários por função em um MAP
        Map<String, List<Funcionario>> funcionariosPorFuncao = service.agruparPorFuncao(funcionarios);

        // 3.6 - Imprimir os funcionários agrupados por função
        service.imprimirAgrupadosPorFuncao(funcionariosPorFuncao);

        // 3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12
        service.imprimirAniversariantes(funcionarios, 10, 12);

        // 3.9 - Imprimir o funcionário com a maior idade
        service.imprimirMaisVelho(funcionarios);

        // 3.10 - Imprimir a lista de funcionários por ordem alfabética
        service.imprimirPorOrdemAlfabetica(funcionarios);

        // 3.11 - Imprimir o total dos salários dos funcionários
        service.imprimirTotalSalarios(funcionarios);

        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        service.imprimirSalariosMinimos(funcionarios, salarioMinimo);
    }

    }
