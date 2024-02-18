package jogo; // Declaração do pacote onde a classe JogoDaForca está localizada

import java.util.Scanner; // Importação da classe Scanner para entrada de dados

public class JogoDaForca { // Declaração da classe principal

    public static void main(String[] args) { // Método principal onde o programa inicia a execução
        Scanner scanner = new Scanner(System.in); // Criação de um objeto Scanner para capturar a entrada do usuário
        String palavraSecreta = "PROGRAMACAO"; // Declaração da palavra secreta que o jogador precisa adivinhar
        int tentativas = 6; // Número máximo de tentativas permitidas
        boolean[] letrasEncontradas = new boolean[palavraSecreta.length()]; // Array para acompanhar as letras acertadas

        System.out.println("Bem-vindo ao Jogo da Forca!"); // Mensagem de boas-vindas
        System.out.println("Descubra a palavra secreta."); // Instrução para o jogador

        while (tentativas > 0 && !palavraRevelada(letrasEncontradas)) { // Loop enquanto houver tentativas e a palavra não foi revelada
            System.out.println("\nPalavra: " + palavraAtual(palavraSecreta, letrasEncontradas)); // Mostra a palavra atual com as letras acertadas e as não reveladas
            System.out.println("Tentativas restantes: " + tentativas); // Mostra o número de tentativas restantes
            System.out.print("Digite uma letra: "); // Solicita ao jogador que digite uma letra
            char tentativa = scanner.next().toUpperCase().charAt(0); // Captura a letra digitada pelo usuário e a converte para maiúscula

            boolean acertou = false; // Variável para verificar se a letra está correta ou não
            for (int i = 0; i < palavraSecreta.length(); i++) { // Loop para verificar se a letra digitada está na palavra secreta
                if (palavraSecreta.charAt(i) == tentativa) { // Verifica se a letra está na palavra secreta
                    letrasEncontradas[i] = true; // Marca a posição correspondente da letra encontrada como verdadeira
                    acertou = true; // Indica que a letra foi encontrada na palavra secreta
                }
            }

            if (!acertou) { // Se a letra digitada não estiver na palavra secreta
                tentativas--; // Reduz o número de tentativas
                System.out.println("Letra incorreta!"); // Informa que a letra digitada está incorreta
            } else {
                System.out.println("Letra correta!"); // Informa que a letra digitada está correta
            }
        }

        if (palavraRevelada(letrasEncontradas)) { // Verifica se a palavra foi revelada (todas as letras foram encontradas)
            System.out.println("\nParabéns! Você acertou a palavra: " + palavraSecreta); // Mensagem de parabéns ao jogador
        } else {
            System.out.println("\nGame Over! A palavra era: " + palavraSecreta); // Mensagem informando que o jogo acabou e revelando a palavra secreta
        }

        scanner.close(); // Fecha o Scanner para liberar recursos
    }

    private static String palavraAtual(String palavraSecreta, boolean[] letrasEncontradas) {
        StringBuilder palavra = new StringBuilder(); // Criação de um StringBuilder para construir a palavra revelada
        for (int i = 0; i < palavraSecreta.length(); i++) { // Loop para percorrer a palavra secreta
            if (letrasEncontradas[i]) { // Se a letra na posição i foi encontrada
                palavra.append(palavraSecreta.charAt(i)).append(" "); // Adiciona a letra à palavra revelada
            } else {
                palavra.append("_ "); // Se a letra não foi encontrada, adiciona um espaço para representar uma letra não revelada
            }
        }
        return palavra.toString(); // Retorna a palavra atualizada
    }

    private static boolean palavraRevelada(boolean[] letrasEncontradas) {
        for (boolean encontrada : letrasEncontradas) { // Loop para verificar se todas as letras foram encontradas
            if (!encontrada) { // Se alguma letra não foi encontrada
                return false; // Retorna falso indicando que a palavra ainda não foi totalmente revelada
            }
        }
        return true; // Se todas as letras foram encontradas, retorna verdadeiro indicando que a palavra foi totalmente revelada
    }
}
