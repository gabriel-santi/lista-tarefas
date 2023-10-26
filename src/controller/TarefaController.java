package controller;

import exception.DescricaoInvalida;
import exception.TarefaNaoEncontradaException;
import model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaController {
    List<Tarefa> listaTarefas;

    void adicionarTarefa(String descricao) throws DescricaoInvalida {
        listaTarefas.add(new Tarefa(descricao, listaTarefas.size()));
    }

    Tarefa obterTarefa(int id) throws TarefaNaoEncontradaException {
        for(Tarefa tarefa : listaTarefas){
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        throw new TarefaNaoEncontradaException();
    }

    List<Tarefa> obterTarefasNaoConcluidas(){
        List<Tarefa> tarefasNaoConcluidas = new ArrayList<>();

        for(Tarefa tarefa : listaTarefas){
            if (tarefa.estaFinalizada()) {
                tarefasNaoConcluidas.add(tarefa);
            }
        }

        return tarefasNaoConcluidas;
    }

    List<Tarefa> obterTarefas(){
        return listaTarefas;
    }

    void concluirTarefa(int id) throws TarefaNaoEncontradaException {
        for(Tarefa tarefa : listaTarefas){
            if (tarefa.getId() == id) {
                tarefa.setFinalizada();
                return;
            }
        }

        throw new TarefaNaoEncontradaException();
    }
}
