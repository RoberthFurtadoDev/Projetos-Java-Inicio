package edu.roberth.DesafioControleFluxo;

// Arquivo: Contador.java
import java.util.Scanner;
import java.util.InputMismatchException; // Import para tratar entrada inválida

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        int parametroUm = 0;
        int parametroDois = 0;

        try {
            System.out.println("Digite o primeiro parâmetro (número inteiro):");
            parametroUm = terminal.nextInt(); // Lê o primeiro parâmetro

            System.out.println("Digite o segundo parâmetro (número inteiro):");
            parametroDois = terminal.nextInt(); // Lê o segundo parâmetro

            // Chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException exception) {
            // Imprimir a mensagem da exceção customizada
            System.out.println(exception.getMessage());
        } catch (InputMismatchException e) {
            // Tratar o caso em que o usuário não digita um número inteiro
            System.out.println("Erro: Os parâmetros devem ser números inteiros válidos.");
        } finally {
            terminal.close(); // Boa prática: fechar o Scanner
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm >= parametroDois) { // Alterado para >= para incluir o caso de serem iguais, onde não haveria iteração positiva
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm;

        // Realizar o for para imprimir os números com base na variável contagem
        System.out.println("\nIniciando a contagem...");
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
        System.out.println("Contagem finalizada!");
    }
}
