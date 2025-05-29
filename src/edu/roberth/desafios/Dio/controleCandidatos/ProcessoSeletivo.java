package edu.roberth.desafios.Dio.controleCandidatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    // Constantes da classe para melhor manutenção
    private static final double SALARIO_BASE_EMPRESA = 2000.0;
    private static final int MAX_CANDIDATOS_A_SELECIONAR = 5;
    private static final int MAX_TENTATIVAS_CONTATO = 3;
    private static final String[] CANDIDATOS_DISPONIVEIS = {
            "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO",
            "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"
    };

    public static void main(String[] args) {
        System.out.println("--- INÍCIO DO PROCESSO SELETIVO ---");

        System.out.println("\n--- ETAPA 1: TENTATIVA DE CONTATO ---");
        for (String candidato : CANDIDATOS_DISPONIVEIS) {
            // Vamos pegar apenas os 5 primeiros da lista original para a simulação de contato, como no seu main original.
            // Para simular com todos, remova o if abaixo ou ajuste a lista de candidatos para contato.
            // Neste exemplo, vamos tentar contato com um subconjunto para não poluir demais a saída.
            String[] candidatosParaContato = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
            boolean deveTentarContato = false;
            for(String c : candidatosParaContato) {
                if (c.equals(candidato)) {
                    deveTentarContato = true;
                    break;
                }
            }
            if (deveTentarContato) {
                tentarContatoComCandidato(candidato);
            }
        }


        System.out.println("\n--- ETAPA 2: SELEÇÃO DE CANDIDATOS POR SALÁRIO ---");
        String[] candidatosSelecionados = selecionarCandidatosPorSalario(CANDIDATOS_DISPONIVEIS);

        System.out.println("\n--- ETAPA 3: IMPRIMIR LISTA DE CANDIDATOS SELECIONADOS ---");
        imprimirListaCandidatos(candidatosSelecionados, "Candidatos Selecionados por Salário");

        if (candidatosSelecionados.length == 0) {
            System.out.println("Nenhum candidato foi selecionado na etapa de salário.");
        }

        System.out.println("\n--- ETAPA 4: ANÁLISE INDIVIDUAL DE PROPOSTA SALARIAL (EXEMPLOS) ---");
        analisarPropostaSalarialCandidato(1900.0);
        analisarPropostaSalarialCandidato(2000.0);
        analisarPropostaSalarialCandidato(2100.0);

        System.out.println("\n--- FIM DO PROCESSO SELETIVO ---");
    }

    /**
     * Simula as tentativas de contato telefônico com um candidato.
     * Tenta até MAX_TENTATIVAS_CONTATO.
     */
    static void tentarContatoComCandidato(String candidato) {
        int tentativasFeitas = 0;
        boolean contatoEstabelecido = false;
        boolean continuarTentando = true;

        System.out.println("Iniciando contato com: " + candidato);
        do {
            tentativasFeitas++;
            System.out.println("Tentando contato com " + candidato + " - Tentativa " + tentativasFeitas + "/" + MAX_TENTATIVAS_CONTATO);
            contatoEstabelecido = simularAtendimentoTelefonico();

            if (contatoEstabelecido) {
                System.out.println("-> CONTATO REALIZADO COM SUCESSO.");
                continuarTentando = false; // Para o loop
            } else {
                System.out.println("-> Tentativa " + tentativasFeitas + " falhou.");
                if (tentativasFeitas >= MAX_TENTATIVAS_CONTATO) {
                    System.out.println("-> NÚMERO MÁXIMO DE TENTATIVAS ATINGIDO.");
                    continuarTentando = false; // Para o loop
                }
                // Em um cenário real, poderia haver uma pausa aqui:
                // try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        } while (continuarTentando);

        if (contatoEstabelecido) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasFeitas + "ª TENTATIVA.");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " APÓS " + tentativasFeitas + " TENTATIVAS.");
        }
        System.out.println("-".repeat(40)); // Separador visual
    }

    /**
     * Simula se uma ligação foi atendida.
     * @return true se atendida (1/3 de chance), false caso contrário.
     */
    static boolean simularAtendimentoTelefonico() {
        return new Random().nextInt(3) == 1; // Chance de 1 em 3 de atender
    }

    /**
     * Imprime uma lista de candidatos com um título.
     * Demonstra o uso de loop for-each e for com índice.
     */
    static void imprimirListaCandidatos(String[] listaCandidatos, String tituloDaLista) {
        System.out.println("\n--- " + tituloDaLista.toUpperCase() + " ---");
        if (listaCandidatos == null || listaCandidatos.length == 0) {
            System.out.println("Nenhum candidato na lista para imprimir.");
            return;
        }

        System.out.println("Imprimindo a lista de candidatos (total: " + listaCandidatos.length + ") informando o índice:");
        for (int indice = 0; indice < listaCandidatos.length; indice++) {
            System.out.println("O candidato de nº " + (indice + 1) + " é " + listaCandidatos[indice]);
        }

        // System.out.println("\nForma abreviada de interação (for-each):");
        // for (String candidato : listaCandidatos) {
        //     System.out.println("Candidato: " + candidato);
        // }
    }

    /**
     * Seleciona candidatos com base na pretensão salarial.
     * Para quando MAX_CANDIDATOS_A_SELECIONAR são encontrados ou todos os candidatos são processados.
     * @param todosOsCandidatos Array com os nomes de todos os candidatos disponíveis.
     * @return Array com os nomes dos candidatos selecionados.
     */
    static String[] selecionarCandidatosPorSalario(String[] todosOsCandidatos) {
        List<String> selecionadosLista = new ArrayList<>();
        int indiceCandidatoAtual = 0;

        System.out.println("Analisando candidatos para vaga (Salário Base: R$" + SALARIO_BASE_EMPRESA + ")");

        while (selecionadosLista.size() < MAX_CANDIDATOS_A_SELECIONAR && indiceCandidatoAtual < todosOsCandidatos.length) {
            String candidatoAtual = todosOsCandidatos[indiceCandidatoAtual];
            double salarioPretendido = gerarSalarioPretendido();

            System.out.printf("O candidato %s solicitou R$%.2f como salário.%n", candidatoAtual, salarioPretendido);

            if (SALARIO_BASE_EMPRESA >= salarioPretendido) {
                System.out.println("-> O candidato " + candidatoAtual + " FOI SELECIONADO para a vaga!");
                selecionadosLista.add(candidatoAtual);
            } else {
                System.out.println("-> O candidato " + candidatoAtual + " não foi selecionado (salário pretendido acima do base).");
            }
            indiceCandidatoAtual++;
        }
        // Converte a lista para um array de String
        return selecionadosLista.toArray(new String[0]);
    }

    /**
     * Gera um valor de salário pretendido aleatório.
     * @return um double entre 1800.0 (inclusivo) e 2200.0 (exclusivo).
     */
    static double gerarSalarioPretendido() {
        // No seu código original era (1800, 2000).
        // Vou manter o seu original para ser fiel, mas um range maior como (1800, 2300) daria mais variação.
        return ThreadLocalRandom.current().nextDouble(1800.0, 2000.0);
    }

    /**
     * Analisa a pretensão salarial de um candidato em relação ao salário base da empresa.
     */
    static void analisarPropostaSalarialCandidato(double salarioPretendido) {
        System.out.printf("Analisando salário pretendido de R$%.2f (Base da empresa: R$%.2f)%n", salarioPretendido, SALARIO_BASE_EMPRESA);
        if (SALARIO_BASE_EMPRESA > salarioPretendido) {
            System.out.println("-> LIGAR PARA O CANDIDATO: Salário abaixo do base, ótima proposta!");
        } else if (SALARIO_BASE_EMPRESA == salarioPretendido) {
            System.out.println("-> LIGAR PARA O CANDIDATO: Salário igual ao base, proposta alinhada.");
        } else { // salarioBase < salarioPretendido
            System.out.println("-> AVALIAR POSTERIORMENTE: Salário acima do base. Considerar se o perfil é excepcional.");
        }
    }
}