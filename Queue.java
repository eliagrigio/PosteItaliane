public class Queue<T> extends List<T> {
    
    public Queue(){
        super();
    }

    public synchronized void enqueue(T c){
        this.addTail(c);
    }

    public synchronized T dequeue(){
        return this.removeHead(); 
    } 

    // Metodo di uscita con parametro: restituisce il primo elemento in coda per il servizio indicato
    public synchronized T dequeue(TipoServizio servizio) {
        if (isEmpty()) {
            return null;
        }

        ListItem<T> cur = getHead();
        while (cur != null) {
            // Eseguiamo il cast del valore contenuto nel ListItem a Ticket
            Object val = cur.getValue();
            if (val instanceof Ticket) {
                Ticket t = (Ticket) val;
                if (t.getTipoServizio() == servizio) {
                    // Rimosso l'elemento specifico dalla lista doppiamente concatenata
                    if (cur == getHead()) {
                        return this.removeHead();
                    } else if (cur == getTail()) {
                        return this.removeTail();
                    } else {
                        ListItem<T> prev = cur.getPrev();
                        ListItem<T> next = cur.getNext();
                        prev.setNext(next);
                        next.setPrev(prev);
                        return cur.getValue();
                    }
                }
            }
            cur = cur.getNext();
        }
        return null; // Nessun ticket trovato per quel servizio specifico
    }
}