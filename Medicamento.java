// A classe Medicamento representa um medicamento da farmácia, incluindo informações sobre o nome, a 
// quantidade disponível no estoque e o preço de cada unidade. Ela gerencia a redução do estoque e 
// inicializa uma lista de medicamentos.

import java.util.ArrayList;

public class Medicamento {
    // Atributos privados
    private String nome;
    private int quantidadeEstoque;
    private double preco;

    // Construtor
    public Medicamento(String nome, int quantidadeEstoque, double preco){
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
    }    

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para quantidadeEstoque
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getter e Setter para preco
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método estático para inicializar a lista de medicamentos
    public static ArrayList<Medicamento> inicializarMedicamentos() {
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(new Medicamento("Dipirona", 10, 10.50));
        medicamentos.add(new Medicamento("Paracetamol", 15, 15.00));
        medicamentos.add(new Medicamento("Buscopan", 20, 20.50));
        medicamentos.add(new Medicamento("Amoxicilina", 15, 40.00));
        medicamentos.add(new Medicamento("Vit B12", 30, 30.00));
        return medicamentos;
    }

    // Método para reduzir a quantidade do medicamento no estoque com a compra
    public void reduzirEstoque(int quantidade) {
        if (this.quantidadeEstoque >= quantidade) {
            this.quantidadeEstoque -= quantidade;
        } else {
            System.out.println("Estoque insuficiente para a quantidade solicitada.");
        }
    }
}
