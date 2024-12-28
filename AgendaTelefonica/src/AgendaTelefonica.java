import agenda.Contato;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaTelefonica {
    public static void main(String[] args) {
        ArrayList<Contato> contatos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean executando = true;

        while (executando) {
            System.out.println("\n=== Agenda Telefônica ===");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Buscar contato");
            System.out.println("4. Remover contato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o nome do contato: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o telefone do contato: ");
                String telefone = scanner.nextLine();
                contatos.add(new Contato(nome, telefone));
                System.out.println("Contato adicionado com sucesso!");
            } else if (opcao == 2) {
                if (contatos.isEmpty()) {
                    System.out.println("A lista de contatos está vazia.");
                } else {
                    for (Contato contato : contatos) {
                        System.out.println(contato);
                    }
                }
            } else if (opcao == 3) {
                System.out.print("Digite o nome do contato que deseja buscar: ");
                String busca = scanner.nextLine();
                boolean encontrado = false;
                for (Contato contato : contatos) {
                    if (contato.getNome().equalsIgnoreCase(busca)) {
                        System.out.println("Contato encontrado: " + contato);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Contato não encontrado.");
                }
            } else if (opcao == 4) {
                System.out.print("Digite o nome do contato que deseja remover: ");
                String remover = scanner.nextLine();
                boolean removido = false;
                for (Contato contato : contatos) {
                    if (contato.getNome().equalsIgnoreCase(remover)) {
                        contatos.remove(contato);
                        System.out.println("Contato removido com sucesso!");
                        removido = true;
                        break;
                    }
                }
                if (!removido) {
                    System.out.println("Contato não encontrado.");
                }
            } else if (opcao == 5) {
                System.out.println("Saindo...");
                executando = false;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
