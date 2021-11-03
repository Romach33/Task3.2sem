package com.dmitry.datastructs;

class MyLinkedList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public MyNode<T> getHead() {
        return head;
    }
    public MyNode<T> getTail() {
        return tail;
    }

    @Override
    public MyLinkedList<T> clone() {
        MyLinkedList<T> newLL = new MyLinkedList<>();
        MyNode<T> curr = head;
        for (int i = 0; i < size; i++) {
            newLL.addLast(curr.value);
            if(i!=size-1) {
                curr = curr.next;
            }
        }
        return newLL;
    }

    boolean addLast(T value) {
        MyNode<T> newNode = new MyNode<>();
        newNode.value = value;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            MyNode<T> last = tail;
            last.next = newNode;
            tail = newNode;
        }

        this.size++;
        return true;
    }

    public boolean addFirst(T value) {
        MyNode<T> newNode = new MyNode<>();
        newNode.value = value;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            MyNode<T> first = head;
            newNode.next = first;
            head = newNode;
        }

        this.size++;
        return true;
    }

    public MyNode<T> get(int index) {
        MyNode<T> current = head;

        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }

        return current;
    }

    public T getValue(int index) {
        MyNode<T> current = head;

        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }

        return current.value;
    }

    public boolean remove(int index) {
        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }

        if (index == size - 1) {
            MyNode<T> penultimateElement = get(index - 1);
            penultimateElement.next = null;
            size--;
            return true;
        }

        MyNode<T> penultimateElement = get(index - 1);
        MyNode<T> nextExistingElement = penultimateElement.next.next;
        penultimateElement.next = nextExistingElement;

        size--;
        return true;
    }

    public int getCount() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            MyNode<T> current = get(i);

            if (current.value == value) {
                return true;
            }
        }

        return false;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        MyNode<T> current = head;

        while (current != null) {
            result.append(current.value).append("  ");
            current = current.next;
        }

        return result.toString();
    }

    class MyNode<T> {
        public T value;
        private MyNode<T> next;

        public MyNode(T value, MyNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public MyNode() {
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "value=" + value +
                    ", next=" + (next == null ? " " : next.value) +
                    '}';
        }


    }


}
