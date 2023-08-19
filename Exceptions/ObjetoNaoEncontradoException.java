package Exceptions;
//Alunas: Adryellen Alves de Souza e Mariana Oliveira Azevedo

public class ObjetoNaoEncontradoException extends RuntimeException {
    public ObjetoNaoEncontradoException() {
        super("ERRO! Valor não encontrado");
    }
}
