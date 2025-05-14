package edu.roberth.terceiraSemana.docs.javadoc;

/**
 * Demonstração completa de documentação JavaDoc com classes aninhadas.
 * <p>
 * Este arquivo contém a implementação de uma SmartTV e sua classe de teste,
 * servindo como exemplo completo de documentação JavaDoc.
 * </p>
 *
 * <h2>Classes Contidas:</h2>
 * <ul>
 *   <li>{@link Comentarios.SmartTv} - Implementação da televisão inteligente</li>
 *   <li>{@link Comentarios.Usuario} - Classe de teste demonstrativa</li>
 * </ul>
 *
 * @author RobertH
 * @version 4.0
 * @since 1.0
 */
public class Comentarios {

    /**
     * Representa uma televisão inteligente com controles básicos.
     * <p>
     * Permite ligar/desligar, ajustar volume e mudar canais.
     * </p>
     */
    public static class SmartTv {
        /**
         * Estado atual da TV (true = ligada, false = desligada).
         * Valor padrão: false (desligada).
         */
        private boolean ligada = false;

        /**
         * Número do canal atual (1-999).
         * Valor padrão: 1.
         */
        private int canal = 1;

        /**
         * Nível atual de volume (0-100).
         * Valor padrão: 25.
         */
        private int volume = 25;

        /**
         * Aumenta o volume em uma unidade.
         * <p>
         * Exemplo:
         * <pre>
         * {@code
         * SmartTv tv = new SmartTv();
         * tv.aumentarVolume();
         * }
         * </pre>
         */
        public void aumentarVolume() {
            if (volume < 100) {
                volume++;
                System.out.println("Volume aumentado para: " + volume);
            }
        }

        /**
         * Diminui o volume em uma unidade.
         */
        public void diminuirVolume() {
            if (volume > 0) {
                volume--;
                System.out.println("Volume diminuído para: " + volume);
            }
        }

        /**
         * Liga a televisão.
         */
        public void ligar() {
            ligada = true;
            System.out.println("TV ligada");
        }

        /**
         * Desliga a televisão.
         */
        public void desligar() {
            ligada = false;
            System.out.println("TV desligada");
        }

        /**
         * Muda para um canal específico.
         * @param novoCanal Número do novo canal (1-999)
         * @throws IllegalArgumentException Se o canal for inválido
         */
        public void mudarCanal(int novoCanal) {
            if (novoCanal < 1 || novoCanal > 999) {
                throw new IllegalArgumentException("Canal inválido. Use valores entre 1 e 999.");
            }
            canal = novoCanal;
            System.out.println("Canal alterado para: " + canal);
        }

        /**
         * Aumenta o canal em uma unidade.
         */
        public void aumentarCanal() {
            canal = (canal % 999) + 1;
            System.out.println("Canal aumentado para: " + canal);
        }

        /**
         * Diminui o canal em uma unidade.
         */
        public void diminuirCanal() {
            canal = (canal - 2 + 999) % 999 + 1;
            System.out.println("Canal diminuído para: " + canal);
        }

        /**
         * Verifica se a TV está ligada.
         * @return true se a TV estiver ligada
         */
        public boolean isLigada() {
            return ligada;
        }

        /**
         * Obtém o canal atual.
         * @return Número do canal atual
         */
        public int getCanal() {
            return canal;
        }

        /**
         * Obtém o volume atual.
         * @return Nível de volume atual
         */
        public int getVolume() {
            return volume;
        }
    }

    /**
     * Classe de teste para demonstração das funcionalidades da SmartTv.
     * <p>
     * Contém exemplos práticos de uso de todos os métodos.
     * </p>
     */
    public static class Usuario {
        /**
         * Método principal para teste das funcionalidades.
         * @param args Argumentos de linha de comando (não utilizado)
         */
        public static void main(String[] args) {
            SmartTv tv = new SmartTv();

            // Demonstração do controle de volume
            System.out.println("=== CONTROLE DE VOLUME ===");
            tv.aumentarVolume();
            tv.diminuirVolume();

            // Demonstração do controle de canais
            System.out.println("\n=== CONTROLE DE CANAIS ===");
            tv.mudarCanal(15);
            tv.aumentarCanal();

            // Demonstração do estado da TV
            System.out.println("\n=== ESTADO DA TV ===");
            tv.ligar();
            System.out.println("TV ligada? " + tv.isLigada());
            tv.desligar();

            // Status final
            System.out.println("\n=== STATUS FINAL ===");
            System.out.println("Canal: " + tv.getCanal());
            System.out.println("Volume: " + tv.getVolume());
        }
    }
}

