package Tree;

import java.util.*;

public class TreeByPostorderAndInorder {
	
	public int postIndex = 0;    
    public Node buildTreeUtil(int ino[], int post[], int start, int end, 
    		HashMap<Integer, Integer> map){
        
        if(start > end)
            return null;
        
        int val = post[postIndex--];
        
        Node node = new Node(val);
        int index = map.get(val);
        
        if(start == end)
            return node;
        
        
        node.right = buildTreeUtil(ino, post, index + 1, end, map);
        node.left = buildTreeUtil(ino, post, start, index - 1, map);
       
        
        return node;
    }
    
    public Node buildTree(int ino[], int post[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < ino.length; i++)
            map.put(ino[i], i);
        
        postIndex = n - 1;
        return buildTreeUtil(ino, post, 0, n - 1, map);
    }
    
    public void postorder(Node node) 
	{ 
		if (node == null) 
			return; 

		postorder(node.left); 

		postorder(node.right); 

		System.out.print(node.key + " "); 
	} 
	
	public static void main(String[] args) {
	    	
			TreeByPostorderAndInorder tree = new TreeByPostorderAndInorder();
	        int in[] = new int[]   {4, 8, 2, 5, 1, 6, 3, 7};
	    	int post[] = new int[] {8, 4, 5, 2, 6, 7, 3, 1}; 

//	        int in[] = new int[]   {3, 1, 4, 0, 5, 2}; 
//	        int pre[] = new int[]  {0, 1, 3, 4, 2, 5};
	        int n = in.length;
	        
	        Node root = tree.buildTree(in, post, n);
	        tree.postorder(root);
		}
}
