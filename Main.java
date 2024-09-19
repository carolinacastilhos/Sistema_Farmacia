// DIGPORT - Digitalization Portfolio Program from SAP
// Aluna: Carolina Castilhos da Silva | e-mail: carolinacastilhoss@outlook.com
// Data: Setembro 2024

// Mini Projeto II: 
//        O objetivo do projeto é a criação de um sistema de gestão de farmácia que 
//        mostra informações administrativas da empresa, como uma lista de funcionários,
//        de medicamentos disponíveis para estoque e lucros da farmácia. Além disso, 
//        o sistema serve para gerir a compra, informando qual o medicamento a ser comprado, 
//        quantidade e qual funcionário ajudará na venda.

// Regras de negócio:
//        1. O valor do medicamento vendido é adicionado ao lucro da farmácia 
//        2. A cada compra com um funcionário, seu bônus vai aumentar em 10, independente da quantidade de medicamentos da compra
//        3. A cada 30 de bonus, o salario base do funcionário aumenta em 100 reais

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Adicionado para criar uma interação com o usuário no terminal 
        Scanner scanner = new Scanner(System.in); 
        Farmacia farmacia = new Farmacia(); 

        //Inicializando a variável 'continuar' com true para ser utilizada no while
        boolean continuar = true; 

        //Loop de interação do sistema com o usuário
        while(continuar) {
            System.out.println("\n-----------------------------------------");
            System.out.println("--------------- FARMACIA ----------------");
            System.out.println("-----------------------------------------");
            System.out.println("1) Listar os funcionarios");
            System.out.println("2) Listar os medicamentos do estoque");
            System.out.println("3) Listar informacoes administrativas da farmacia");
            System.out.println("4) Comprar medicamento");
            System.out.println("5) Resetar lucro e bonus");
            System.out.println("0) Sair");
            System.out.println("\n");
            System.out.print("Escolha uma opcao: ");
            int escolha = scanner.nextInt(); 
            scanner.nextLine();  

            switch (escolha) {
                case 1: 
                    farmacia.listarFuncionarios(); 
                    break; 

                case 2:
                    farmacia.listarMedicamentos();  
                    break;

                case 3:
                    farmacia.listarInformacoesFarmacia(); 
                    break;

                case 4:
                    System.out.println("\n---- Medicamentos disponiveis para compra ----");
                    farmacia.listarMedicamentos();
                    System.out.print("\nEscolha o numero do medicamento que gostaria de comprar: ");
                    int medEscolha = scanner.nextInt();
                    scanner.nextLine();

                    if (medEscolha >= 1 && medEscolha <= farmacia.getMedicamentos().size()) {
                        Medicamento medEscolhido = farmacia.getMedicamentos().get(medEscolha - 1);

                        System.out.print("\nQuantas unidades deseja comprar? ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();

                        if (quantidade > 0 && quantidade <= medEscolhido.getQuantidadeEstoque()) {
                            System.out.println("\n---- Funcionarios disponiveis para te ajudar na compra ----");
                            farmacia.listarFuncionarios();
                            System.out.print("\nEscolha o numero do funcionario que realizara a venda: ");
                            int funEscolha = scanner.nextInt();
                            scanner.nextLine(); 

                            if (funEscolha >= 1 && funEscolha <= farmacia.getFuncionarios().size()) {
                                Funcionario funEscolhido = farmacia.getFuncionarios().get(funEscolha - 1);
                                
                                farmacia.processarCompra(medEscolhido, funEscolhido, quantidade);
                            } else {
                                System.out.println("Funcionario nao encontrado.");
                            }
                        } else {
                            System.out.println("Estoque insuficiente para a quantidade escolhida.");
                        }
                    } else {
                        System.out.println("Medicamento nao encontrado.");
                    }
                    break;

                case 5:
                    farmacia.limparLucroEBonus();  
                    break;

                case 0:
                    continuar = false;
                    System.out.println("Sistema encerrado. Obrigada pela presenca e ate a proxima!");
                    break;

                default: 
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        scanner.close();        
    }
}
