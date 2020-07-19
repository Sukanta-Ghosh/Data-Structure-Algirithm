package Tree;

/*GFG link - 
https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
*/
public class ChildrenSumProperty {
	 
	Node root;
	
	public int isChildrenSum(Node node){
		int left_data = 0;
		int right_data = 0;
		
		if(node == null || node.left == null && node.right == null){
			return 1;
		}
		
		if(node.left != null)
			left_data = node.left.key;
		
		if(node.right != null)
			right_data = node.right.key;
		
		if((node.key == left_data + right_data) 
                && isChildrenSum(node.left)!=0 
                && isChildrenSum(node.right)!=0)
		{
			return 1;
		}
		else
			return 0;
	}
	
	public static void main(String args[])  
    { 
        /* create a tree */
		ChildrenSumProperty tree = new ChildrenSumProperty();
		
		/* Constructed binary tree is 
		        10 
		      /    \ 
		     8      2 
		   /   \   /
		  3     5 2
		*/
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2);
        tree.root.right.left = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
           
        System.out.println(tree.isChildrenSum(tree.root)); 
    } 
}
