public class Item {

    private int id;
    private String nome;
    private Double preco;

    public Item(int id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public Double getPreco() {
        return preco;
    }
}
