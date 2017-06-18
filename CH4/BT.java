package CH4;

/**
 * Created by bukolaayodele on 6/12/17.
 */
public class BT

{
    public static class Node
    {
        int value;
        Node left;
        Node right;

        public  Node (int value)
        {
            this.value=value;
            left=null;
            right=null;
        }

        public  Node (Node left,int value, Node right)
        {
            this.value=value;
            this.left=left;
            this.right=right;
        }

        public Node getLeft ()
        {
            return left;
        }

        public Node getRight ()
        {
            return right;
        }

        public int getValue ()
        {
            return value;
        }
        public Node setLeft (Node x)
        {
            return left;
        }

        public Node setRight ()
        {
            return right;
        }

        public int setValue ()
        {
            return value;
        }

    }
    public Node root;

    public BT ()
    {
        root=null;
    }

    //inserting  into a Binary Tree
    public void insert(int data)
    {
       // System.out.println(data);

        root = insert(root, data);
       // System.out.println("Root Value is: "+root.getValue());
    }

    //inserting into a Binary Tree Recursively
    public Node insert (Node node, int data)
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

        //System.out.println("Node Value is: "+node.value);
        return node;
    }

    public void inOrder (Node node)
    {
        //base case
        if (node==null)
            return;

        //first visit the left child
        preOrder (node.left);

        //first visit the root node (which is the node we've been given
        System.out.print(node.value + " ");

        //first visit the right child
        preOrder (node.right);

    }
    public void postOrder (Node node)
    {
        //base case
        if (node==null)
            return;

        //first visit the left child
        preOrder (node.left);

        //first visit the right child
        preOrder (node.right);

        //first visit the root node (which is the node we've been given
        System.out.print(node.value + " ");



    }

    public void preOrder (Node node)
    {
        //base case
        if (node==null)
            return;

        //first visit the root node (which is the node we've been given
        System.out.print(node.value + " ");

        //first visit the left child
        preOrder (node.left);

        //first visit the right child
        preOrder (node.right);

    }





    public static void main(String[] args)
    {
        BT binaryTree= new BT();

        BT tree= new BT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        binaryTree.root = new Node(1);
        binaryTree.insert(2); //right
        binaryTree.insert(3); //left
        //binaryTree.insert(4);

        //System.out.println(binaryTree.root.getLeft().getValue());
        //System.out.println(binaryTree.root.getRight().getValue());

        //binaryTree.inOrder(binaryTree.root);
        //System.out.println( );
        //binaryTree.preOrder(binaryTree.root);
        //System.out.println( );
        //binaryTree.postOrder(binaryTree.root);

        System.out.println("Preorder traversal of binary tree is ");
        tree.preOrder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.inOrder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postOrder(tree.root);


    }
}
