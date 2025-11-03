// Importamos ferramentas para ler o que o usuário digita e para sortear números.
import java.util.Scanner;
import java.util.Random;

public class Ado11 {

    public static void main(String[] args) {
        // Ferramenta para ler o que é digitado no teclado.
        Scanner leitor = new Scanner(System.in);
        // Ferramenta para sortear números.
        Random sorteador = new Random();

        // --- 1. Perguntando as regras para o jogador ---
        System.out.print("Qual o tamanho que você quer para o caminho? ");
        int tamanhoDoCaminho = leitor.nextInt();

        System.out.print("Quantas bombas você quer esconder no caminho? ");
        int numeroDeBombas = leitor.nextInt();

        // --- 2. Montando o caminho do jogo ---
        
        // Criamos nosso caminho. É como uma fileira de caixas vazias.
        // Por padrão, cada "caixa" (posição) vem com o número 0.
        int[] caminho = new int[tamanhoDoCaminho];
        
        // Agora, vamos esconder as bombas!
        // A gente sorteia um lugar e, se estiver vazio, coloca uma bomba lá.
        // Uma bomba é representada pelo número -1.
        int bombasJaEscondidas = 0;
        while (bombasJaEscondidas < numeroDeBombas) {
            int lugarSorteado = sorteador.nextInt(tamanhoDoCaminho);
            
            // Se o lugar sorteado estiver vazio (com valor 0)...
            if (caminho[lugarSorteado] == 0) {
                caminho[lugarSorteado] = -1; // ...escondemos uma bomba!
                bombasJaEscondidas++;
            }
        }

        // --- 3. O Jogo Começa! ---
        System.out.println("\nCerto! Prepare-se para começar!");
        int acertos = 0;
        int totalDeLugaresSeguros = tamanhoDoCaminho - numeroDeBombas;

        // O jogo vai ficar repetindo até o jogador ganhar ou perder.
        while (true) {
            // Mostra o caminho para o jogador
            System.out.print("Caminho: ");
            for (int i = 0; i < tamanhoDoCaminho; i++) {
                // Se for um lugar que o jogador já acertou (valor 1)...
                if (caminho[i] == 1) {
                    System.out.print("[ 1 ] "); // ...mostra o número 1.
                } else {
                    System.out.print("[ _ ] "); // Senão, continua escondido.
                }
            }
            System.out.println(); // Pula uma linha para ficar bonito.

            // Pergunta a jogada
            System.out.print("Qual posição você escolhe? ");
            int palpite = leitor.nextInt();
            
            // O computador começa a contar do 0. Então, se você digita 1, para ele é a posição 0.
            int indice = palpite - 1;

            // Verificando o que tem no lugar que o jogador escolheu
            
            // Se tiver uma bomba (-1)...
            if (caminho[indice] == -1) {
                System.out.println("\nBOOM! Você pisou na bomba! FIM DE JOGO.");
                break; // Fim do jogo! Sai do loop.
            
            // Se for um lugar que já foi escolhido...
            } else if (caminho[indice] == 1) {
                System.out.println("Você já escolheu esse lugar. Tente outro!");

            // Se for um lugar seguro (valor 0)...
            } else {
                System.out.println("Ufa! Lugar seguro!");
                caminho[indice] = 1; // Marca o lugar como "acertado".
                acertos++;
            }

            // Verifica se o jogador ganhou
            if (acertos == totalDeLugaresSeguros) {
                System.out.println("\nPARABÉNS! Você achou todos os lugares seguros! VOCÊ VENCEU!");
                break; // Fim do jogo! Sai do loop.
            }
        }
        
        // --- 4. Mostrando o resultado final ---
        System.out.print("O caminho era assim: ");
        for (int i = 0; i < caminho.length; i++) {
            if (caminho[i] == -1) {
                System.out.print("[ B ] "); // B de Bomba
            } else if (caminho[i] == 1) {
                System.out.print("[ 1 ] "); // Lugar que você acertou
            } else {
                System.out.print("[ 0 ] "); // Lugar seguro que você não achou
            }
        }
        System.out.println();

        leitor.close(); // Fecha a ferramenta de leitura.
    }
}