package edu.roberth.desafios.Dio.estruturasRepetição;

public class exemploContinue {
    public static void main(String[] args) {
        for (int numero = 1; numero <=5; numero ++) {
            if(numero == 5)
                continue;

            System.out.println(numero);
        }
    }
}
