package Fila_Lista;

import javax.lang.model.element.Element;

import Exceptions.ListaVaziaException;
import Exceptions.ObjetoNaoEncontradoException;

public class ListaEncadeada<T> {
    private Element<T> head; // define a avriavel do tipo elemento head, que é a cabeça da lista
    private Element<T> tail; // define a avriavel do tipo elemento tail, que é a cauda da lista

    public ListaEncadeada() { // Construtor da lista encadeada mas não recebe parametro
    }

    public void fazVazia() { // esvazia nossa lista
        head = null;
        tail = null;
    }

    public Element getHead() { // retorna o elemento head da lista
        return head;
    }

    public Element getTail() { // retorna o elemento tail da lista
        return tail;
    }

    public boolean estaVazia() { // retorna true se a lista estiver vazia
        return (head == null);
    }

    public T getPrimeiro() { // retorna o primeiro elemento da nossa lista

        if (head == null)

            throw new ListaVaziaException();

        return head.data;

    }

    public T getUltimo() { // retorna o ultimo elemento da nossa lista

        if (tail == null)

            throw new ListaVaziaException();

        return tail.data;

    }

    public void inserirInicio(T item) { // insere um novo elemento recebido como parametro no inicio da lista
        Element<T> temp = new Element<T>(item, head);

        if (head == null)
            tail = temp;

        head = temp;
    }

    public void inserirFim(T item) { // insere um novo elemento recebido como parametro no fim da lista
        Element<T> temp = new Element<T>(item, null);

        if (head == null)
            head = temp;

        else {
            tail.next = temp;
        }

        tail = temp;
    }

    public void atribuir(ListaEncadeada<T> l) {
        // a lista que chama o metodo recebe os elementos da lista passada como
        // parametro

        if (l != this) {
            this.fazVazia();

            for (Element<T> ptr = l.head; ptr != null; ptr = ptr.next) {
                this.inserirFim(ptr.data);
            }
        }
    }

    public void imprimirLista() { // Nao vi esse metodo no slide, mas como parecia interessante conseguir iterar
                                  // pela lista e imprimir os seus elementos eu coloquei aqui
        Element<T> ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data); //
            ptr = ptr.next; //
        }
    }

    public void extrair(T item) { // retira o elemento recebido da lista

        Element<T> ptr = head;
        Element<T> prevPtr = null;

        while (ptr != null && ptr.data != item) {
            prevPtr = ptr;
            ptr = ptr.next;
        }

        if (ptr == null)
            throw new ObjetoNaoEncontradoException();

        if (ptr == head)
            head = ptr.next;

        else {
            prevPtr.next = ptr.next;
        }

        if (ptr == tail)
            tail = prevPtr;
    }

    public final class Element<T> {
        T data;
        Element next;

        Element(T d, Element<T> n) {
            data = d;
            next = n;
        }

        public T getData() { // vai retorna o dado daquele elemento
            return data;
        }

        public Element<T> getNext() { // retorna o proximo elemento do elemento
            return next;
        }

        public void inserirDepois(T item) { // insere um elemento depois de algum elemento
            next = new Element<T>(item, next);

            if (tail == this)
                tail = next;
        }

        public void inserirAntes(T item) { // insere um elemento antes de algum elemento
            Element temp = new Element(item, this);

            if (this == head)
                head = temp;

            else {
                Element prevPtr = head;

                while (prevPtr != null && prevPtr.next != this) {
                    prevPtr = prevPtr.next;
                }

                prevPtr.next = temp;
            }
        }
    }
}
