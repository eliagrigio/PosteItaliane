import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

    Queue<Ticket> j = new Queue<>();
     
    while (true) {
        System.out.println("MENU");
        System.out.println("1. Spedisci pacco");
        System.out.println("2. Fai Finanziamento");
        System.out.println("3. Fai pagamento");

        System.out.println();

        System.out.println("Cosa si vuole fare?");

        int scelta = scn.nextInt();

        switch (scelta) {
            case 1:
                System.out.println("Crea Pacco: ");
                System.out.println("inserisci il nome del pacco");
                String nome = scn.next();
                System.out.println("inserisci il peso del pacco");
                int peso = scn.nextInt();
                System.out.println("inserisci il mittente del pacco");
                String mittente = scn.next();
                System.out.println("inserisci il destinatario del pacco");
                String destinatario = scn.next();

                Pacco p = new Pacco(nome, peso, mittente, destinatario);
                
                Ticket<Pacco> tp = new Ticket(p);

               
                
                j.enqueue(tp);

                System.out.println(j.toString()) ;
                
                break;
            

            
            case 2:
                System.out.println("Finanziamento");
                System.out.println("inserisci importo");
                int importo = scn.nextInt();
                System.out.println("inserisci mittente");
                String m =scn.next();
                System.out.println("inserisci destinatario");
                String d = scn.next();

                Finanziamento f = new Finanziamento(importo, d, m);

            default:
                break;
        }

    }
    }
}
