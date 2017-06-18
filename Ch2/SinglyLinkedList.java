package Ch2;

/**
 * Created by bukolaayodele on 5/29/17.
 */
public class SinglyLinkedList
{
    public class Node {
        public Node next;
        public int data;

        //creates a node for DLL Data Structure
        public Node(int chara, Node n) {
            data = chara;
            next = n;

        }
    }

    public int size; //number items in this list
    public Node head, tail, first, currentNode, removedNode;
    public int a;

    public SinglyLinkedList()
    {
        size = 1; //creates first Node in the DLL
        a=3;
        first = new Node(a, null);
        head=first;
        tail=first;
        currentNode=first;


    }
    //adding a Node to LL
    public void add (int data)
    {

        Node newtail = new Node(data,null);
        tail.next=newtail;
        tail=newtail;
        size++;

    }

    //prints everything in the list
    public void printList() {
        Node first = head;
        while (first != null)
        {
            System.out.print(first.data + "-->");
            first= first.next;

        }

    }

    //CH 2.4, Write code to partition a linked list around a value x, such that all nodes less than x come
    //before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
    //to be after the elements less than x
    public void partition (Node n, int x)
    {
        SinglyLinkedList newlist= new SinglyLinkedList();
        head=n;
        tail=n;

        //Elements bigger than the pivot element are put at the tail and elements smaller are put at the head.
        //Each time we insert an element, we update either the head or tail.
        while (n != null)
        {
            System.out.println(n.next.data);
            //if the current node is smaller than pivot element (x), add it to the head
            if (n.data<x)
            {
                n.next=head;
                head=n;

            }
            else
            {
                //if the current node is smaller than pivot element (x), add it to the tail
                tail.next=n;
                tail=n;
            }
            n=n.next;

        }
        //
        //tail.next=null;



    }


    //Ch 2.5 function that adds the two numbers and returns the sum as a linked list.
    //(7->1-> 6) + (5-> 9 -> 2)= 2->1->9
    public SinglyLinkedList sumList (SinglyLinkedList x, SinglyLinkedList y, int carry)
    {
        SinglyLinkedList sum = new SinglyLinkedList();
        //recursive solution

        Node p1=x.head;
        Node p2=x.head;
        if (p1 == null && p2 == null && carry == 0)
        {
             return null;
        }

        SinglyLinkedList result= new SinglyLinkedList();
        int value = carry;
        if (p1 != null)
        {
            value += p1.data;
        }

        if (p2 != null)
        {
            value += p1.data;
        }

        // Second digit of number
       // result.data= value % 10;

        //Recurse
        if (p1 != null || p2 != null) {
        }


        return sum;
    }

    //CH 2.6 Implement a function to check if a linked list is a palindrome

    //Random Reverse a LLL
    public Node reverseLL (SinglyLinkedList x)
    {
        Node head=x.head;
        Node newhead=null;
        Node prevhead=null;

        while (head != null)
        {

            newhead=head;
            System.out.println(newhead.data);
            newhead.next=prevhead;
            System.out.println(newhead.next.data);
            prevhead=newhead;


            head= head.next;

        }
        return newhead;
    }

    //LeetCode, You are given two non-empty linked lists representing two non-negative integers.
    //The digits are stored in reverse order and each of their
}
