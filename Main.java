
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    Queue<Cliente> q = new Queue<>();
    
        Random rand = new Random();

    Finanziamento f = new Finanziamento(80, "ELIA", "GTA VI");
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
    
    ListItem<Cliente> cur = q.getHead().getNext();
    System.out.println(q.toString());
    while(!q.isEmpty()){

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e1) {
            System.out.println("Problema");
        }
        
        q.dequeue();
        
        System.out.println(q.toString());
    }

    

    

    

    

    
}
}
 