/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package avaliacao.n1;

/**
 *
 * @author Rodrigo Ramos <rodrigoramos.rr221@gmail.com>
 * @date 08/03/2024
 * @brief Class ES2P
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prova1 {
    public static void main(String[] args) {
        
        // Declaração e inicialização das variáveis para rastrear as quantidades e valores dos cafés vendidos
        int opcao = 0, qde_expresso = 0, qde_capuccino = 0, qde_leite_com_cafe = 0;
        double valor_expresso = 0, valor_capuccino = 0, valor_leite_com_cafe = 0, valor_cafes_vendidos = 0;
        
        // Mapa para armazenar os produtos e seus respectivos preços
        Map<Integer, Double> precos = new HashMap<>();
        precos.put(1, 0.75); // Preço do café expresso
        precos.put(2, 1.0);  // Preço do café cappuccino
        precos.put(3, 1.25); // Preço do leite com café
        
        // Objeto Scanner para a entrada do usuário
        Scanner sc = new Scanner(System.in);
    
        // Loop para fornecer opções até que o usuário escolha sair
        do {
            // Exibição das opções de produtos
            System.out.println("Forneça uma opção: \n"+
                                "1 - café expresso; \n"+
                                "2 - café cappuccino; \n"+
                                "3 - leite com café; \n"+
                                "4 - totalizar vendas; \n"+
                                "5 - incluir novo produto; \n"+
                                "6 - excluir produto da lista; \n"+
                                "7 - pagamento parcial; \n"+
                                "8 - pagamento total;");
      
            // Leitura da opção do usuário
            opcao = sc.nextInt();
      
            // Realiza a operação de acordo com a opção escolhida
            switch(opcao) {
                case 1:
                    qde_expresso++;
                    valor_expresso += precos.get(1);
                    break;
                case 2:
                    qde_capuccino++;
                    valor_capuccino += precos.get(2);
                    break;
                case 3:
                    qde_leite_com_cafe++;
                    valor_leite_com_cafe += precos.get(3);
                    break;
                case 4:
                    // Cálculo do total de vendas
                    valor_cafes_vendidos = valor_expresso + valor_capuccino + valor_leite_com_cafe;
                    // Saída dos resultados
                    System.out.println("Qde café expresso: "+qde_expresso+" - valor: "+valor_expresso);
                    System.out.println("Qde café cappuccino: "+qde_capuccino+" - valor: "+valor_capuccino);    
                    System.out.println("Qde leite com café: "+qde_leite_com_cafe+
                                        " - valor: "+valor_leite_com_cafe);        
                    System.out.println("Qde cafés vendidos: "+ (qde_expresso + qde_capuccino + qde_leite_com_cafe) +
                                        " - valor cafés vendidos: "+valor_cafes_vendidos);
                    break;
                case 5:
                    // Adicionar novo produto
                    System.out.println("Informe o código do novo produto: ");
                    int novoProduto = sc.nextInt();
                    System.out.println("Informe o preço do novo produto: ");
                    double precoNovoProduto = sc.nextDouble();
                    precos.put(novoProduto, precoNovoProduto);
                    System.out.println("Novo produto adicionado com sucesso!");
                    break;
                case 6:
                    // Excluir produto da lista
                    System.out.println("Informe o código do produto a ser excluído: ");
                    int produtoExcluir = sc.nextInt();
                    if (precos.containsKey(produtoExcluir)) {
                        precos.remove(produtoExcluir);
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado na lista.");
                    }
                    break;
                case 7:
                    // Pagamento parcial da conta
                    System.out.println("Informe o valor do pagamento parcial: ");
                    double pagamentoParcial = sc.nextDouble();
                    if (pagamentoParcial >= valor_cafes_vendidos) {
                        System.out.println("Pagamento parcial aceito. Troco: " + (pagamentoParcial - valor_cafes_vendidos));
                        valor_cafes_vendidos = 0;
                    } else {
                        System.out.println("Valor insuficiente para pagar a conta total.");
                    }
                    break;
                case 8:
                    // Pagamento total da conta
                    if (valor_cafes_vendidos > 0) {
                        System.out.println("Total da conta: " + valor_cafes_vendidos);
                        valor_cafes_vendidos = 0;
                    } else {
                        System.out.println("Não há conta a ser paga.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
      
        } while ( opcao != 9); // O loop continua até que o usuário escolha sair
        sc.close();
        
        // Se houver conta em aberto, impede o encerramento do programa
        if (valor_cafes_vendidos > 0) {
            System.out.println("Conta em aberto. Por favor, realize o pagamento.");
        } else {
            System.out.println("Programa encerrado.");
        }
    }
}
