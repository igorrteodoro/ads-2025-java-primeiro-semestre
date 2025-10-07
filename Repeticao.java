// Define o pacote onde a classe está localizada.
package com.mycompany.repeticao;

// Importa a classe Scanner para que possamos ler a entrada do usuário no console.
import java.util.Scanner;

public class Repeticao {

    public static void main(String[] args) {

        // 1. PREPARAÇÃO
        Scanner scanner = new Scanner(System.in);
        String usuarioCadastrado;
        String senhaCadastrada;

        // 2. FASE DE CRIAÇÃO (CADASTRO) - Acontece apenas uma vez.
        System.out.println("--- CRIAÇÃO DE CONTA ---");
        
        System.out.print("Crie seu nome de usuário: ");
        usuarioCadastrado = scanner.next();

        System.out.print("Crie sua senha: ");
        senhaCadastrada = scanner.next();

        System.out.println("\n>> Usuário '" + usuarioCadastrado + "' criado com sucesso! <<");
        System.out.println("---------------------------------");
        
        // 3. FASE DE LOGIN COM REPETIÇÃO
        boolean loginSucesso = false;
        int tentativasRestantes = 3;

        // O laço 'do-while' garante que o bloco de login execute pelo menos uma vez.
        do {
            System.out.println("\n--- EFETUAR LOGIN ---");
            System.out.println("Você tem " + tentativasRestantes + " tentativa(s).");
            
            System.out.print("Digite seu usuário: ");
            String usuarioLogin = scanner.next();

            System.out.print("Digite sua senha: ");
            String senhaLogin = scanner.next();

            // 4. VERIFICAÇÃO
            if (usuarioLogin.equals(usuarioCadastrado) && senhaLogin.equals(senhaCadastrada)) {
                System.out.println("\nLogin efetuado com sucesso. Bem-vindo(a), " + usuarioCadastrado + "!");
                loginSucesso = true; // Sinaliza que o login deu certo para sair do laço.
            } else {
                tentativasRestantes--; // Diminui o número de tentativas.
                System.out.println("\nUsuário ou senha incorretos.");
            }

        // O laço continua ENQUANTO o login não for bem-sucedido E ainda houver tentativas.
        } while (!loginSucesso && tentativasRestantes > 0);
        
        // Mensagem final se as tentativas acabarem.
        if (!loginSucesso) {
            System.out.println("\nNúmero de tentativas excedido. Acesso bloqueado.");
        }
        
        // 5. LIMPEZA
        // Fechamos o scanner no final de tudo.
        scanner.close();
    }
}