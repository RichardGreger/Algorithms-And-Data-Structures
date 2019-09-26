package org.pg4200.ex02.sep23;

/**
 * Created by richardgreger on 23-Sep-19.
 *
 * After practicing MyLinkedList for a week,
 * I now feel like trying to write this class
 * without copiying anyting from the solution.
 */

public class MyStackLinkedList23<T>{

    private class StackNode{
        // This is the elements that the list will consist of
        T value;
        StackNode previous;
    }
    /*
        In a stack we need to be able to
        POP, PUSH, and PEEK. Also we want a size method.
        We need a tail, but we don't need to know the head,
        since we can't see anthing but the "top" of the stack.
     */

    private StackNode tail;

    private int size;

    public void push(T value){

        StackNode newNode = new StackNode();
        newNode.value = value;

        if(size == 0) {
            // If the list is empty
            // all we need to do is to
            // add the new tail
            tail = newNode;
            // Forgot that we need return here
            return;
        }

        // If the list consists of more than one element
        // we need to modify the previous link belonging
        // to the tail.
        tail.previous = tail;
        tail = newNode;
        size++;
    }

    public T pop(){

        if(size == 0){
            throw new RuntimeException();
        }
        // We want to return the tail,
        // and remove it from the stack
        T value = tail.value;
        tail = tail.previous;

        size--;
        // I learned that you want to return
        // the popped element when you use pop.
        return value;
    }

    public T peek(){

        if(size == 0){
            throw new RunTimeException();
        }

        return tail.value;
    }
}