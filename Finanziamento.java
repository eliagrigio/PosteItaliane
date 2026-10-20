public class Finanziamento {
    private int importo;
    private String richiedente;
    private String motivazione;

    public Finanziamento(int importo, String richiedente, String motivazione) {
        this.importo = importo;
        this.richiedente = richiedente;
        this.motivazione = motivazione;
    }

    public int getImporto() {return this.importo;} 

    public String getRichiedente() {return this.richiedente;}

    public String getMotivazione() {return this.motivazione;}  

    public String toString(){
        String res = this.getImporto() + " " + this.getRichiedente()+ " " + this.getMotivazione();

        return res;
    }
} 