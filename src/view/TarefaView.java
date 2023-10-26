package view;

import controller.TarefaController;
import exception.DescricaoInvalida;
import exception.EntradaInvalidaException;
import exception.TarefaNaoEncontradaException;
import model.Tarefa;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TarefaView extends Log {

    TarefaController controller;
    final private Scanner leitor = new Scanner(System.in);

    public TarefaView() {
        controller = new TarefaController();
        log("Sistema de tarefas");
        exibirMenu();
    }

    void exibirMenu() {
        int escolha = 0;
        do {
            if (escolha != 0) {
                try {
                    tratarResposta(escolha);
                } catch (EntradaInvalidaException e) {
                    log(e.getMessage());
                }
            }
            log("Selecione uma opção ou 5 para sair:");
            log("1 - Adicionar tarefas");
            log("2 - Concluir tarefas");
            log("3 - Obter tarefas");
            log("4 - Obter tarefas não concluídas");
            escolha = leitor.nextInt();
        } while (escolha != 5);

        log("Finalizando sistema...");
        log("Sistema finalizado com sucesso!");
    }

    void adicionarTarefas() {
        String descricao = "";

        while (true) {
            log("Insira uma descrição para a tarefa(0 para voltar):");
            descricao = new Scanner(System.in).nextLine();

            if (descricao.equals("0")) {
                return;
            }

            try {
                controller.adicionarTarefa(descricao);
                log("-> Tarefa criada com sucesso!!");
            } catch (DescricaoInvalida e) {
                log("Erro ao criar tarefa: " + e.getMessage());
            }

        }
    }

    void concluirTarefas() {
        int numTarefa = 9999;
        do {
            numTarefa = solicitarNumTarefa();

            if (numTarefa == 0) {
                return;
            }

            try {
                controller.concluirTarefa(numTarefa);
                log("-> Tarefa " + numTarefa + " concluida com sucesso!!");
            } catch (TarefaNaoEncontradaException e) {
                log("Erro ao concluir tarefa: " + e.getMessage());
                numTarefa = solicitarNumTarefa();
            }
        } while (!Objects.equals(numTarefa, 0));
    }

    void obterTarefas() {
        List<Tarefa> tarefas = controller.obterTarefas();

        for (Tarefa tarefa : tarefas) {
            logTarefa(tarefa);
        }
    }

    void obterTarefasNaoConcluidas() {
        List<Tarefa> tarefas = controller.obterTarefasNaoConcluidas();

        for (Tarefa tarefa : tarefas) {
            logTarefa(tarefa);
        }
    }

    private void tratarResposta(int input) throws EntradaInvalidaException {
        if (input < 1 || input > 5) {
            throw new EntradaInvalidaException();
        }

        switch (input) {
            case 1 -> adicionarTarefas();
            case 2 -> concluirTarefas();
            case 3 -> obterTarefas();
            case 4 -> obterTarefasNaoConcluidas();
        }
    }

    private String solicitarDescricao() {
        log("Insira uma descrição para a tarefa(0 para voltar):");
        return leitor.nextLine();
    }

    private int solicitarNumTarefa() {
        log("Informe o ID da tarefa(0 para voltar):");
        return leitor.nextInt(); // TODO Validar tarefas com 2 digitos
    }
}
