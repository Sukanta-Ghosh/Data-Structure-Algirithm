package Tree;

public class LargestBSTinBinaryTree {
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
	
	    public int largestBST(Node root){
	    	Info res = largest(root);
	        return res.size;
	    }
	    
	    public Info largest(Node root){
	  
	        if(root == null){
	            return new Info();
	        }
	        
	        Info l = largest(root.left);
	        Info r =largest(root.right);
	        
	        Info res = new Info();
	        
	        if(l.isBST == false || r.isBST == false || 
	        		(l.max > root.key || r.min <= root.key)){
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
}
