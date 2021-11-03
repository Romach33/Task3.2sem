package com.dmitry.datastructs;

public class Queue<T> extends MyLinkedList<T>{
    public Queue() {
        super();
    }
    
    public T popElement() {
        MyNode<T> toReturn = super.getHead(); 
        remove(0);
        return toReturn.value;
    }
    
    public void insert(T insertable) {
        super.addLast(insertable);
    }
    
    public void bubbleSort() {
        int size = super.getCount();
        for (int i = 0; i < size; i++) {
            T tmp = popElement();
            int intTmp = (Integer) tmp;
            for (int j = 0; j < size - 1; j++) {
                T current = popElement();
                int intCurr = (Integer) current;
                if(intCurr < intTmp) {
                    insert(current);
                } else {
                    insert(tmp);
                    tmp = current;
                    intTmp = intCurr;
                }
            }
            insert(tmp);
        }
    }
    
    @Override
    public String toString() {
        return super.toString();
    } 
    
}
