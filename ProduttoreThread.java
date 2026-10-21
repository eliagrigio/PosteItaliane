import java.util.Random;

public class ProduttoreThread extends Thread {
    private Queue<Ticket> coda;
    private Random random = new Random();

    public ProduttoreThread(Queue<Ticket> coda) {
        this.coda = coda;
    }

    @Override
    public void run() {
        try {
            int clienteId = 1;
            while (true) {
                // Sceglie casualmente il tipo di operazione (P, F o A)
                TipoServizio[] tipi = TipoServizio.values();
                TipoServizio scelto = tipi[random.nextInt(tipi.length)];

                Cliente c = new Cliente(null); 
                Ticket<Cliente> nuovoTicket = new Ticket<>(c, scelto);

                synchronized (coda) {
                    coda.enqueue(nuovoTicket);
                    System.out.println("[PRODUTTORE] Emesso nuovo ticket: " + nuovoTicket);
                }

                // Attende un intervallo casuale prima di generare un altro cliente
                Thread.sleep(800 + random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.out.println("Produttore interrotto.");
        }
    }
}