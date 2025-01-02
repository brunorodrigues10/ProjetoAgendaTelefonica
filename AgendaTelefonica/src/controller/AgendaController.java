package controller;

import model.Contato;
import view.AgendaView;

import java.util.ArrayList;
import java.util.Comparator;

public class AgendaController {
    private ArrayList<Contato> contatos;
    private AgendaView view;

    public AgendaController(AgendaView view) {
        this.contatos = new ArrayList<>();
        this.view = view;
    }

    public void adicionarContato() {
        String nome = view.solicitarEntrada("Digite o nome do contato: ");
        String telefone = view.solicitarEntrada("Digite o telefone do contato: ");

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)){
                System.out.println("Erro: Já existe um contato com este nome.");
                return;
            }
            if (contato.getTelefone().equalsIgnoreCase(telefone)) {
                System.out.println("Erro: Número de telefone já cadastrado");
                return;
            }
        }

        //Validação
        if (validarContato(nome, telefone)) {
            contatos.add(new Contato(nome, telefone));
            view.exibirMensagem("Contato adicionado com sucesso!");
        }
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            view.exibirMensagem("A lista de contatos está vazia.");
        } else {
            // Ordena os contatos por nome antes de exibi-los
            contatos.sort(Comparator.comparing(Contato::getNome));

            // Exibe os contatos ordenados
            for (Contato contato : contatos) {
                view.exibirMensagem(contato.toString());
            }
        }
    }

    public void buscarContato() {
        String busca = view.solicitarEntrada("Digite o nome do contato que deseja buscar: ");
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(busca)) {
                view.exibirMensagem("Contato encontrado: " + contato);
                return;
            }
        }
        view.exibirMensagem("Contato não encontrado.");
    }

    public void buscarTelefone() {
        String buscartelefone = view.solicitarEntrada("Digite o telefone que deseja buscar: ");
        for (Contato contato : contatos){
            if (contato.getTelefone().equalsIgnoreCase(buscartelefone)) {
                view.exibirMensagem("Contato encontrado: " + contato);
                return;
            }
        }
        view.exibirMensagem("Contato não encontrado.");
    }

    public void removerContato() {
        String remover = view.solicitarEntrada("Digite o nome do contato que deseja remover: ");
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(remover)) {
                contatos.remove(contato);
                view.exibirMensagem("Contato removido com sucesso!");
                return;
            }
        }
        view.exibirMensagem("Contato não encontrado.");
    }

    private boolean validarContato(String nome, String telefone) {
        if(nome == null || nome.trim().isEmpty()) {
            view.exibirMensagem("Erro: Você precisa informar um nome.");
            return false;
        }
        if (!telefone.matches("\\d+")) {
            view.exibirMensagem("Erro: O telefone deve conter apenas números (ex.: 1234567890)");
            return false;
        }
        return true;
    }
}
