package Tree;

public class FloorCeilInBST {
	
	Node floorIte(Node root, int x) {
		
		Node floor = null;
		while(root != null) {
			
			if(root.key == x)
				return root;
			else if(root.key > x)
				root = root.left;
			else {
				floor = root;
				root = root.right;
			}
		}
		return floor;
	}
	
	Node ceilIte(Node root, int x) {
		
		Node ceil = null;
		while(root != null) {
			
			if(root.key == x)
				return root;
			else if(root.key > x) {
				ceil = root;
				root = root.left;
			}
			else {
				
				root = root.right;
			}
		}
		return ceil;
	}
	
	int getCount(Node node, int low, int high) 
    { 
        // Base Case 
        if(node == null) 
            return 0; 
  
        // If current node is in range, then  
        // include it in count and recur for  
        // left and right children of it 
        if(node.key >= low && node.key <= high) 
            return 1 + this.getCount(node.left, low, high)+ 
                this.getCount(node.right, low, high); 
                  
        // If current node is smaller than low,  
        // then recur for right child 
        else if(node.key < low) 
            return this.getCount(node.right, low, high); 
          
        // Else recur for left child 
        else
            return this.getCount(node.left, low, high);      
    } 
}
