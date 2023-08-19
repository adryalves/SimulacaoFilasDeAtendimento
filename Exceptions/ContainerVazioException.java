package Exceptions;

public class ContainerVazioException extends RuntimeException {
    public ContainerVazioException() {
        super("Erro, Fila vazia");
    }
}
