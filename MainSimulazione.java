public class MainSimulazione {
    public static void main(String[] args) throws InterruptedException {
        Queue<Ticket> codaPosta = new Queue<>();

        // Avvia il thread produttore di biglietti
        ProduttoreThread produttore = new ProduttoreThread(codaPosta);
        produttore.start();

        System.out.println("--- FASE 1: Simulatore con UN SOLO thread sportello ---");
        SportelloThread sportelloSingolo = new SportelloThread(1, codaPosta, null, false);
        sportelloSingolo.start();

        // Lascia girare la fase 1 per 5 secondi
        Thread.sleep(5000);

        System.out.println("\n--- FASE 2: Simulatore con PIÙ thread (Priorità ed Esclusività) ---");
        // Interrompiamo lo sportello singolo per passare a un multi-sportello
        sportelloSingolo.interrupt();

        // Creiamo più sportelli con comportamenti differenti:
        // - Sportello 2: Priorità sui Finanziamenti (F)
        // - Sportello 3: Esclusivo per Spedizione Pacchi (P)
        // - Sportello 4: Sportello standard (senza preferenze)
        SportelloThread sportelloFinanziari = new SportelloThread(2, codaPosta, TipoServizio.F, false);
        SportelloThread sportelloPacchiEsclusivo = new SportelloThread(3, codaPosta, TipoServizio.P, true);
        SportelloThread sportelloStandard = new SportelloThread(4, codaPosta, null, false);

        sportelloFinanziari.start();
        sportelloPacchiEsclusivo.start();
        sportelloStandard.start();
    }
}