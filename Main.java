
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner scn = new Scanner(System.in);

    Queue<Ticket> j = new Queue<>();
     
    

    Finanziamento f = new Finanziamento(80, "ELIA", "GTA VI");
    
    ListItem<Finanziamento> g = new ListItem<>(f);

    Pacco p = new Pacco("Gioco", 0, "Elia", "Beldea");
    ListItem<Pacco> r = new ListItem<>(p);

    Pagamento a = new Pagamento(60, "Elia", "Bar"); 
    ListItem<Pagamento> b = new ListItem<>(a);

    Cliente c = new Cliente(g);
    Cliente d = new Cliente(r);
    Cliente e = new Cliente(b); 

     
    
Ticket<Cliente> t1 = new Ticket(c);
Ticket<Cliente> t2 = new Ticket(d);
Ticket<Cliente> t3 = new Ticket(e);
    
    j.enqueue(t1);
    j.enqueue(t2);
    j.enqueue(t3);
    
    System.out.println(j.toString());

    
    while(!j.isEmpty()){
        int i = 1;
        long x = 500;
        try {
            Thread.sleep(x);
            x+= t1.getTempoInizile();

        } catch (InterruptedException e1) {
            System.out.println("Problema");
        }
        System.out.println( "Era entrato al momento " + j.getHead().getValue().getTempoInizile());
        j.getHead().getValue().start();
        
        j.dequeue();
        System.out.println("è uscito al momento: " + System.currentTimeMillis());
        i++;
    }

    
    

    Sportello s = new Sportello(j);
    System.out.println(s.getQueue());

    
}
}
 