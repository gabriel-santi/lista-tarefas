package model;

import exception.DescricaoInvalida;

public class Tarefa {
    final private int id;
    final private String descricao;
    private boolean finalizada;

    public Tarefa(String descricao, int id) throws DescricaoInvalida {
        validarDescricao(descricao);
        this.id = id;
        this.descricao = descricao;
        this.finalizada = false;
    }

    public void setFinalizada() {
        this.finalizada = true;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean estaFinalizada() {
        return finalizada;
    }

    private void validarDescricao(String descricao) throws DescricaoInvalida {
        if(descricao == null || descricao.trim().isEmpty()){
            throw new DescricaoInvalida();
        }
    }
}
