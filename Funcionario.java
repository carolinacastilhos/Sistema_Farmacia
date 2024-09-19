// A classe Funcionario representa um funcionário da farmácia, contendo detalhes sobre o nome, 
// o bônus acumulado e o salário base. Ela gerencia o aumento de bônus e o ajuste no salário base 
// conforme o desempenho do funcionário.


import java.util.ArrayList;

public class Funcionario {
    // Atributos privados
    private String nome;
    private int bonus;
    private double salarioBase;

    // Construtor
    public Funcionario(String nome, int bonus, double salarioBase){
        this.nome = nome;
        this.bonus = bonus;
        this.salarioBase = salarioBase;
    }    

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para bonus
    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    // Getter e Setter para salarioBase
    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }    
    
    // Método estático para inicializar a lista de funcionários
    public static ArrayList<Funcionario> inicializarFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("A", 0, 0));
        funcionarios.add(new Funcionario("B", 0, 0));
        funcionarios.add(new Funcionario("C", 0, 0));
        funcionarios.add(new Funcionario("D", 0, 0));
        funcionarios.add(new Funcionario("E", 0, 0));
        return funcionarios;
    }

    // Método para aumentar o bônus e verificar se o salário deve ser aumentado
    public void aumentarBonus() {
        this.bonus += 10;
        System.out.println("Bonus atual de " + this.nome + ": " + this.bonus);

        // Se o bônus atingir 30, o salário base aumenta em 100
        if (this.bonus >= 30) {
            int aumentosSalario = this.bonus / 30;
            this.salarioBase += 100 * aumentosSalario;
            System.out.println("Salario de " + this.nome + " aumentado para: R$ " + this.salarioBase);
        }
    }

}
