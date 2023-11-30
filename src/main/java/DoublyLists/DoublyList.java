package DoublyLists;

import java.util.*;
import java.util.function.Consumer;


public class DoublyList<T> implements Iterable<T>{
    private Node head;
    private Node tail;

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    boolean aBoolean = true;

    public T[] array (T[] list){
        T[] result = (T[]) new Object[list.length];
        for (int i =0, j = result.length-1; i<list.length; i++,j--){
            result[j] = list[i];
        }
        return result;
    }
    // добавление значения в начало списка
    public void addArrayList ( T [] variable){
        for (T i : array(variable)){
            addToBeginning(i);
        }
    }

    //Добавление всех значений заданного массива в конец списка с сохранение порядка
    public void addArrayListEnd (T [] variable){
        for (T i : variable){
            addToEnd(i);
        }
    }

    // добавление значения в начало списка
    public void addToBeginning (T variable){
        Node newNode = new Node(variable);
        newNode.date = variable;
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }
    //Извлечение значения из начала списка без его удаления из списка
    public T extractFromBeginning (){
        if (head != null)
            return (T) head.date;
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Извлечение значения из начала списка с удалением из списка
    public T extractAndDeleteFromBeginning () {
        if (head != null && tail.previous != null) {
            T firstDate = (T) head.date;
            head = head.next;
            head.previous = null;
            return (T) firstDate;
        } else if (head != null && head.next == null){
            T firstDate = (T) head.date;
            head = head.next;
            return (T) firstDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Добавление значения в конец списка
    public void addToEnd (T variable){
        Node newNode = new Node(variable);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        Node temp1 = tail;
        while (temp.next != null){
            temp = temp.next;
            temp1 = temp1.previous;
        }
        temp.next =newNode;
        temp1.previous =newNode;
    }

    //Извлечение значения из конца списка без его удаления
    public T extractFromEnd(){
        if (head != null){
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;}
            return (T) temp.date;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    //Извлечение значения из конца списка с удалением
    public T extractAndDeleteFromEnd (){
        if (head != null && tail.previous != null) {
            T firstDate = (T) tail.date;
            tail = tail.previous;
            tail.next = null;
            return (T) firstDate;
        }
        else if(head != null && head.next == null){
            T firstDate = (T) head.date;
            head = head.next;
            return (T) firstDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Определение, содержит ли список заданное значение, или нет
    public boolean checkIfThereIsValue(T variable){
        Node temp = head;
        Boolean result = false;
        if(head == null)
            return false;
        else if (temp.next == null){
            return variable.equals(temp.date);
        }
        else
            while (temp.next != null){
                if(variable.equals(temp.date)){
                    result = true;
                    temp = temp.next;
                }
                else
                    temp = temp.next;
            }
        return  result;
    }

    // Определение, является ли список пустым, или нет
    public boolean checkIfEmpty (){
        if (head == null)
            System.out.println("Список пуст");
        else
            System.out.println("Список не пустой");
        return head == null;

    }

    // Печать всех значений списка в прямом порядке
    // Печать всех значений списка
    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.date);
            temp = temp.next;
        }
    }
    // Печать всех значений списка в обратном порядке
    public void printBack (){
        if (head == null) return;
        Node temp = tail;
        if(temp.previous == null){
            System.out.println(temp.date);
        }else {
            while (temp.previous != null){
                System.out.println(temp.date);
                temp = temp.previous;
                if(temp.previous == null){
                    System.out.println(temp.date);
                }
            }
        }
    }

    //Добавление всех значений заданной коллекции в начало списка с сохранением порядка

    public void addToCollection (Collection<T> collection){
        T[] temp = (T[]) collection.toArray(new Object[0]);
        addArrayList(temp);
    }

    // Добавление всех значений заданной коллекции в конец списка с сохранением порядка
    public void addToEndCollection (Collection<T> collection){
        T[] temp = (T[]) collection.toArray(new Object[0]);
        addArrayListEnd(temp);
    }

    //Возвращающий количество элементов списка.
    public int amount() {
        Node temp = head;
        if (head == null) {
            return 0;
        } else if (temp.next == null) {
            return 1;
        } else {
            int amo = 0;
            while (temp.next != null) {
                temp = temp.next;
                amo++;
                if (temp.next == null) {
                    amo++; }
            }
            return amo;
        }
    }
    //Удаление списка
    public void deleteList() {
        if (head != null) {
            head= null;
            tail = null;  }
    }

    // Поглощение списка другим списком с добавлением значений второго в начало первого списка, после поглощения второй список должен очищаться

    public void mergerListBeginning(DoublyList<T> mergerList){
        if (mergerList.head != null){
            T[] temp = (T[]) new Object[mergerList.amount()];
            Node temp1 = mergerList.head;
            temp[0] = (T) temp1.date;
            int i =1;
            while (temp1.next != mergerList.tail){
                temp[i] = (T) temp1.next.date;
                temp1 = temp1.next;
                i++;
                if (temp1.next == mergerList.tail)
                    temp[temp.length - 1] = (T) mergerList.tail.date;
            }
            addArrayList(temp);
            mergerList.deleteList();
        }
    }

    // Поглощение списка другим списком с добавлением значений второго в конец первого списка, после поглощения второй список должен очищаться

    public void mergerListEnd(DoublyList<T> mergerList){
        if (mergerList.head != null){
            T[] temp = (T[]) new Object[mergerList.amount()];
            Node temp1 = mergerList.tail;
            temp[0] = (T)temp1.date;
            int i =1;
            while (temp1.next != mergerList.tail){
                temp[i] = (T)temp1.next.date;
                temp1 = temp1.next;
                i++;
                if (temp1.next == mergerList.tail)
                    temp[temp.length - 1] = (T)mergerList.tail.date;
            }
            addArrayListEnd(temp);
            mergerList.deleteList();
        }
    }

    public void newForEach (T element, Consumer<? super T> operation){
        Objects.requireNonNull(operation);
        for (T t: this) {
            operation.accept(t);
            if (t.equals(element))
                break;
        }
    }

    public void newForEach (Consumer<? super T> operation, T elements){
        Objects.requireNonNull(operation);
        this.aBoolean(aBoolean);
        boolean b = false;
        for (T t: this) {
            if (t.equals(elements) == b)
                continue;
            b = true;
            operation.accept(t);
        }
    }

    private void aBoolean(boolean aBoolean) {
    }

    public void newForEach (T element, Consumer<? super T> operation, boolean rout){
        Objects.requireNonNull(operation);
        this.setaBoolean(aBoolean);

        for (T t: this) {
            operation.accept(t);
            if(t.equals(element))
                break;
        }
        this.setaBoolean(true);
    }

    public void newForEach (Consumer<? super T> operation, T elements, boolean rout){
        Objects.requireNonNull(operation);
        this.setaBoolean(aBoolean);
        boolean b = false;
        for (T t: this) {
            if (t.equals(elements) == b)
                continue;
            b = true;
            operation.accept(t);
        }
        this.setaBoolean(true);
    }

    @Override
    public Iterator<T> iterator() {
        return aBoolean? new NewIterator<>(head) : new NewReversIterator<>(tail);

    }
    class NewIterator <T> implements Iterator<T>{

        Node tNode;

        public NewIterator(Node tNode) {
            this.tNode = tNode;
        }

        @Override
        public boolean hasNext() {
            return tNode != null;
        }

        @Override
        public T next() {
            if (tNode == null) throw new NoSuchElementException();
            T result = (T) tNode.date;
            tNode = tNode.next;
            return result;
        }
    }

    class NewReversIterator <T> implements Iterator<T>{

        Node pNode;

        public NewReversIterator(Node pNode) {
            this.pNode = pNode;
        }

        @Override
        public boolean hasNext() {
            return pNode != null;
        }

        @Override
        public T next() {
            if (pNode == null) throw new NoSuchElementException();
            T result = (T) pNode.date;
            pNode = pNode.previous;
            return result;
        }
    }

    private class Node <T> {
        T date;
        Node next;
        Node previous;

        Node(T variable){
            date = variable;
        }

    }
}