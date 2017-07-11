package CH10;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by bukolaayodele on 6/20/17.
 */
public class Pratice
{


    public static class BinarySearch {
        // Returns index of x if it is present in arr[l..r], else return -1
        public static int binarySearch(int arr[], int l, int r, int x) {
            if (r >= l) {
                int mid = l + (r - l) / 2;

                // If the element is present at the middle itself
                if (arr[mid] == x)
                    return mid;

                // If element is smaller than mid, then it can only be present in left subarray
                if (arr[mid] > x)
                    return binarySearch(arr, l, mid - 1, x);

                // Else the element can only be present in right subarray
                return binarySearch(arr, mid + 1, r, x);
            }

            // We reach here when element is not present in array
            return -1;
        }
    }
        //CTCI, 10.1
    //You are given two sorted arrays, A and B, where A has a large enough buffer at the
    //end to hold B. Write a method to merge B into A in sorted order
    public static int [] merge(int [] a, int [] b)
    {
        //three pointer, index of A,index of B, index of Merged
        int indexB= b.length-1;
        int indexA= a.length-indexB-1;
        int indexMerged=a.length-1;

        //starting at the last element so we don't have to shift
        while (indexB>=0) //while you aren't at the end of B
        {
            //move the bigger number in A and B, into the index of merged
            if (indexA>=0 && a[indexA]>b[indexB])
            {
                a[indexMerged] = a[indexA];
                indexA--;
            }
            else
            {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;

        }
        return a;

    }
    /* CTCI, 10.2, Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to each other */
    //Solution One, Arrays.sort method can take an class of Comparision, so Arrays.sort(array, new Comparison Class)
    //We create a Anagram Comparison that compares two sorted a Strings
    public static class AnagramComparator implements Comparator<String>
    {
        //sort the character in a String string in alphabetical order
        public static String sortString (String s)
        {
            char [] content=s.toCharArray();
            Arrays.sort(content);

            return new String (content);
        }

        //find out if two sorted strings are anagrams, 0 mean there are no differences
        @Override
        public int compare(String A, String B)
        {
            return sortString(A).compareTo(sortString(B));
        }
    }

    //Solution Two, We use a Hash Table to maps from the sorted version of a word to a list of its anagrams.
    //then we covert the Hash Table to an array
    public static String sortChars (String s)
    {
        char [] content=s.toCharArray();
        Arrays.sort(content);

        return new String (content);
    }
    public static void sortAnagram (String[] array)
    {
        //create a hash map, where String maps to a String
        HashMap<String, String> mapList= new HashMap<String, String>();

        //Group Words that are anagram by sorting the strings to see if there is a match
        for (String s : array)
        {
            String key = sortChars(s);
            mapList.put(key, s);
        }

        //Convert hash table to array list
        int index = 0;
        ArrayList <String> list= new ArrayList <String> ();
        for (String key: mapList.keySet())
        {
            list.add(mapList.get(key));
            for (String t : list)
            {
                array[index] = t;
                index++;
            }
        }
    }

    /* CTCI, 10.3, Given a sorted array of n integers that has been rotated an unknown
     *number of times, write code to find an element in the array. You may assume that the array was
     *originally sorted in increasing order.*/
    public int search(int a[], int left, int right, int x)
    {
        int mid = (left + right);
        if (x == a[mid]) // Found element
        {  return mid;
        }
        if (right < left)
        {
            return -1;
        }

        /* Either the left or right half must be normally ordered. Find out which side
        * is normally ordered, and then use the normally ordered half to figure out
        * wh i ch side to search to find x. */
        if (a[left] < a[mid]) // Left is normally ordered
        {
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x); // Search left
            } else {
                return search(a, mid + 1, right, x); // Search right
            }
        }

        else if (a[mid] < a[left])// Right is normally ordered.
        {
            if (x > a[mid] && x <= a[right]) // Search right
            {
                return search(a, mid + 1, right, x);
            }
            else // Search left
            {
                return search(a, left, mid - 1, x);
            }
        }
        else if (a[left] == a[mid]) // Left or right half is all repeats
        {
            if (a[mid] != a[right])  // If right is different, search it
            {
                return search(a, mid + 1, right , x); // search right
            }
            else // Else, we have to search both halves
            {
                int result = search(a, left, mid - 1, x); // Search left
                if (result == -1)
                {
                    return search(a, mid + 1, right, x); //Search right
                }
                else
                {
                    return result;
                }
            }
        }

         return -1;
    }

    /* CTCI, 10.4, You are given an array-like data structure Listy which lacks a size
    method. It does, however, have an elementAt (i) method that returns the element at index i in
    0(1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
    structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
    find the index at which an element x occurs. If x occurs multiple times, you may return any index*/

    public static class Listy
    {
        public static int [] list;

        public Listy ( int [] x)
        {
            list=x;
        }

        public static int elementAt (int i)
        {
            return list [i];
        }

    }

    //Solution One: If we find the size of an array we can do a binary search
    //to find the index of element x
    public int search (Listy list, int value)
    {
        int index = 1;
        //this function finds the size of the list
        while (list.elementAt(index) != -1 && list.elementAt(index) < value)
        {
            //multiply by 2 because we want to move this exponentially
            index *= 2;
        }
        return binarySearch(list, value, index / 2, index) ;
    }

    /* CTCI, 10.5,
    Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a
    method to find the location of a given string.*/

    /* CTCI, 10.6,
    Sort Big File: Imagine you have a 20 GB file with one string per line.
    Explain how you would sort the file.*/

    /*CTCI 10.7 Missing Int: Given an input file with four billion non-negative integers, provide an algorithm to
    generate an integer that is not contained in the file. Assume you have 1 GB of memory available for
    this task. */


    /*CTCI 10.8: Find Duplicates: You have an array with all the numbers from 1 to N, where N is at most 32,000. The
    array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory
    available, how would you print all duplicate elements in the array?*/


    /* CTCI 10.9: Sorted Matrix Search: Given an M x N matrix in which each row and each column is sorted in
     ascending order, write a method to find an element. */

    public int binarySearch(Listy list, int value, int low, int high)
    {
        int mid;
        while (low <= high)
        {
            mid = (low + high) / 2;
            int middle = list . elementAt(mid);
            if (middle> value || middle == -1)
            {
                high = mid - 1;
            }
            else if (middle < value)
            {
                low = mid + 1;
            }
            else
            {
                return mid ;
            }

        }
        return -1;

    }


    public static void main(String args[])
    {
        /**
        //CH 10.2 Solution One
        String [] array= new String []{"cat","bat","tac","you","tab"};
        String [] sortedArr;
        Arrays.sort(array, new AnagramComparator());
        System.out.println(Arrays.toString(array));
         **/
        int x= 7/2;
        System.out.println(x);


        /**
        //String ex1= sortString("CATABIG");
        //String ex2= sortString("ABIGCAT");
        String ex3=sortString("bigi");
        String ex4="CATABIG";
        String sorted= sortString("ABIGCAT");
        int sort= isAnagram(ex2,ex4);

        System.out.println(sort);
         **/

    }
}


