package org.pg4200.ex02.sep25;

public class MyStackLinkedList25<T> {

    private class StackNode{
        StackNode previous;
        T value;
    }

    private StackNode tail;

    private int size;

    public T peek(){
        if(tail == null){
            throw new RuntimeException();
        }
        else{
            return tail.value;
        }
    }

    public void push(T value){

        StackNode node = new StackNode();
        node.value = value;

        if(size == 0){
            tail = node;
        }
        else{
            node.previous = tail;
            node = tail;
        }
        size++;
    }

    public T pop(){
        if(size == 0){
            throw new RuntimeException();
        }
        else{
            StackNode popped = tail;
            tail = tail.previous;
            return popped.value;
        }
        size--;
    }

}
