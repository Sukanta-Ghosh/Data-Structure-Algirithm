package Tree;

class Node1{
	int key;
	Node1 left, right;
	int lCount;
	Node1(int x){
		key = x;
	}
}

public class KthSamllestEleInBST {
	
	Node1 root;
	
	/* Recursive Approach */
	Node1 kthSmallest(Node1 root, int k) {
		
		if(root.lCount + 1 == k) {
			return root;
		}
		else if(root.lCount + 1 > k) {
			return kthSmallest(root.left, k);
		}
		else{
			k = k - root.lCount - 1; 
			return kthSmallest(root.right, k);
		}
	}
	
	/* Recursive Approach */
	Node1 insertRec(Node1 root, int x) {
		
		if(root == null)
			return new Node1(x);
		
		if(root.key > x) {
			root.lCount++;
			root.left = insertRec(root.left, x);
		}
		else if(root.key < x)
			root.right = insertRec(root.right, x);
		
		return root;
	}
	
	void insert(int key) { 
	       root = insertRec(root, key); 
	    }
	
	public static void main(String[] args) { 
		 
		KthSamllestEleInBST tree = new KthSamllestEleInBST(); 
  
        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 

        Node1 node = tree.kthSmallest(tree.root, 2);
        System.out.println(node.key);
    } 
}
