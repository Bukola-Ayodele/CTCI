package LeetCode;

import java.util.HashSet;

/**
 * Created by bukolaayodele on 6/26/17.
 */
public class CircularHash
{
    Object [] circular;
    int position;
    int size;
    HashSet hash;

    public CircularHash (int size)
    {
        this.size=size;
        circular=new Object[size];
        position=0;
        hash= new HashSet();
    }


    public void add (Object value)
    {

        //before adding any object to the hash we need to make sure the hash doesn not contain that Object
        if (!hash.contains(value))
        {
            //we need to remove any object in that will be in the position the new hash is supposed to be
            if (circular[position]!=null)
                hash.remove(circular[position]);
            //add the value to the hash
            hash.add(value);
            circular[position]=value;

            //if the object was added to the end of the circular hash
            //change the new position to 0 else increment by one
            if (position==size)
                position=0;
            else
                position++;

        }



    }


}
