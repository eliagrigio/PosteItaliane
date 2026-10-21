public class Pacco {
    private String nome;
    private int peso;
    private String mittente;
    private String destinatario;

    public Pacco(String nome, int peso, String mittente, String destinatario){
        this.nome = nome; 
        this.peso = peso;
        this.mittente = mittente; 
        this.destinatario = destinatario;
    }
 
 
    public String getNome(){return this.nome;}
    public int getPeso(){return this.peso;} 
    public String getMittente(){return this.mittente;}
    public String getDestinatario(){return this.destinatario;}

    public String toString(){
        String res = this.getNome()+ " " + this.getPeso()+ " " + this.getMittente()+ " " + this.getDestinatario();
        return res;
    }
    
}
