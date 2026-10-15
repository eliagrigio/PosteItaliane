public class Ticket<Cliente> extends Thread {

    private Cliente cliente;
    private Long TempoIniziale;


    public Ticket(Cliente c){
        this.cliente = c;
        this.TempoIniziale = System.currentTimeMillis();
    }

    public Cliente getCliente(){
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
 