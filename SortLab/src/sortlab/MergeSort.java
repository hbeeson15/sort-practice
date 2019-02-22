package sortlab;

/*
This class contains the merge sort. This is a linked implementation, meaning the data
is put into a linked list and then sorted. This is a recursive method. There is a 
function getMiddle() that returns the middle of list, and merge sort is called again
on each side of that middle. 
 */
import java.util.ArrayList;

//linked implementation
public class MergeSort {

    node head = null;

    MergeSort(ArrayList<Integer> al) {

        for (int i = 0; i < al.size(); i++) {
            this.push(al.get(i));
        }
        this.mergeSort(this.head);
    }

    static class node {

        int value;
        node next;

        public node(int value) {
            this.value = value;
        }
    }

    public node sortedMerge(node a, node b) {
        node result = null;
        //base cases
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        //pick node a or node b and recurse
        if (a.value <= b.value) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public node mergeSort(node h) {
        //base case: if head is null
        if (h == null || h.next == null) {
            return h;
        }

        //get middle of list
        node mid = getMiddle(h);
        node nextOfMid = mid.next;

        //set next of middle to null
        mid.next = null;
        
        //merge sort left list
        node left = mergeSort(h);

        //merge sort right list
        node right = mergeSort(nextOfMid);

        //merge left and right lists
        node sortedList = sortedMerge(h, right);

        return sortedList;
    }

    //function to get middle of linked list
    public node getMiddle(node h) {
        //base case
        if (h == null) {
            return h;
        }
        node fastptr = h.next;
        node slowptr = h;

        //move fastptr by two and slow ptr by one
        //slowptr will point to middle node
        while (fastptr != null) {
            fastptr = fastptr.next;
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        return slowptr;
    }

    //function to add to the beginning of the list
    public void push(int newValue) {
        //allocate space
        node newNode = new node(newValue);
        //link old list to new node
        newNode.next = head;
        //move head to point to new node
        head = newNode;
    }

    //function to print list to console
    public void printList(node head) {
        while (head != null) {
            System.out.println(head.value + " ");
            head = head.next;
        }
    }
}
