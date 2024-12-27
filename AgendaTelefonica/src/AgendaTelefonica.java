import agenda.Contato;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaTelefonica {
    public static void main(String[] args) {
        ArrayList<Contato> contatos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Agenda Telefônica ===");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Buscar contato");
            System.out.println("4. Remover contato");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do seu contato: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o número do contato: ");
                    String telefone = scanner.nextLine();
                    contatos.add(new Contato(nome, telefone));
                    System.out.println("Seu contato foi cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de contados: ");
                    if (contatos.isEmpty()) {
                        System.out.println("A lista está vazia");
                    } else {
                        for (Contato contato : contatos) {
                            System.out.println(contato);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o nome do contato de deseja buscar: ");
                    String buscar = scanner.nextLine();
                    boolean encontrado = false;
                    for (Contato contato : contatos) {
                        if (contato.getNome().equalsIgnoreCase(buscar)) {
                            System.out.println("Contato encontrado: " + contato);
                            encontrado = true;
                            break;
                        }
                    }

                case 4:
                    System.out.println("Digite o nome do contato que deseja remover: ");
                    String remover = scanner.nextLine();
                    encontrado = false;
                    for (Contato contato : contatos) {
                        if (contato.getNome().equalsIgnoreCase(remover)) {
                            contatos.remove(contato);
                            System.out.println("Contato removido com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }
                case 5:
                    System.out.println("Saindo....");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while (opcao != 5);

        scanner.close();
    }
}
