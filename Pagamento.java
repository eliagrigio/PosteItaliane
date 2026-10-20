public class Pagamento {
    private int valore;
    private String mittente;
    private String destinatario;

    public Pagamento(int valore, String mittente, String destinatatrio){
        this.valore = valore;
        this.mittente = mittente;
        this.destinatario = destinatatrio;
    }

    public int getValore(){return this.valore;}
    public String getmMittente(){return this.mittente;} 
    public String getDestinatario(){return this.destinatario;}   
    public String toString(){
        String res = this.getValore()+ " " + this.getmMittente()+ " " + this.getDestinatario();

        return res;
    }

}
