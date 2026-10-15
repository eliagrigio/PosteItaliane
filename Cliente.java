public class Cliente {
    private ListItem tipo;

    public Cliente(ListItem tipo){
        this.tipo = tipo;
    }

    public ListItem getTipo(){
        return this.tipo;
    } 

    public String toString(){
        String res = this.tipo.toString();
        return res;
    }

    public void setTipo(ListItem tipo){
        this.tipo = tipo;
    } 

}
