package Fila_Lista;

import Exceptions.ContainerVazioException;

//Alunas: Adryellen Alves de Souza e Mariana Oliveira Azevedo
public class FilaEncadeada<T> implements Fila<T> {
    private ListaEncadeada<T> lista;
    private int count;

    public FilaEncadeada() {

        lista = new ListaEncadeada<T>();

        count = 0;

    }

    public void fazVazia() {

        lista.fazVazia();

        count = 0;

    }

    public boolean estaVazia() {

        return count == 0;

    }

    public T getPrimeiro() {

        if (count == 0)

            throw new ContainerVazioException();

        return lista.getPrimeiro();

    }

    public void enfileirar(T objeto) {

        lista.inserirFim(objeto);

        count++;

    }

    public T desenfileirar() {

        if (count == 0)

            throw new ContainerVazioException();

        T result = lista.getPrimeiro();

        lista.extrair(result);

        --count;

        return result;

    }

    public void imprimir() {
        lista.imprimirLista();
    }
}
