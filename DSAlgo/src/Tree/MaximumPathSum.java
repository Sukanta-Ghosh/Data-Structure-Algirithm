package Tree;

/*leafToleaf()*/
class Res {
	int val;
}

public class MaximumPathSum {
	// Max Sum Path V2
	/*
	 * T.C: O(n)
	 * S.C: O(n)
	 * Qs:
	 * https://www.scaler.com/academy/mentee-dashboard/class/70843/homework/problems
	 * /15?navref=cl_tt_nv
	 */
	/*
	 * maxSum global variable is used to store
	 * max sum can get from binary tree
	 */
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(Node A) {
		helper(A);
		return maxSum;
	}

	public int helper(Node A) {
		if (A == null) {
			return 0;
		}

		int left = helper(A.left);
		int right = helper(A.right);

		/*
		 * comparing and update global var with present
		 * node + left and right child value
		 */
		maxSum = Math.max(maxSum, Math.max(A.key, A.key + left + right));

		/*
		 * Here comparing b/w present node value and
		 * present node value + max b/w left child and right child
		 * total value
		 */
		return Math.max(A.key, A.key + Math.max(left, right));
	}
	// Max Sum Path V2 //

	Node root;

	public int nodeToNodeUtil(Node root, Res res) {

		if (root == null)
			return 0;

		int l = nodeToNodeUtil(root.left, res);
		int r = nodeToNodeUtil(root.right, res);

		int temp = Math.max(Math.max(l, r) + root.key, root.key);
		int ans = Math.max(temp, l + r + root.key);

		res.val = Math.max(res.val, ans);

		return temp;
	}

	int nodeToNode() {

		Res res = new Res();
		res.val = Integer.MIN_VALUE;

		// Compute and return result
		nodeToNodeUtil(root, res);
		return res.val;
	}

	public int leafToLeafUtil(Node root, Res res) {

		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.key;

		int l = leafToLeafUtil(root.left, res);

		int r = leafToLeafUtil(root.right, res);

		if (root.left != null && root.right != null) {

			res.val = Math.max(res.val, l + r + root.key);

			return Math.max(l, r) + root.key;
		}

		// return (root.left == null) ? r + root.key : l + root.key;
		return l + r + root.key;

	}

	int leafToLeaf() {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		leafToLeafUtil(root, res);
		return res.val;
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering
		 * the nodes
		 */
		MaximumPathSum tree = new MaximumPathSum();

		/*
		 * Constructed binary tree is
		 * 10
		 * / \
		 * 2 10
		 * / \ \
		 * 20 1 -25
		 * / \
		 * 3 4
		 */
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(-25);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.left = new Node(4);

		System.out.println("Node to Node: " + tree.nodeToNode());

		System.out.println("Leaf to Leaf: " + tree.leafToLeaf());

	}
}
