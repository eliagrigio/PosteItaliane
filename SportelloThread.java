import java.util.Random;

public class SportelloThread extends Thread {
    private Queue<Ticket> coda;
    private int idSportello;
    private TipoServizio servizioPrioritario; 
    private boolean esclusivo;
    private Random random = new Random();

    public SportelloThread(int idSportello, Queue<Ticket> coda, TipoServizio servizioPrioritario, boolean esclusivo) {
        this.idSportello = idSportello;
        this.coda = coda;
        this.servizioPrioritario = servizioPrioritario;
        this.esclusivo = esclusivo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Ticket ticket = null;

                // Sincronizziamo sulla coda per evitare conflitti tra i thread sportello
                synchronized (coda) {
                    if (esclusivo && servizioPrioritario != null) {
                        ticket = coda.dequeue(servizioPrioritario);
                    } else if (servizioPrioritario != null) {
                        ticket = coda.dequeue(servizioPrioritario);
                        if (ticket == null && !coda.isEmpty()) {
                            ticket = coda.dequeue();
                        }
                    } else {
                        ticket = coda.dequeue();
                    }
                }

                if (ticket == null) {
                    // Se non ci sono clienti, attende un tempo fisso e riprova
                    Thread.sleep(1000);
                } else {
                    // Simula il tempo di servizio random (es. tra 500ms e 2000ms)
                    int tempoServizio = 500 + random.nextInt(1500);
                    Thread.sleep(tempoServizio);

                    // Calcola il tempo trascorso dall'emissione alla fine del servizio
                    long tempoFine = System.currentTimeMillis();
                    long tempoTrascorso = tempoFine - ticket.getTempoIniziale();

                    System.out.println("[Sportello " + idSportello + "] Servito ticket: " + ticket 
                        + " | Tempo impiegato: " + tempoTrascorso + " ms");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Sportello " + idSportello + " chiuso.");
        }
    }
}