import java.util.ArrayList;

public class Cardapio {

    private ArrayList<Item> listaDeItem;

    public Cardapio() {
        listaDeItem = new ArrayList<Item>();
        listaDeItem.add(new Item(1, "Pizza", 35.90));
        listaDeItem.add(new Item(2, "Hambúrguer", 18.50));
        listaDeItem.add(new Item(3, "Salada", 12.00));
        listaDeItem.add(new Item(4, "Lasanha", 22.90));
        listaDeItem.add(new Item(5, "Suco Natural", 7.00));
    }

    public Item getItem(int id) {
        for (Item item : listaDeItem) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public void mostrarCardapio() {
        System.out.println("📜 Cardápio:");
        for (Item item : listaDeItem) {
            System.out.printf("%d. %s - R$%.2f%n", item.getId(), item.getNome(), item.getPreco());
        }
    }



}
