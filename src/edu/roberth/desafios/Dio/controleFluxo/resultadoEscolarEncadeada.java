package edu.roberth.desafios.Dio.controleFluxo;

public class resultadoEscolarEncadeada {
    public static void main(String[] args) {
        int nota = 4;

        if(nota >= 7)
            System.out.println("Aprovado");

        else if (nota >= 5 && nota < 7) //essa condição precisa retornar true ou false.
            System.out.println("Prova de recuperação");

        else
            System.out.println("Reprovado");
    }
}
