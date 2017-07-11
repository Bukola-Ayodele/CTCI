package CH8;

/**
 * Created by bukolaayodele on 6/8/17.
 */
public class CH8
{

    //CH 8.1, recursive solution for counting steps
    public static int countWays (int n)
    {
        //edge case
        if (n<0)
            return 0;
        else if (n==0)
        {
            return 1;
        }
        else
        {
            System.out.println("N is currently: "+n);
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }

    }

    //recursive solution for (http://www.geeksforgeeks.org/count-ways-reach-nth-stair/)
    //explanation (https://www.youtube.com/watch?v=CFQk7OQO_xM)
    public static int ways (int n)
    {
        System.out.println("N is currently: "+n);
        //edge case
        if (n<=1)
            return 1;
        else
        {
            //System.out.println("N is currently: "+n);
            return ways(n - 1) + ways(n - 2);
        }

    }




    public static void main(String[] args)
    {
       // System.out.println(countWays(4));

        System.out.println(ways(2));
    }
}

