package CH3;

/**
 * Created by bukolaayodele on 5/24/17.
 * Implement a CH3.Stack, LIFO (the last item in is the first item out)
 */
public class Stack
{

    public class Node {
        public Node next;
        public int data;

        //creates a node for DLL Data Structure
        public Node(int data)
        {
            this.data = data;
        }
    }

    private Node top;


    //get the top of the stack
    public int peek ()
    {
        return top.data;

    }

    //add item to stack
    public void push (int n)
    {
        Node newItem= new Node (n);
        top.next=newItem;
        top=newItem;

        //create a variable that keeps track of minimum

    }

    //remove item from the stack
    public int pop ()
    {
        int data=top.data;
        top=top.next;

        return data;

    }

    //CH 3.5, Write a program to sort a stack such that the smallest items are on the top. You can use
    //an additional temporary stack, but you may not copy the elements into any other data structure
    public void sortStack ()
    {

    }


}
