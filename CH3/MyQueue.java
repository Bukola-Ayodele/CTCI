package CH3;

/**
 * Created by bukolaayodele on 6/5/17.
 * Implement a CH3.MyQueue class which implements a queue using two stacks.
 * Since the major difference between a queue and a stack is the order (first-in first-out vs.last-in first-out), we
 know that we need to modify peek ( ) and pop ( ) to go in reverse order. We can use our second stack to
 reverse the order of the elements (by popping S1 and pushing the elements on to 52).
 In such an implementation, on each peek () and pop () operation, we would pop everything from s1 onto s2, perform
 the peek / pop operation, and then push everything back.
 This will work, but if two pop / peeks are performed back-to-back, we're needlessly moving elements. We
 can implement a "lazy" approach where we let the elements sit in s2 until we absolutely must reverse the
 elements.
 In this approach, stackNewest has the newest elements on top and stackOldest has the oldest
 elements on top. When we dequeue an element, we want to remove the oldest element first, and so we
 dequeue from stackOldest. If stackOldest is empty, then we want to transfer all elements from
 stackNewest into this stack in reverse order. To insert an element, we push onto stac kNewest, since it
 has the newest elements on top.

public class MyQueue
{

    Stack stackNewest, stackOldest;

    public MyQueue ()
    {
        stackNewest =new Stack();
        stackOldest=new Stack();
    }

    public int size()
    {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(int value)
    {
        // Push onto stackNewest, which always has the newest elements on top
        stackNewest.push(value);
    }

    // Move elements from stackNewest into stackOldest. This is usually done so that we can do operations on stackOldest.
    private void shiftStacks() {
        if (stackOldest.isEmpty())
        {
            while (!stackNewest.isEmpty())
                stackOldest.push(stackNewest.pop());
        }
    }

    public int peek()
    {
        shiftStacks(); //ensure stack oldest has the current elements
        return stackOldest.peek(); //retrieve the oldest item
    }

    public int remove()
    {
        shiftStacks();//Ensure stackOldest has the current elements
        return stackOldest.pop(); //pop the oldest item.

    }




}
        */