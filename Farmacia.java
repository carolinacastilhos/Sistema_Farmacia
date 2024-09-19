// A classe Farmacia gerencia as operações da farmácia, incluindo a lista de funcionários e medicamentos, o lucro acumulado, 
// e as compras realizadas. Ela permite processar compras, listar funcionários e medicamentos, exibir informações 
// administrativas e limpar lucro e bônus dos funcionários.

import java.util.ArrayList;

public class Farmacia {
    // Atributos privados
    private double lucro;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();

    // Construtor
    public Farmacia() {
        this.lucro = 0;
        //Métodos de inicialização das listas foram criados nas respectivas classes 
        this.funcionarios = Funcionario.inicializarFuncionarios(); 
        this.medicamentos = Medicamento.inicializarMedicamentos();
    }

    // Getter e Setter para lucro
    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    // Getter e Setter para funcionários
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    } 

    // Getter e Setter para medicamentos
    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    // Método para processar a compra de vários medicamentos
    public void processarCompra(Medicamento med, Funcionario fun, int quantidade) {
        if (med.getQuantidadeEstoque() >= quantidade) {
            med.reduzirEstoque(quantidade);  // Reduz o estoque com a quantidade desejada
            this.lucro += med.getPreco() * quantidade;  // Adiciona o valor dos medicamentos ao lucro
            fun.aumentarBonus();  // Aumenta o bônus do funcionário fixamente em 10
            System.out.println("Compra realizada com sucesso! " + quantidade + " unidades de " + med.getNome() + " vendidas.");
        } else {
            System.out.println("Estoque insuficiente para a quantidade solicitada.");
        }
    }
    
    // Método para exibir a lista de funcionários com numeração
    public void listarFuncionarios() {
        System.out.println("\nFUNCIONARIOS");
        int i = 1;  
        for (Funcionario fun : funcionarios) {
            System.out.println(i + ") Nome: " + fun.getNome() + " | Bonus: " + fun.getBonus() + " | Salario base: " + fun.getSalarioBase());
            i++;
    }
}

    // Método para exibir a lista de medicamentos com numeração
    public void listarMedicamentos() {
        System.out.println("\nMEDICAMENTOS");
        int i = 1;  
        for (Medicamento med : medicamentos) {
            System.out.println(i + ") " + med.getNome() + " | Estoque: " + med.getQuantidadeEstoque() + " | Preco: " + med.getPreco());
            i++;
    }
}

    // Método para listar as informações administrativas da farmácia
    public void listarInformacoesFarmacia() {
        System.out.println("\n---- Informacoes Administrativas da Farmacia ----");
        System.out.println("- Lucro atual: R$ " + this.lucro);
    }

    // Método para limpar o lucro e os bônus dos funcionários
    public void limparLucroEBonus() {
        this.lucro = 0; // Redefine o lucro da farmácia

        // Redefine o bônus de todos os funcionários
        for (Funcionario fun : funcionarios) {
            fun.setBonus(0);
        }
        System.out.println("\nOs lucros e os bonus dos funcionarios foram resetados para zero.");
    }
        
}
