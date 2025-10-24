/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package joguinhoado10;

/**
 *
 * @author igor.jmteodoro
 */
import java.util.Random;
import java.util.Scanner;

public class JoguinhoADO10 {

    public static void main(String[] args) {
        // 1. Configuração inicial do jogo
        Scanner scanner = new Scanner(System.in); // Para ler a entrada do usuário
        Random random = new Random();             // Para gerar o número aleatório

        // Gera um número inteiro aleatório entre 1 e 100.
        // random.nextInt(100) gera um número de 0 a 99, por isso somamos 1.
        int numeroSecreto = random.nextInt(100) + 1;
        
        final int MAX_TENTATIVAS = 5; // Constante para o número de chances
        boolean acertou = false;      // Flag para controlar se o jogador ganhou

        System.out.println("--- Jogo de Adivinhação ---");
        System.out.println("Tente adivinhar o número secreto entre 1 e 100. Você tem 5 chances!");
        
        // 2. Loop principal do jogo
        for (int tentativa = 1; tentativa <= MAX_TENTATIVAS; tentativa++) {
            System.out.println("\n--- Tentativa " + tentativa + " de " + MAX_TENTATIVAS + " ---");
            System.out.print("Digite seu palpite: ");
            int palpite = scanner.nextInt();

            // 3. Verificação das condições do jogo
            if (palpite == numeroSecreto) {
                acertou = true; // O jogador acertou!
                break; // Sai do loop, pois o jogo acabou
            } else {
                // Math.abs() calcula o valor absoluto (módulo) da diferença
                if (Math.abs(numeroSecreto - palpite) == 1) {
                    System.out.println("TÁ QUENTE!");
                }
                
                // Informa se o palpite é maior ou menor que o número secreto
                if (palpite < numeroSecreto) {
                    System.out.println("O número que você digitou é MENOR que o número secreto.");
                } else {
                    System.out.println("O número que você digitou é MAIOR que o número secreto.");
                }
            }
        }

        // 4. Resultado final do jogo
        System.out.println("\n------------------------------");
        if (acertou) {
            System.out.println("Parabéns, você ganhou o jogo!");
        } else {
            System.out.println("Game Over! Você não conseguiu adivinhar.");
            System.out.println("O número secreto era: " + numeroSecreto);
        }
        System.out.println("------------------------------");

        // Boa prática: fechar o scanner para liberar os recursos
        scanner.close();
    }
}