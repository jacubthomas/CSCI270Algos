package DivideandConquer;

public class BinaryTree {
    // Root of Binary Tree
    Node root;
    static int rc = 0;
 
    // Constructors
    BinaryTree(int key)
    {
        root = new Node(key);
    }
 
    BinaryTree()
    {
        root = null;
    }
    
    
    public static boolean findALocalMin(Node node, boolean byUpper) {
    	
    	// safety check
    	if(node == null)
    		return false;
    	
    	// local min check
    	if(byUpper) {
	    	if(node.left == null && node.right == null) {
	    		System.out.println("local min: " + node.key);
	    		return true;
	    	}
	    	else if(node.left == null) {
	    		if(node.right.key > node.key)
	    			System.out.println("local min: " + node.key);
	    			return true;
	    	}
	    	else if(node.right == null) {
	    		if(node.left.key > node.key)
	    			System.out.println("local min: " + node.key);
	    			return true;
	    	}
    	}
    	
    	System.out.println("rc: " + rc + ", node: " + node.key);
    	
    	boolean left = false;
    	boolean right = false;
    	int value_left = Integer.MAX_VALUE;
    	int value_right = Integer.MAX_VALUE;
    	rc++;
    	if(node.left != null) {
    		value_left = node.left.key;
	    	if(value_left < node.key)
	    		left = true;
    	}
    	if(node.right != null) {
    		value_right = node.right.key;
	    	if(value_right < node.key)
	    		right = true;
    	}
    	if(value_left < value_right)
    		return findALocalMin(node.left, left);
    	
    	return findALocalMin(node.right, right);
    	
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
 
        /*create root*/
        tree.root = new Node(4);
 
        /* following is the tree after above statement
 
              4
            /   \
          null  null     */
 
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
 
        /* 2 and 3 become left and right children of 1
               4
            /     \
          2        3
        /   \     /  \
      null null null null  */
 
 
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        /* 4 becomes left child of 2
                    4
                /       \
               2          3
             /   \       /  \
            1     7     5    6
           /   \
          null null
         */
        findALocalMin(tree.root, true);
    }
}
