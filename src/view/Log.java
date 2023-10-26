package view;

import model.Tarefa;

public abstract class Log {
    void log(String mensagem) {
        System.out.println(mensagem);
    }

    void logTarefa(Tarefa t) {
        System.out.println("\nId: " + t.getId());
        System.out.println("Descrição: " + t.getDescricao());
        System.out.println("Status: " + (t.estaFinalizada() ? "[ X ]" : "[ ]") + "\n");
    }
}
