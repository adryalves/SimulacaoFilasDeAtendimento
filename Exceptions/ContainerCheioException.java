package Exceptions;

public class ContainerCheioException extends RuntimeException {
    public ContainerCheioException() {
        super("Erro, fila sem espaço! ");
    }

}
