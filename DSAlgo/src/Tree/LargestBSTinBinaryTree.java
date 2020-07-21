package Tree;

public class LargestBSTinBinaryTree {
	
	Node root;
	
	class Info{
	    int min;
	    int max;
	    boolean isBST;
	    int size ;
	    
	    Info()
	    {
	        min = Integer.MAX_VALUE;
	        max = Integer.MIN_VALUE;
	        isBST = true;
	        size = 0;
	    }
	}
	
	    public int largestBST(){
	    	Info res = largestBSTUtil(root);
	        return res.size;
	    }
	    
	    public Info largestBSTUtil(Node root){
	  
	        if(root == null){
	            return new Info();
	        }
	        
	        
	        
	        Info l = largestBSTUtil(root.left);
	        Info r = largestBSTUtil(root.right);
	        
	        Info res = new Info();
	        
	        if(l.isBST == false || r.isBST == false || 
	        		(l.max >= root.key || r.min <= root.key)){
	            res.isBST = false;
	            res.size = Math.max(l.size, r.size);
	            return res;
	        }
	        
	        res.isBST = true;
	        
	        res.size = l.size + r.size + 1;

	        res.min = root.left != null ? l.min : root.key;

	        res.max = root.right != null ? r.max : root.key;
	   
	        return res;
	    }
	    
	    public static void main(String[] args) {
	    	LargestBSTinBinaryTree tree = new LargestBSTinBinaryTree();
	    	tree.root = new Node(8); 
			tree.root.left = new Node(11); 
			tree.root.right = new Node(1); 
			tree.root.left.left = new Node(10); 
			tree.root.right.left = new Node(1);
			tree.root.right.right = new Node(6);
			tree.root.left.left.left = new Node(9);
			tree.root.left.left.right = new Node(4);
			
			System.out.println(tree.largestBST());
		}
}
