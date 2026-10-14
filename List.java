

public class List<T> {
    private ListItem<T> head;
    private ListItem<T> tail;

    // Constructor
    protected List() { 
        this.head = null;
        this.tail = null;
    }

    public ListItem<T> getHead(){
        return this.head;
    }

    public ListItem<T> getTail(){
        return this.tail;
    }
   
   

    // Methods

    /** 
     * Adds a new ListItem to the end of the List
     *
     * @param value value to add
     */
    protected void addTail(T value) {
        if (this.head == null) {
            this.head = new ListItem<T>(value);
            this.tail = this.head;
        } else {
            ListItem<T> newItem = new ListItem<T>(value);

            this.tail.setNext(newItem);
            newItem.setPrev(this.tail);

            this.tail = newItem;
        }
    }

    /**
     * Adds a new ListItem to the beginning of the List
     *
     * @param value value to add
     */
    protected void addHead(T value) {
        if (this.head == null) {
            this.head = new ListItem<T>(value);
            this.tail = this.head;
        } else {
            ListItem<T> newItem = new ListItem<T>(value);

            newItem.setNext(this.head);
            this.head.setPrev(newItem);

            this.head = newItem;
        }
    }

    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * @return the size of the list
     */
    public int size() {
        int size = 0;
        ListItem<T> cur = this.head;

        while (cur != null) {
            size++;
            cur = cur.getNext();
        }

        return size;
    }

    

    /**
     * Removes and returns the first item in the list.
     *
     * @return removed value, or -1 if the list is empty
     */
    protected T removeHead() {
        if (this.head == null) {
            System.out.println("Nulla da rimuovere");
            return null;
        }

        T headValue = this.head.getValue();

        if (this.head.getNext() == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }

        return headValue;
    }

    /**
     * Removes and returns the last item in the list.
     *
     * @return removed value or -1 if the list is empty
     */
    protected T removeTail() {
        if (this.tail == null) {
            System.out.println("Nothing to remove, returning null");
            return null;
        }

        T tailValue = this.tail.getValue();

        if (this.tail.getPrev() == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }

        return tailValue;
    }

    /**
     * Removes the item at index.
     *
     * @param index of the item to remove
     */
    protected T remove(int index) {
        if (this.head == null) {
            System.out.println(
                "Lista vuota" + index + "."
            );
            return null;
        }

        if (index <= 0) {
             return this.removeHead();
            
        }

        ListItem<T> cur = this.head;

        for (int i = 0; i < index && cur.getNext() != null; i++) {
            cur = cur.getNext();
        }

        if (cur == this.tail) {
            return this.removeTail();
            
        }

        ListItem<T> previous = cur.getPrev();
        ListItem<T> next = cur.getNext();

        previous.setNext(next);
        next.setPrev(previous);
        return cur.getValue();
    }
    
    /**
     * Clears the list
     */
    public void clear(){
        if(head == null){
            System.out.println("The list is empty.");
        }else{
            ListItem<T> cur = this.head;
            while(cur != null){
                if(cur.getPrev() != null){
                    cur.setPrev(null);
                }
                if(cur.getNext() != null){
                cur = cur.getNext();
                cur.getPrev().setNext(null);
                }
            }
            System.out.println("the list is clear.");
        }
    }
    

    

    @Override
    public String toString() {
        if (this.head == null) {
            return "vuota";
        }

        String res = "";

        

        ListItem<T> cur = this.head;

        while (cur != null) {
            res += cur.getValue() + ",";
            cur = cur.getNext();
           
        }

        return res;
    }
}