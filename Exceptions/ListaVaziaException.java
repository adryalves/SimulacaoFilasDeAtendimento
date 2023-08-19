package Exceptions;
//Alunas: Adryellen Alves de Souza e Mariana Oliveira Azevedo

public class ListaVaziaException extends RuntimeException {
    public ListaVaziaException() {
        super("Erro, Lista vazia!");
    }
}
