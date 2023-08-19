package Fila_Lista;

//Alunas: Adryellen Alves de Souza e Mariana Oliveira Azevedo
public interface Fila<T> {
    void fazVazia();

    boolean estaVazia();

    T getPrimeiro();

    void enfileirar(T objeto);

    T desenfileirar();
}