
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Fila_Lista.FilaEncadeada;

//Classe que lemos o arquivo e fazemos o atendimento
public class Execucao {
    public static void main(String[] args) {
        System.out.println("Estamos fazendo a leitura do arquivo DadosEntrada");
        LeituraArquivo LA = new LeituraArquivo();
        LA.LerArquivo(); // para poder ler o arquivo
        ArrayList<Integer> listaClientes = LA.getlistaClientes(); // aqui pegamos cada lista populada
        ArrayList<Integer> listaTempoChegada = LA.getlistaTempoChegada();
        ArrayList<Integer> listaFila = LA.getlistaFilas();
        ArrayList<Integer> listaTempoDeAtendimento = LA.getListaTempoDeAtendimento();

        FilaEncadeada<Cliente> FilaComum = new FilaEncadeada<>();
        FilaEncadeada<Cliente> FilaPrioritaria = new FilaEncadeada<>();

        ArrayList<String> listaClientesAtendido = new ArrayList<>();
        ArrayList<String> tempoTotalAtendimento = new ArrayList<>();

        listaClientesAtendido.add("Cliente: ");
        tempoTotalAtendimento.add("Tempo Total Atendimento: ");

        int tempoTotal = 0;
        int Tempo = 1;
        System.out.println("\nFaremos o atendimento agora\n");

        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = new Cliente(listaClientes.get(i), listaTempoChegada.get(i),
                    listaTempoDeAtendimento.get(i)); // criamos um cliente para cada elemento da lista de cliente
            if (listaFila.get(i) == 1) {
                FilaPrioritaria.enfileirar(cliente);
            } else if (listaFila.get(i) == 2) {
                FilaComum.enfileirar(cliente);
            }

        }
        System.out.println("---------Inicio do Atendimento-------------\n");

        while (!FilaPrioritaria.estaVazia() || !FilaComum.estaVazia()) { // enquanto tiver elemento em algumas das filas

            if (!FilaComum.estaVazia() && (FilaPrioritaria.estaVazia()
                    || FilaComum.getPrimeiro().getTempoChegada() < FilaPrioritaria.getPrimeiro().getTempoChegada())) {

                tempoTotal = (Tempo - FilaComum.getPrimeiro().getTempoChegada()) // o tempo total que um cliente esperou
                        + FilaComum.getPrimeiro().getTempoDeAtendimento();

                Tempo += FilaComum.getPrimeiro().getTempoDeAtendimento(); // valor que representa o tempo em que estamos
                                                                          // e que vai sendo sempre incrementado
                listaClientesAtendido.add(String.valueOf(FilaComum.getPrimeiro().getCliente()));

                tempoTotalAtendimento.add(String.valueOf(tempoTotal));

                System.out
                        .println("Cliente: " + FilaComum.getPrimeiro().getCliente()
                                + " da Fila Normal 2 teve como tempo de chegada: "
                                + FilaComum.getPrimeiro().getTempoChegada() + " e seu atendimento durou "
                                + FilaComum.getPrimeiro().getTempoDeAtendimento()
                                + " minutos mas seu tempo total de atendimento foi: " + tempoTotal);

                FilaComum.desenfileirar();

            } else if (!FilaPrioritaria.estaVazia()) {

                tempoTotal = (Tempo - FilaPrioritaria.getPrimeiro().getTempoChegada())
                        + FilaPrioritaria.getPrimeiro().getTempoDeAtendimento();

                Tempo += FilaPrioritaria.getPrimeiro().getTempoDeAtendimento();

                listaClientesAtendido.add(String.valueOf(FilaPrioritaria.getPrimeiro().getCliente()));

                tempoTotalAtendimento.add(String.valueOf(tempoTotal));

                System.out.println("Cliente: " + FilaPrioritaria.getPrimeiro().getCliente()
                        + " da Fila Prioritaria 1 teve como tempo de chegada: "
                        + FilaPrioritaria.getPrimeiro().getTempoChegada() + " e seu atendimento durou "
                        + FilaPrioritaria.getPrimeiro().getTempoDeAtendimento()
                        + " minutos  mas seu tempo total de atendimento foi: " + tempoTotal);

                FilaPrioritaria.desenfileirar();
            }
        }
        // Agora nos ja realizamos o atendimento de todos e ja temos os dados, vamos
        // apenas escrever esses dados em um arquivo de texo:

        try {

            File arquivo = new File("Resultado.txt");

            // verifica se o arquivo já existe
            if (!arquivo.exists()) {
                arquivo.createNewFile(); // esse arquivo vai ser criado
            }

            FileWriter writer = new FileWriter(arquivo);
            String linha = listaClientesAtendido.get(0) + ";" + tempoTotalAtendimento.get(0) + "\n";
            writer.write(linha);
            for (int i = 1; i < listaClientesAtendido.size(); i++) { // colocamos as duas informações como foi pedido no
                                                                     // arquivo, em cada linha
                linha = "0" + listaClientesAtendido.get(i) + ";" + "0" + tempoTotalAtendimento.get(i) + "\n"; // inseriamos
                                                                                                              // cada
                                                                                                              // elemento(cliente
                                                                                                              // e tempo
                                                                                                              // total)
                                                                                                              // que
                                                                                                              // estaca
                                                                                                              // da um
                                                                                                              // em seu
                                                                                                              // array e
                                                                                                              // tambem
                                                                                                              // inserimos
                                                                                                              // o zero
                                                                                                              // a
                                                                                                              // esquerda
                                                                                                              // antes
                                                                                                              // por
                                                                                                              // questoes
                                                                                                              // de
                                                                                                              // organizacao
                writer.write(linha);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(
                "\n---------Pronto, finalizamos o atendimento, voce pode conferir as informacoes finalizadas no arquivo 'Resultado.txt'-------------");
    }

}
