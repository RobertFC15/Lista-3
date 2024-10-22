/*Robert Franklin C. Coelho
 * Desenvolvimento de Aplicações
 * Turma C
 */

import java.util.Scanner;

public class Atividade2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] cadastro = new String[100][3]; 
        int count = 0;

        while (true) {
            System.out.println("1. Inserir pessoa");
            System.out.println("2. Alterar dados da pessoa");
            System.out.println("3. Consultar dados da pessoa");
            System.out.println("4. Excluir dados da pessoa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1: 
                    if (count < 100) {
                        System.out.print("ID da pessoa: ");
                        cadastro[count][0] = scanner.nextLine();
                        System.out.print("Nome da pessoa: ");
                        cadastro[count][1] = scanner.nextLine();
                        System.out.print("Data de nascimento da pessoa (dd/mm/aaaa): ");
                        cadastro[count][2] = scanner.nextLine();
                        count++;
                    } else {
                        System.out.println("Cadastro cheio!");
                    }
                    break;

                case 2: 
                    System.out.print("Digite o ID da pessoa a ser alterada: ");
                    String idAlterar = scanner.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < count; i++) {
                        if (cadastro[i][0].equals(idAlterar)) {
                            System.out.print("Novo nome: ");
                            cadastro[i][1] = scanner.nextLine();
                            System.out.print("Nova data de nascimento (dd/mm/aaaa): ");
                            cadastro[i][2] = scanner.nextLine();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("ID não encontrado.");
                    }
                    break;

                case 3: 
                    System.out.print("Digite o ID da pessoa a ser consultada: ");
                    String idConsultar = scanner.nextLine();
                    encontrado = false;

                    for (int i = 0; i < count; i++) {
                        if (cadastro[i][0].equals(idConsultar)) {
                            System.out.println("ID: " + cadastro[i][0]);
                            System.out.println("Nome: " + cadastro[i][1]);
                            System.out.println("Data de Nascimento: " + cadastro[i][2]);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("ID não encontrado.");
                    }
                    break;

                case 4: 
                    System.out.print("Digite o ID da pessoa a ser excluída: ");
                    String idExcluir = scanner.nextLine();
                    encontrado = false;

                    for (int i = 0; i < count; i++) {
                        if (cadastro[i][0].equals(idExcluir)) {
                            for (int j = i; j < count - 1; j++) {
                                cadastro[j] = cadastro[j + 1];
                            }
                            cadastro[count - 1] = null; 
                            count--;
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("ID não encontrado.");
                    }
                    break;

                case 5: 
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
