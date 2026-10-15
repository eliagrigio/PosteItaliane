
import java.util.Random;

import javax.sound.sampled.SourceDataLine;

public class Main {
    public static void main(String[] args) {
    Queue<Cliente> q = new Queue<>();
    Queue<Ticket> j = new Queue<>();
    
        Random rand = new Random();

    Finanziamento f = new Finanziamento(80, "ELIA", "GTA VI");
    long time1 = System.currentTimeMillis();
    ListItem<Finanziamento> g = new ListItem<>(f);

    Pacco p = new Pacco("Gioco", 0, "Elia", "Beldea");
    ListItem<Pacco> r = new ListItem<>(p);

    Pagamento a = new Pagamento(60, "Elia", "Bar"); 
    ListItem<Pagamento> b = new ListItem<>(a);

    Cliente c = new Cliente(g);
    Cliente d = new Cliente(r);
    Cliente e = new Cliente(b);

    q.enqueue(c);
    q.enqueue(d);
    q.enqueue(e);
    
Ticket<Cliente> t1 = new Ticket(c);
    
    j.enqueue(t1);
    

    System.out.println(j.toString());
    while(!j.isEmpty()){
        int x = 500;
        try {
            Thread.sleep(x);
            time1 += x;

        } catch (InterruptedException e1) {
            System.out.println("Problema");
        }
        j.getHead().getValue().start();
        System.out.println(j.toString()) ;
        j.dequeue();
        System.out.println(j.toString()) ;
        System.out.println("Evaso il numero 1 " + (time1-x));
        System.out.println("Evaso il numero 1 " + time1);
        
    }

    
    

    

    
}
}
 