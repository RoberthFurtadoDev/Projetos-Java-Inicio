package edu.roberth.segundasemana;

public class boletimEstudantil {

    public static void main(String[] args) {
        int mediaFinal = 8;
        if  (mediaFinal < 6)
            System.out.println("REPROVADO");
        else if (mediaFinal == 6)
            System.out.println("PROVA MIVERVA");
        else
            System.out.println("APROVADO");
    }
}
