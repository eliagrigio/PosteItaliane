public class Ticket<T> {
    private T cliente;
    private Long tempoIniziale;
    private TipoServizio tipoServizio;
    private int numeroProgressivo;

    // Contatori statici per mantenere sequenze numeriche separate per ogni servizio
    private static int contatoreP = 1;
    private static int contatoreF = 1;
    private static int contatoreA = 1;

    public Ticket(T cliente, TipoServizio tipoServizio) {
        this.cliente = cliente;
        this.tipoServizio = tipoServizio;
        this.tempoIniziale = System.currentTimeMillis(); // Registra il timestamp della richiesta
        
        // Assegna la sequenza numerica in base al tipo di operazione
        synchronized (Ticket.class) {
            switch (tipoServizio) {
                case P:
                    this.numeroProgressivo = contatoreP++;
                    break;
                case F:
                    this.numeroProgressivo = contatoreF++;
                    break;
                case A:
                    this.numeroProgressivo = contatoreA++;
                    break;
            }
        }
    }

    public T getCliente() {
        return this.cliente;
    }

    public Long getTempoIniziale() {
        return this.tempoIniziale;
    }

    public TipoServizio getTipoServizio() {
        return this.tipoServizio;
    }

    public int getNumeroProgressivo() {
        return this.numeroProgressivo;
    }

    @Override
    public String toString() {
        return "[" + tipoServizio + "-" + numeroProgressivo + "] (Creato alle: " + tempoIniziale + ")";
    }
}