package edu.roberth.desafios.Dio.controleCandidatos;


import java.util.concurrent.ThreadLocalRandom;
public class processoSeletivo {
    public static void main(String[] args) {
        selecaoCandidatos();
    }
        static void selecaoCandidatos() {

            String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE" };

            int candidatosSelecionados = 0;
            int canditadosAtual = 0;
            double salarioBase=2000.0;
            while (candidatosSelecionados < 5 && canditadosAtual < candidatos.length) {
                String candidato = candidatos[canditadosAtual];
                double salarioPretendido = valorPretendido();

                System.out.println("O canditado " + candidato + "Solicitou este valor de salario" + salarioPretendido);
                if (salarioBase >= salarioPretendido) {
                    System.out.println("O candidato " + candidato + "foi selecionado para vaga");
                    candidatosSelecionados++;
                }
                canditadosAtual++;
            }
        }
        static double valorPretendido() {
            return ThreadLocalRandom.current().nextDouble(1800, 2000);
        }
        static void analisarCanditado(double salarioPrentendido) {
            double salarioBase = 2000.0;
            if (salarioBase > salarioPrentendido) {
                System.out.println("LIGAR PARA O CANDITADO");
        }else if(salarioBase==salarioPrentendido)
                System.out.println("LIGAR PARA O CANDITADO COM CONTRA PROPOSTA");
         else {
                System.out.println("LIGAR PARA O CANDITADO");
            }

    }
}
