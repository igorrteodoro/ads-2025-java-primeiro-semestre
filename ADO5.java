import java.util.Scanner;

public class ADO5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU DO JOGO =====");
            System.out.println("1 - Instruções");
            System.out.println("2 - Jogar");
            System.out.println("3 - Créditos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Instruções: Escolha a opção desejada e siga as orientações do jogo.");
                    break;
                case 2:
                    System.out.println("Iniciando o jogo...");
                    break;
                case 3:
                    System.out.println("Créditos: Jogo desenvolvido por Igor.");
                    break;
                case 4:
                    System.out.println("Saindo do jogo. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
