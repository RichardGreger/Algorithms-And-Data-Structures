package org.pg4200.ex02.sep23;

/**
 * Created by richardgreger on 23-Sep-19.
 */

public class MyLinkedList23<T> {

    /*
        For each "value" in the container, we create a Node object to contain it.
        Each node object will have a pointer to the next one in the list, apart
        from the last one (which will have "null")
     */
    private class ListNode{
        T value;
        ListNode next;
    }

    // The first element in the list
    private ListNode head;

    // The last element in the list
    private ListNode tail;

    // Total number of elements contained in this container
    private int size;

    public void delete(int index){

        // Index Out Of Bounds both over and under
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }


        if(index == 0){
            // Delete index 0
            if(head.next != null) {
                // The new head
                head = head.next;
            }
            else {
                // Delete where there is just one ListNode
                head = null;
                tail = null;
            }
        }
        else{
            // Delete ListNode in the middle

            ListNode current = head;
            int counter = 0;
            // This should stop one ListNode before, so that I can edit the link A.next so it points to C
            while(counter < index - 1){
                current = current.next;
                counter++;
            }

            if(current.next == tail){
                // Delete and update tail
                tail = current;
            }
            else{
                // May seem strange, but we edit links so that
                // A -> B -> C link becomes A -> C after deletion
                current.next = current.next.next;
            }
        }
        // size is decremented in all cases except when we exit with an IndexOutOfBoundsException
        size--;
    }

    public T get(int index){

        if(index < 0 || index >= size){
            // Index Out Of Bounds at index = size and under size
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            // Return the first element
            return head.value;
        }
        else if(index == size - 1){
            // return tail
            return tail.value;
        }
        else {
            // return an element in the middle
            ListNode target = head;
            int counter = 0;

            while(counter < size - 1){
                if(index == counter){
                    // When index and counter are the same,
                    // we have found our target
                    return target.value;
                }
                // Go to the next element
                target = target.next;
                counter++;
            }
        }

        /*
            We should never reach this code, unless bug.
            But we still need to return null, otherwise the
            compiler complains
          */
        assert false;
        return null;
    }

    public void add(int index, T value){

        if(index < 0 || index > size){
            // Index Out Of Bounds. Remember that it's possible
            // to add a ListNode to index at size
            throw new IndexOutOfBoundsException();
        }

        ListNode newNode = new ListNode();
        newNode.value = value;

        // Add to an empty List
        if(head == null){
            head = newNode;
            tail = newNode;
        }

        // Add an new head
        else if (index == 0) {
            head.next = head;
            head = newNode;
        }
        else if(index == size){
            tail.next = newNode;
            tail = newNode;
        }

        // Add anywhere else
        else {
            ListNode current = head;
            int counter = 0;

            // Same as with delete. I want the ListNode before the target so I can edit the link
            while (counter < size - 1) {
                current = current.next;
                counter++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        // size is incremented in all cases except when we exit with an IndexOutOfBoundsException
        size++;
    }

    public int size(){
        return size;
    }
}

