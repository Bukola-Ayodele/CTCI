package Ch2;

import java.util.HashSet;

/**
 * Created by bukolaayodele on 5/22/17.
 * CH 2 Questions
 */
public class LinkedList
{
    public class Node {
        public Node next,previous;
        public char character;

        //creates a node for DLL Data Structure
        public Node(Node p,char chara, Node n) {
            character = chara;
            next = n;
            previous=p;
        }
    }

    public int size; //number items in this list
    public Node head, tail, first, currentNode, removedNode;
    public char a;

    public LinkedList()
    {
        size = 1; //creates first Node in the DLL
        a='c';
        first = new Node(null, a, null);
        head=first;
        tail=first;
        currentNode=first;


    }
    //adding a Node to LL
    public void add (char charac)
    {

        Node newtail = new Node(tail,charac,null);
        tail.next=newtail;
        tail=newtail;
        size++;

    }

    //removing current Node to LL [NOT Perfect]
    public void remove (Node a)
    {
        currentNode=a;
        currentNode.next.previous=currentNode.previous;
        currentNode.previous.next=currentNode.next;

    }


    //prints everything in the list
    public void printList()
    {
        Node firstChar = head;
        while (firstChar != null)
        {
            System.out.print(firstChar.character + " ");
            firstChar = firstChar.next;

        }



    }

    //CH 2.1, remove duplicates from an unsorted linked list
    public void removeDupes ()
    {

        //iterate through the linked list
        Node firstChar = head;
        HashSet<Character> set= new HashSet <Character>();
        while (firstChar != null)
        {
            //if character is in the Hashset, delete it
            if (set.contains(firstChar.character))
            {
                remove(firstChar);
            }
            else
            {
                //if character is in the Hashset, add it
                set.add(firstChar.character);
            }

            //move to next character
            firstChar = firstChar.next;
        }


    }

    //CH 2.2, recursive algorithm finds the kth to last element in a single linked list
    public int kthToLastRec (Node head, int k)
    {

        if (head == null) //base case
        {
            return 0;
        }

        int index=kthToLastRec (head.next,k)+1;

        if (index == k)
           System.out.println(k+" th to Last Node is "+head.character);

        return index; //return statement
    }

    //CH 2.3, find the middle of a single linked list
    public Character findMiddle ()
    {
        //start at the head
        Node p1=head;
        Node p2=head;

        while (p1 != null)
        {
            System.out.println(p1.character);

            p1=p1.next;
            p1=p1.next;

            p2=p2.next;
        }

        return p2.character;


    }

    //CH 2.3, delete the middle of a single linked list given the middle node
    public Boolean deleteMiddle (Node middle)
    {
        //make sure node exists and node points to something
        if(middle==null || middle.next==null)
            return false;

        //copy the data from the next node over to the current node, and then to delete the
        //next node
        Node next = middle.next;
        middle.character = next.character;
        middle.next = next.next;
        return true;

    }
    //CH 2.4

    //CH 2.5

}
