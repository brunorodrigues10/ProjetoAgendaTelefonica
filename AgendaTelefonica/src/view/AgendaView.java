package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AgendaView {
    private Scanner scanner;

    public AgendaView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("\n=== Agenda Telefônica ===");
        System.out.println("1. Adicionar contato");
        System.out.println("2. Listar contatos");
        System.out.println("3. Buscar contato");
        System.out.println("4. Remover contato");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public String solicitarEntrada(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public int solicitarOpcao() {
        int opcao = -1;
        while (true) {
            try{
                System.out.println("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                scanner.nextLine();
            }
        }
        return opcao;
    }
}
