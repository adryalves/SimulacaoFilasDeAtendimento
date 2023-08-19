public class Cliente {
    private int cliente;
    private int TempoChegada;

    private int TempoDeAtendimento;

    public Cliente(int cliente, int tempoChegada, int tempoDeAtendimento) {
        this.cliente = cliente;
        TempoChegada = tempoChegada;
        TempoDeAtendimento = tempoDeAtendimento;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getTempoChegada() {
        return TempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        TempoChegada = tempoChegada;
    }

    public int getTempoDeAtendimento() {
        return TempoDeAtendimento;
    }

    public void setTempoDeAtendimento(int tempoDeAtendimento) {
        TempoDeAtendimento = tempoDeAtendimento;
    }

}
