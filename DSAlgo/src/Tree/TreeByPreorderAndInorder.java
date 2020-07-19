package Tree;

import java.util.*;

public class TreeByPreorderAndInorder {
	
	public int preIndex = 0;    
    public Node buildTreeUtil(int in[], int pre[], int start, int end, 
    		HashMap<Integer, Integer> map){
        
        if(start > end)
            return null;
        
        int val = pre[preIndex++];
        
        Node node = new Node(val);
        int index = map.get(val);
        
        if(start == end)
            return node;
        
        node.left = buildTreeUtil(in, pre, start, index - 1, map);
        node.right = buildTreeUtil(in, pre, index + 1, end, map);
        
        return node;
    }
    
    public Node buildTree(int in[], int pre[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++)
            map.put(in[i], i);
        
        return buildTreeUtil(in, pre, 0, n - 1, map);
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
	    	
			TreeByPreorderAndInorder tree = new TreeByPreorderAndInorder();
//	        int in[] = new int[]  {8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7};
//	    	int pre[] = new int[] {1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7}; 

	        int in[] = new int[]   {3, 1, 4, 0, 5, 2}; 
	        int pre[] = new int[]  {0, 1, 3, 4, 2, 5};
	        int n = in.length;
	        
	        Node root = tree.buildTree(in, pre, n);
	        tree.postorder(root);
		}
}
