package CH4;
import java.util.Scanner;
/**
 * Created by bukolaayodele on 6/7/17.
 */
public class BinaryTree
{
    public class Node
    {
        public Node left,right;
        public int data;

        //creates a node for Binary Tree
        public Node(Node left,int data, Node right)
        {
            this.data=data;
            this.left=left;
            this.right=right;
        }

        public Node(int data)
        {
            data=data;
            left=null;
            right=null;
        }
        // Function to set left node
        public void setLeft(Node n)
        {
            left = n;
        }

        // Function to set right node
        public void setRight(Node n)
        {
            left = n;
        }
        //Function to set data to node
        public void setData(int d)
        {
            data = d;
        }

        // Function to get left node
        public Node getLeft()
        {
            return left ;
        }

        // Function to get right node
        public Node getRight ()
        {
            return right ;
        }

        // Function to get data
        public int getData ()
        {
            return data ;
        }
    }

public Node root;

    public BinaryTree()
    {
        root=null;

    }
    public boolean isEmpty()
    {
        return root == null;
    }

    //adds a new node to the tree
    public void add (int data)
    {
        Node newNode= new Node(data);
    }

    //adds new Node to left of a tree
    public void addLeft (Node root, int data)
    {
        Node newNode= new Node(data);
        root.setLeft(newNode);

    }

    //adds new Node to left of a tree
    public void addRight (Node root, int data)
    {
        Node newNode= new Node(data);
        root.setRight(newNode);
    }

    //Functions to insert data
    public void insert(int data)
    {
        root = insert(root, data);
    }

    // Function to insert data recursively
    public Node insert(Node node, int data)
    {
        if (node == null) //base case
            node = new Node(data);
        else
        {
            if (node.getRight() == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }

    /* Function to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(Node r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
    /* Function to search for an element */
    public boolean search(int val)
    {
        return search(root, val);
    }
    /* Function to search for an element recursively */
    private boolean search(Node r, int val)
    {
        if (r.getData() == val)
            return true;
        if (r.getLeft() != null)
            if (search(r.getLeft(), val))
                return true;
        if (r.getRight() != null)
            if (search(r.getRight(), val))
                return true;
        return false;
    }

    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(Node r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(Node r)
    {
        if (r != null)
        {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }

    //The algorithm is as follows:
    //1. Insert into the tree the middle element of the array.
    //2. Insert (into the left subtree) the left subarray elements.
    //3. Insert (into the right subtree) the right subarray elements.
    //4. Recurse.
    public Node createMinimalBST (int [] array)
    {
        return createMinimalBST(array, 0, array. length - 1);
    }

    public Node createMinimalBST (int arr[] , int start, int end)
    {
        if (end < start)
        {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n. right = createMinimalBST(arr, mid + 1, end);

        return n;
    }

    public static void main(String[] args)
    {
        int arr[] = {1,2,3,4,5};
        int num= 0+1/2;
        System.out.println(num);

        /*
        Scanner scan = new Scanner(System.in);
        // Creating object of BT
        BinaryTree bt = new BinaryTree();
        //  Perform tree operations
        System.out.println("Binary Tree Test\n");
        char ch;
        do
        {
            System.out.println("\nBinary Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    bt.insert( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : "+ bt.search( scan.nextInt() ));
                    break;
                case 3 :
                    System.out.println("Nodes = "+ bt.countNodes());
                    break;
                case 4 :
                    System.out.println("Empty status = "+ bt.isEmpty());
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            // Display tree
            System.out.print("\nPost order : ");
            bt.postorder();
            System.out.print("\nPre order : ");
            bt.preorder();
            System.out.print("\nIn order : ");
            bt.inorder();

            System.out.println("\n\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    */
    }
}





