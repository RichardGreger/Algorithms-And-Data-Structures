package org.pg4200.ex02;


public class MyQueueArray23<T>{

    protected Object[] data;

    private int head = -1;
    private int tail = -1;

    public MyQueueArray23(){
        this(10);
    }

    public MyQueueArray23(int capacity){
        data = new Object[capacity];
    }

    /**
     * Insert a new element at the tail of the queue/line
     */
    public void enqueue(T value){

        if(size() == data.length){

        }

    }

    /**
     *  Remove and return the element at the head of the queue/line
     */
    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException();
        }

        T value = data[head];
        if(size() == 1){
            head = -1;
            tail = -1;
        }
        else{
            head++;
        }
        return value;
    }

    /**
     * Look at the head of the queue/line, without removing it
     */
    public T peak(){
        if(isEmpty()){
            throw new RunTimeException();
        }

        return (T) data[head];
    }

    public int size(){
        return (tail - head) - 1;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}