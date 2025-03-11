import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 2) {
            System.out.println("\n**** Menu ****");
            System.out.println("1. Fazer pedido");
            System.out.println("2. Sair");
            System.out.print("Digite a sua opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("\nDigite seu nome: ");
                        String nome = scanner.nextLine();
                        Pedido novoPedido = new Pedido(nome);
                        novoPedido.PedidoMenu();
                    case 2:
                        System.out.println("\n🚪 Saindo... Obrigado!");
                        break;
                    default:
                        System.out.println("\n⚠ Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n⚠ Entrada inválida! Digite um número.");
            }
        }
        scanner.close();

    }
}