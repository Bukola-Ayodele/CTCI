package LeetCode;

import java.util.HashMap;

import java.util.Arrays;

/**
 * Created by bukolaayodele on 6/26/17.
 */
public class LeetCodeP
{

    /*Leetcode 24) Given a linked list, swap every two adjacent nodes and return its head.
    *Given 1->2->3->4, you should return the list as 2->1->4->3 (See CH 1-> Singly Linked List)
     */

    /*Leetcode 72) Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
    each operation is counted as 1 step.)
    a) Insert a character
    b) Delete a character
    c) Replace a character*/

    public int minDistance(String word1, String word2)
    {//Dynamic Programming
        //If you wanna delete, you go back to previous column, which is T[i][j-1], because you'd like to retrieve the last character in str2.
        //if you wanna insert, you go back to previous row, which is T[i-1][j].
        //For replacing current character, you need to retrieve last character in both str1 and str2, which is T[i-1][j-1].
        //At last, you get the minimum among the above 3 moves and plus 1 to it to get T[i][j].
        //creating a temporary array for the Dynamic Programming Solution
        int temp [][]= new int [word1.length()+1][word2.length()+1];

        //fill out the first row in the array
        for (int i=0; i<temp[0].length; i++)
        {
            temp[0][i]=i;
        }

        //fill out the first column in the array
        for (int i=0; i<temp.length; i++)
        {
            temp[i][0]=i;
        }

        //use a nested loop to fill out all of the solutions in the 2D array
        for (int i=0; i<word1.length(); i++)
        {
            for (int j=0; i<word2.length(); i++)
            {
                //if the characters are the same, just take the diagonal value
                if(word1.charAt(i-1) == word1.charAt(j-1))
                {
                    temp[i][j] = temp[i-1][j-1];
                }
                else
                {
                    //the characters are different so take the minimum edit from the diagonal (replace)
                    //the left (delete) and the top (insert)
                    temp[i][j] = 1 + Math.min(Math.min(temp[i-1][j-1], temp[i-1][j]), temp[i][j-1]);
                }

            }
        }

        //return the last item in the 2D array which will show the minimum changes
        return temp[word1.length()][word2.length()];



    }

    //Leetcode 49) Group Anagrams
    public static String [] [] anagramList (String [] x)
    {
        String[] [] anaList = new String[x.length][x.length];
        HashMap<String,Integer> anagrams= new HashMap<>();
        int columnCount=0;

        for (int i=0; i<x.length;i++)
        {
            char[] chars = x[i].toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);

            if(anagrams.containsKey(sorted))
            {
                int rowCont=anagrams.get(sorted);
                anaList[rowCont][anaList[rowCont].length]=x[i];
            }
            else
            {
                anagrams.put(sorted,columnCount);
                anaList[columnCount][anaList[0].length]=x[i];
                columnCount++;
            }



        }

