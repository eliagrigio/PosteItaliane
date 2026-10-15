public class Ticket<Cliente> extends Thread {

    private Cliente cliente;


    public Ticket(Cliente c){
        this.cliente = c;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    @Override 
    public void run(){
        System.out.println("Cliente Servito");
    }
   
} 
 