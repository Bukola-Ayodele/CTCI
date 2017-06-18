package CH1;

import Ch2.SinglyLinkedList;

import java.util.HashSet;

/**
 * Created by bukolaayodele on 5/2/17.
 */
public class Ch1
{

    //CH 1.1, algorithm that check if a string has all unique character
    public static Boolean uniqueCharacter (String s)
    {
        Boolean uniqueCharacter=true;
        for (int i=0;i< s.length();i++)
        {
            //loop through string, pull out a character
            String currentCharacter= String.valueOf(s.charAt(i));

            // check it against other characters in the string except itself
            for (int x=0;x< s.length();x++)
            {
                String newCharacter= String.valueOf(s.charAt(x));

                //if current character is equal to new character & not the same exact character (position)
                if (currentCharacter.equals(newCharacter) && x!=i)
                {
                    uniqueCharacter=false;
                    break;
                }
                else
                    uniqueCharacter=true;

            }
        }

        return uniqueCharacter;

    }

    //put string in array, sort array, turn array into sorted String
    public static String sort (String s)
    {
        char[] sortedArr=s.toCharArray();
        java.util.Arrays.sort(sortedArr);
        String sortedString=String.copyValueOf(sortedArr);
        System.out.println(sortedString);


        return sortedString;

    }

    //CH 1.2 find is two strings are permutations of each other by sorting the String and seeing if they are equal
    public static Boolean isPermutation (String s1,String s2 )
    {
        //sort the string into a list of arrays & if the arrays are the same, two strings are Perm
        Boolean isPerm= false;
        if (sort(s1).equals(sort(s2)))
        {
            isPerm= true;
        }

        return isPerm;

    }

    //CH 1.3 Write a method to replace all spaces in a string with '%20'
    public static String urlify (String s, int slength ) {

        String url=s;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i)== ' ')
                url+="%20";
            else
                url+= String.valueOf(s.charAt(i));
        }
        return url;
    }

    //CH 1.4 Checks if a String in a Palindrome and Permutation
    public static Boolean aPalindrome (String s)
    {
        Boolean isPalindrome=false;
        int stringlength=s.length();

        //if the
        for (int i = 0; i < s.length(); i++)
        {
            //skip the middle
            if (s.charAt(i)==s.charAt(s.length()-i))
                isPalindrome=true;
            else
            {
                isPalindrome = false;
                break;
            }

        }


        return isPalindrome;

    }

    //CH 1.5, checks to see if a s1 is one edit (insert,delete, removed character) away from s2
    public static Boolean oneAway (String s1,String s2 )
    {
        Boolean oneEdit=false;
        int edit=0;

        //take the string 1 convert to array
        char[] s1Array=s1.toCharArray();

        //take string 2 convert to array
        char[] s2Array=s2.toCharArray();



        //for loop thru array one check against array 2 if there are changes edits++
        for (int x=0;x<(s1Array.length-1);x++)
        {
            //if the characters are not the same the string has been edited
            if (s1Array[x]!=s2Array[x])
            {
                System.out.println("Change detected");
                edit++;
            }
            //if s1 is bigger
            //else if ()

            System.out.println(edit);
            //if more than one change detected
            if (edit<=1 )
                oneEdit=true;
        }


        return oneEdit;

    }


    //CH 1.6, take a string and compress it using the the count of repeated character
    //ex: aabcccccaaa ->a2b1c5a3
    //if the compressed string is not smaller than the original return the original
    public static String strCompress (String s)
    {
        //string builder reduces the runtime
        StringBuilder compress= new StringBuilder();
        int freq=0;

        for (int i=0; i<s.length();i++)
        {
            //counts how frequently character appears
            freq++;
            //if next character is different from the current, add that character to String Builder
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1))
            {
                compress.append(s.charAt(i));
                compress.append(freq);
                freq=0; //reset the count
            }

        }
        //if the compressed string is not smaller than the original return the original
        return compress.length() < s.length() ? compress.toString() :s;

    }

    //__________________________________________________________________________________________________//

    //Input: "Let's take LeetCode contest"
    //Output: "s'teL ekat edoCteeL tsetnoc"
    public static String reverse (String s)
    {
        String reverse="";
        String temp="";

        for (int i=s.length();i>=1;i--)
        {
            System.out.println(i);
            System.out.println("Current Char:" +s.charAt(i - 1));

            if (s.charAt(i - 1) == ' ')
            {
                if (reverse=="")
                {
                    reverse= temp;
                }
                else
                    reverse= temp + ' ' + reverse;
                temp="";

                System.out.println("Temp: '"+temp+"'");
                System.out.println("Reverse: '"+reverse+"'");
            }
            else if (i==1)
            {
                if (reverse=="")
                {
                    temp += s.charAt(i - 1);
                    reverse= temp;
                }
                else
                {
                    temp += s.charAt(i - 1);
                    reverse = temp + ' ' + reverse;
                }
            }
            else
            {
                temp += s.charAt(i - 1);
            }
            System.out.println("Temp: '"+temp+"'");
            System.out.println("Reverse: '"+reverse+"'");
        }


        return reverse;

    }

    public static int lengthOfLongestSubstring(String s)
    {
        HashSet unique= new HashSet();
        String longest="";
        String current="";

        for (int i=0; i<s.length();i++)
        {
            //edgecase
            if (s.length()==1)
                return 1;

            if (unique.contains(s.charAt(i)))
            {

                if (current.charAt(0)==s.charAt(i) && current.charAt(0)==s.charAt(i+1))
                {
                    unique.remove(s.charAt(i));
                    current = current.substring(0);

                }
                else
                {
                    unique=new HashSet();
                    current = String.valueOf(s.charAt(i));
                    unique.add(s.charAt(i));
                }

            }
            else
            {
                current=current + String.valueOf(s.charAt(i));
                unique.add(s.charAt(i));
            }

            if (current.length()>longest.length())
                longest=current;
        }

        return longest.length();


    }

    public static void main(String[] args)
    {
        //System.out.println(lengthOfLongestSubstring("bbbbb"));

        int i=9/10;
        System.out.println(i);


        /*
        SinglyLinkedList cat= new SinglyLinkedList();
        cat.add(5);
        cat.add(8);
        cat.add(5);
        cat.add(10);
        cat.add(2);
        cat.add(1);

        cat.printList();
        int a= cat.reverseLL(cat).data;
        System.out.println(a);


        //cat.partition(cat.head,5);


        //cat.printList();

        //System.out.println(strCompress("aabcccccaaa"));

        /**
        Ch2.LinkedList cat= new Ch2.LinkedList();
        cat.add('a');
        cat.add('t');

        Ch2.LinkedList catty= new Ch2.LinkedList();
        catty.add('a');
        catty.add('t');
        catty.add('t');
        catty.add('t');
        catty.add('y');

        Ch2.LinkedList cabe= new Ch2.LinkedList();
        //catty.add('c');
        catty.add('a');
        catty.add('b');
        catty.add('e');



        System.out.println(catty.findMiddle());
        //catty.removeDupes();
        //catty.printList();
**/


    }

}
