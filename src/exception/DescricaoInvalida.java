package exception;

public class DescricaoInvalida extends Exception{
    public DescricaoInvalida() {
        super("Descrição não pode vazia");
    }
}
