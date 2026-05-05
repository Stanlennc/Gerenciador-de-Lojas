
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;
        int opcao = 0;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da loja: ");
                    String nomeLoja = teclado.nextLine();
                    System.out.print("Quantidade de funcionários: ");
                    int qtdFunc = teclado.nextInt();
                    System.out.print("Salário base: ");
                    int salario = teclado.nextInt();


                    System.out.println("Dados do Endereço:");
                    teclado.nextLine();
                    System.out.print("Rua: ");
                    String rua = teclado.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = teclado.nextLine();
                    System.out.print("Estado: ");
                    String estado = teclado.nextLine();
                    System.out.print("País: ");
                    String pais = teclado.nextLine();
                    System.out.print("CEP: ");
                    String cep = teclado.nextLine();
                    System.out.print("Número: ");
                    String num = teclado.nextLine();
                    System.out.print("Complemento: ");
                    String comp = teclado.nextLine();
                    Endereco end = new Endereco(rua, cidade, estado, pais, cep, num, comp);

                    System.out.println("Data de fundação:");
                    System.out.print("Dia: ");
                    int dF = teclado.nextInt();
                    System.out.print("Mês: ");
                    int mF = teclado.nextInt();
                    System.out.print("Ano: ");
                    int aF = teclado.nextInt();
                    Data dataFund = new Data(dF, mF, aF);
                    System.out.print("Capacidade do estoque :");
                    int tamanhoEstoque = teclado.nextInt();

                    loja = new Loja(nomeLoja, qtdFunc, salario, end, dataFund, tamanhoEstoque);
                    System.out.println("Loja criada com sucesso!");
                    break;

                case 2:
                    if (loja == null) {
                        System.out.println("Erro: Crie uma loja primeiro (Opção 1) antes de cadastrar produtos.");
                        break;
                    }

                    System.out.print("Nome do produto: ");
                    String nomeProd = teclado.nextLine();
                    System.out.print("Preço: ");
                    double preco = teclado.nextDouble();

                    System.out.println("Data de validade:");
                    System.out.print("Dia: ");
                    int dV = teclado.nextInt();
                    System.out.print("Mês: ");
                    int mV = teclado.nextInt();
                    System.out.print("Ano: ");
                    int aV = teclado.nextInt();
                    Data dataVal = new Data(dV, mV, aV);

                    produto = new Produto(nomeProd, preco, dataVal);


                    if (loja.insereProduto(produto)) {
                        System.out.println("Produto criado e adicionado ao estoque!");
                    } else {
                        System.out.println("Erro: Estoque da loja está cheio!");
                    }
                    break;


                case 3:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 3);

        if (produto != null && loja != null) {
            Data dataReferencia = new Data(20, 10, 2023);

            if (produto.estaVencido(dataReferencia)) {
                System.out.println("PRODUTO VENCIDO");
            } else {
                System.out.println("PRODUTO NÃO VENCIDO");
            }

            loja.imprimeProdutos();

            System.out.println("\n--- Resumo da Loja ---");
            System.out.println(loja.toString());

        }

        teclado.close();
    }
}