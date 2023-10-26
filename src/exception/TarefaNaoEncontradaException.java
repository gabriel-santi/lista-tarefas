package exception;

public class TarefaNaoEncontradaException extends Exception{
    public TarefaNaoEncontradaException() {
        super("Nenhuma tarefa registrada com esse id");
    }
}
