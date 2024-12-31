import controller.AgendaController;
import view.AgendaView;

public class AgendaTelefonica {
    public static void main(String[] args) {
        AgendaView view = new AgendaView();
        AgendaController controller = new AgendaController(view);

        boolean executando = true;

        while (executando) {
            view.exibirMenu();
            int opcao = view.solicitarOpcao();

            switch (opcao) {
                case 1 -> controller.adicionarContato();
                case 2 -> controller.listarContatos();
                case 3 -> controller.buscarContato();
                case 4 -> controller.removerContato();
                case 5 -> {
                    view.exibirMensagem("Saindo...");
                    executando = false;
                }
                default -> view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
    }
}

