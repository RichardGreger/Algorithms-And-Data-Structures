package org.pg4200.ex02;

public class MyQueueArray25<T> {

    private Object[] data;

    public MyQueueArray25(){
        this(10);
    }

    public MyQueueArray25(int capacity){
        data = Object[capacity];
    }

}
