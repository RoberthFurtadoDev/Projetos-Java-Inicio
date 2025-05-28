package edu.roberth.desafios.Dio.estruturasExcepcionais;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class estruturasExcepcionaisTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Variáveis para armazenar os dados
        String nome = "";
        String sobrenome = "";
        int idade = 0;
        double altura = 0.0;

        // Solicitar nome
        System.out.println("Digite seu nome");
        nome = scanner.next();

        // Solicitar sobrenome
        System.out.println("Digite seu sobrenome");
        sobrenome = scanner.next();

        // Solicitar idade com tratamento de exceção
        boolean idadeValida = false;
        while (!idadeValida) {
            try {
                System.out.println("Digite sua idade");
                idade = scanner.nextInt();
                idadeValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Idade precisa ser um número inteiro. Tente novamente.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }

        // Solicitar altura com tratamento de exceção
        boolean alturaValida = false;
        while (!alturaValida) {
            try {
                System.out.println("Digite sua altura");
                altura = scanner.nextDouble();
                alturaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Altura precisa ser um número. Tente novamente.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }

        // Exibir os dados coletados
        System.out.println("Olá, me chamo " + nome.toUpperCase() + " " + sobrenome);
        System.out.println("Tenho " + idade + " anos ");
        System.out.println("Minha altura é " + altura + "cm ");

        scanner.close();
    }
}