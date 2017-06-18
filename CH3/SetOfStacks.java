package CH3;

import java.util.ArrayList;

/**
 * Created by bukolaayodele on 6/5/17.
 * CTCI CH 3.3
 * CH3.SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * CH3.SetOfStacks. push () and CH3.SetOfStacks. pop () should behave identically to a single stack
 * (that is, pop ( ) should return the same values as it would if there were just a single stack).
     Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.

public class SetOfStacks
{

    ArrayList<Stack> stacks= new ArrayList<Stack>();
    public int capacity;

    public void push (int v)
    {

    }

    public SetOfStacks (int capacity)
    {
        this. capacity = capacity;
    }

    public Stack getLastStack()
    {

        if (stacks.size() == 0)
            return null;


        return stacks.get(stacks.size() - 1);

    }

    public Boolean isFull()
    {
        Boolean full= false;


        return full;

    }
    public boolean isEmpty()
    {
        Stack last = getLastStack();

        return last == null || last.isEmpty();
    }

    public int pop ()
    {
        int popVal=0;
        Stack last = getLastStack();
        //if there is a stack and it is not full add item
        if (last != null && !last.isFull())
            last.push(v);
        else
        {
            // create new stack
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }


        return popVal;

    }

    public int popAt (int x)
    {
        int popVal=0;


        return popVal;
    }

}

 */