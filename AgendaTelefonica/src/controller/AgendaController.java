package controller;

import model.Contato;
import view.AgendaView;

import java.util.ArrayList;

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
        contatos.add(new Contato(nome, telefone));
        view.exibirMensagem("Contato adicionado com sucesso!");
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            view.exibirMensagem("A lista de contatos está vazia.");
        } else {
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
}
