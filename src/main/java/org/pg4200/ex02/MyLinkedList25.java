package org.pg4200.ex02;

public class MyLinkedList25<T> {

    private class ListNode{
        ListNode next;
        T value;
    }

    private ListNode head;
    private ListNode tail;

    private int size;

    public void delete(int index){

        // IOB
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException()
        }

        if(index == 0){
            if(head.next != null){
                head = head.next;
            }
            else{
                head = null;
                tail = null;
            }
        }
        else{
            ListNode current = head;
            int counter = 0;

            while(counter < index - 1){
                current = current.next;
                counter++;
            }
            if(current.next == tail){
                tail = current;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void add(int index, T value){

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        ListNode node = new ListNode();
        node.value = value;

        if(head == null){
            head = tail = node;
        }
        else if(index == 0){
            head.next = head;
            head = node;
        }
        else if(index == size){
            tail.next = node;
            tail = node;
        }
        else{
            ListNode current = head;
            int counter = 0;

            while(counter != index - 1){
                current = current.next;
                counter++;
            }
            node.next = current.next;
            current.next = node;
        }
        size++;
    }

    public T get(int index){
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            return head.value;
        }
        else if(index == size - 1){
            return tail.value;
        }
        else{
            ListNode current = head;
            int counter = 0;

            while(counter != index - 1){
                current = current.next;
                counter++;
            }
            return current.value;
        }
    }
}
