import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {

    private String nomeCliente;
    private ArrayList<Item> itensDoPedido;


    public Pedido(String nome) {
        itensDoPedido = new ArrayList<>();
        nomeCliente = nome;
    }

    Scanner sc = new Scanner(System.in);


    public void PedidoMenu() {

        while (true) {
            Cardapio cardapio = new Cardapio();
            cardapio.mostrarCardapio();
            System.out.print("\nDigite o número do item: ");
            String x = sc.nextLine();

            try {
                Item itemEncontrado = cardapio.getItem(Integer.parseInt(x));

                if (itemEncontrado != null) {
                    adicionarItem(itemEncontrado);
                    System.out.println("\n✅ Item adicionado ao pedido: " + itemEncontrado.getNome());
                    System.out.println("\n0. Finalizar Pedido: ");
                    System.out.println("1. Continuar comprando: ");
                    System.out.println("\nDigite sua opção: ");
                    String y = sc.nextLine();
                    if (y.equals("0")) {
                        finalizacaoPedido();
                        return;
                    }
                } else {
                    System.out.println("\n❌ Item não encontrado!");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n⚠ Entrada inválida! Digite um número.");
            }
        }
    }

    public void adicionarItem(Item item) {
        itensDoPedido.add(item);
    }

    public void mostrarPedido() {
        System.out.println("\n🛒 Sua Nota Fiscal:");
        for (Item item : itensDoPedido) {
            System.out.printf("- %s: R$%.2f%n", item.getNome(), item.getPreco());
        }
        System.out.printf("\nTotal: R$%.2f%n", getValorTotal());
    }

    public double getValorTotal() {
        return calcularTotal();
    }


    private double calcularTotal() {
        double total = 0.0;
        for (Item item : itensDoPedido) {
            total += item.getPreco();
        }
        return total;
    }

    public double calcularTaxaDeServico() {
        Double taxa = 1.1;
        Double total = getValorTotal();
        return total * taxa;
    }

    public void finalizacaoPedido() {
        mostrarPedido();
        System.out.println("Valor taxa de serviço: 10%");
        System.out.printf("\n💸 Valor total (Com a taxa): R$%.2f%n", calcularTaxaDeServico());
        while (true) {
            System.out.println("\nDigite quantos R$ foi recebido: ");
            Double dinheiroRecebido = Double.parseDouble(sc.nextLine());
            if (dinheiroRecebido < getValorTotal()) {
                System.out.println("O dinheiro não foi suficiente para pagar a conta, informe o cliente");

            } else if (dinheiroRecebido >= getValorTotal()) {
                Double troco = dinheiroRecebido - calcularTaxaDeServico();
                System.out.printf("O troco foi R$%.2f%n", troco);
                break;
            }
        }


    }

}
