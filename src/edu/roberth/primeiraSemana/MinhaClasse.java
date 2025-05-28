package edu.roberth.primeiraSemana;

public class MinhaClasse {
    public static void main(String[] args) {

        String primeiroNome = "Roberth";
        String segundoNome = "Furtado";

        String nomeCompleto = nomeCompleto(primeiroNome, segundoNome);

        System.out.println(nomeCompleto);
    }

    public static String nomeCompleto(String primeiroNome, String segundoNome) {
        return primeiroNome.concat(" ").concat(segundoNome);
    }
}
