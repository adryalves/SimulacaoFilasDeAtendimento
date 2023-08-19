
//Alunas: Adryellen Alves de Souza e Mariana Oliveira Azevedo
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeituraArquivo {
    // Aqui nos vamos ler o arquivo DadosEntrada que eh onde tem todas as
    // informacoes dos clientes e dos atendimentos

    String[] elementos = {};
    String caminhoArquivo = "DadosEntrada.txt";
    ArrayList<String> lista = new ArrayList<>();
    ArrayList<Integer> listaclientes = new ArrayList<>();
    ArrayList<Integer> listaTempoChegada = new ArrayList<>();
    ArrayList<Integer> listaFilas = new ArrayList<>();
    ArrayList<Integer> listaTemposDeAtendimento = new ArrayList<>();

    public void LerArquivo() {
        try {
            FileReader fr = new FileReader(caminhoArquivo); /// usamos File e Buffer para conseguir ler e armazenar os
                                                            /// elementos do documento
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {

                elementos = linha.split(";"); // aqui separamos como diferentes elementos de acordo com o ponto e
                                              // virgula para podermos separar cada tempo
                for (int i = 0; i < elementos.length; i++) {
                    lista.add(elementos[i]);
                }

            }

            lista.remove(0); // aqui removo o titulo "cliente, tempo atendimento.." pois nao precisamos para
                             // criar o cliente

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }

        for (int i = 0; i <= 32; i += 4) { // aqui estamos pegando e dividindo os elementos do documento nas categorias:
                                           // cliente, fila, tempo de chegada e tempo de atendimento, para podermos
                                           // manipular

            listaclientes.add(Integer.parseInt(lista.get(i).trim()));
            listaTempoChegada.add(Integer.parseInt(lista.get(i + 1).trim()));
            listaFilas.add(Integer.parseInt(lista.get(i + 2).trim()));
            listaTemposDeAtendimento.add(Integer.parseInt(lista.get(i + 3).trim()));

        }

    }

    // metodos para retornar cada lista para que seja possivel acessar essas listas
    // em outras classes
    public ArrayList<Integer> getlistaClientes() {
        return listaclientes;
    }

    public ArrayList<Integer> getlistaTempoChegada() {
        return listaTempoChegada;
    }

    public ArrayList<Integer> getlistaFilas() {
        return listaFilas;
    }

    public ArrayList<Integer> getListaTempoDeAtendimento() {
        return listaTemposDeAtendimento;
    }

}
