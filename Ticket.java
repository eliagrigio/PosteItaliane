public class Ticket<T> extends Thread {

    private T cliente;
    private Long TempoIniziale;


    public Ticket(T c){
        this.cliente = c;
        this.TempoIniziale = System.currentTimeMillis();
    }

    public T getCliente(){
        return this.cliente;
    }

    public Long getTempoInizile(){
        return this.TempoIniziale;
    }

    @Override 
    public void run(){
        System.out.println("Cliente Servito"); 
    }
   
} 
 