        return anaList;
    }

    //Leetcode 73)Given a m * n matrix, if an element is 0, set its entire row and column to 0.
    public int [] [] setZero (int [] [] matrix)
    {
        boolean fr = false; //rows
        boolean fc = false;// column

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(i == 0)
                        fr = true;
                    if(j == 0)
                        fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++)
            {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }

    /*Leetcode 100) Given two binary trees, write a function to check if they are equal or not.
     *Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     */


    /*Leetcode 121) Best time to Buy and Sell Stock Say you have an array for which the ith element is the
    price of a given stock on day i.If you were only permitted to complete at most one transaction
    (ie, buy one and sell one share of the stock),design an algorithm to find the maximum profit.*/
    public static int maxProfit (int [] prices)
    {
        //by keeping track of the smallest Buy and constantly subtracting it from
        //every subsequent number we can find the maximum Profit
        int maxProfit=0;
        if (prices.length==0)
            return 0;

        int smallestBuy=prices[0];

        for (int i=0;i<prices.length;i++)
        {
            if (prices[i]<smallestBuy)
                smallestBuy=prices[i];
            if (prices[i]-smallestBuy>maxProfit)
                maxProfit=prices[i]-smallestBuy;
        }


        return maxProfit;
    }

    //Leetcode 125) Given a string, determine if it is a palindrome
    public static boolean isPalindrome(String s)
    {
        Boolean isPalindrome=true;
        int start=0;
        int end= s.length()-1;

        //traverse a string from the front and the back
        //if you find that position X, isn't equal to its opposite return false
        while (start<end)
        {
            if (s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }


        return isPalindrome;

    }

    /*Leetcode 268) Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
    find the one that is missing from the array */
    public static int missingNumber(int[] nums)
    {
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i] !=i)
                return i;
        }
        return -1;

    }


    /** Leetcode 520) Given a word, you need to judge whether the usage of capitals in it is right or not.
     *We define the usage of capitals in a word to be right when one of the following cases holds:
     1) All letters in this word are capitals, like "USA".
     2) All letters in this word are not capitals, like "leetcode".
     3) Only the first letter in this word is capital if it has more than one letter, like "Google".
     Otherwise, we define that this word doesn't use capitals in a right way
     */
    public static boolean detectCapitalUse(String word)
    {
        //capital letters have an ASCII value btw 65-90, lower case letters have an ASCII value of 97-122

        for (int i=0; i<word.length(); i++)
        {
            int firstChar= (int) word.charAt(0);
            int currentChar=(int) word.charAt(i);

            //if first character is upper case
            if (65<=firstChar && firstChar<=90 && i>=1 )
            {
                //all subsequent character need to be compares to the second charater & must be the same case
                int secondChar=(int) word.charAt(1);

                //if second letter is upper case, and subsequent are lower case, return false
                if(65<=secondChar && secondChar<=90 && 97<=currentChar && currentChar<=122)
                    return false;

                //if second letter is lower case and subsequent is upper case, return false
                if(97<=secondChar && secondChar<=122 && 65<=currentChar && currentChar<=90 )
                    return false;

            }

            //first character is lower case but current character is upper case return false
            if  (97<=firstChar && firstChar<=122 && 65<=currentChar && currentChar<=90 )
            {
                return false;
            }


        }
        return true;

    }

    //solution not using ASCII but Character method isUpperCase & isLowerCase
    public static boolean detectCapitalUseTWO(String word)
    {
        //capital letters have an ASCII value btw 65-90, lower case letters have an ASCII value of 97-122

        for (int i=0; i<word.length(); i++)
        {
            Character firstChar= word.charAt(0);
            Character currentChar= word.charAt(i);

            //if first character is upper case
            if (Character.isUpperCase(firstChar) && i>=1)
            {
                //all subsequent character need to be compares to the second charater & must be the same case
                Character secondChar= word.charAt(1);

                //if second letter is upper case, and subsequent are lower case, return false
                if(Character.isUpperCase(secondChar) && Character.isLowerCase(currentChar))
                    return false;

                //if second letter is lower case and subsequent is upper case, return false
                if(Character.isLowerCase(secondChar) && Character.isUpperCase(currentChar) )
                    return false;

            }

            //first character is lower case but current character is upper case return false
            if  (Character.isLowerCase(firstChar) && Character.isUpperCase(currentChar))
            {
                return false;
            }


        }
        return true;

    }

    public static void rotate(int[] nums, int k)
    {
        int p1=0;
        int p2=k;
        int prev;

        while (p1>=k && p2>=nums.length)
        {


            if (p2>=nums.length)
            {
               nums[p1]= nums[p2];
            }
            else
            {
                prev=nums[p1];
                nums[p1]=prev;
            }



            p1++;
            p2++;

        }

    }





        public static void main(String[] args)
    {
        int prices []= new int [] {0,1,2,4};
        String list []= new String []{"eat", "tea", "tan", "ate", "nat", "bat"};
        String usa= "USA";
        String lower= "lowercase";
        String wrong= "FaLSE";
        String us="uS";
        Character a='a';

        //String [][] newList=anagramList(list);

        //Arrays.deepToString(newList);

        System.out.println(Arrays.toString(list));


    }
}
