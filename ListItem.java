

public class ListItem<T> {
    private T value;
    private ListItem<T> next;  
    private ListItem<T> prev;


    

    public ListItem(T value){  
        this.value = value;
        this.next = null; // non obbligatorio
    }

    public T getValue() {
        return this.value; 
    }

    public void setNext(ListItem<T> next){
        this.next = next;
    }

    public ListItem<T> getNext(){
        return this.next;
    }

    public ListItem<T> getPrev(){
        return this.prev;
    }

    public void setPrev(ListItem<T> Prev){
        this.prev = Prev;
    }

    public String toString(){
        String res = "" +this.getValue();

        return res;
    }
}