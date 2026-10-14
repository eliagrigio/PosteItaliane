

public class Queue<T> extends List<T>{
    
    public Queue(){
        super();
    }

    public void enqueue(T c){
        this.addTail(c);
    }

    public T dequeue(){
        return  this.removeHead();
    }

    
}
 


