package Tree;

import java.util.*;

public class TreeTraversalsIterative {
    class Pair {
        Node node;
        int task;

        public Pair(Node node) {
            this.node = node;
            task = 1;
        }
    }

    Node root;

    /*
     * Inorder traversal of Binary tree
     * T.C: O(n)
     * S.C: O(n)
     */
    void inorder() {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            /*
             * Add all root + left child elements until any node
             * left child is null
             */
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            /*
             * If any node left child is null, pop last element
             * and print
             */
            curr = stack.pop();
            System.out.print(curr.key + " ");

            // Add current node right child element
            curr = curr.right;
        }
    }

    // An iterative process to print PreOrder traversal of Binary tree
    void preorder() {

        // Base Case
        if (root == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node curr = stack.pop();
            System.out.print(curr.key + " ");

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }

        }
    }

    /*
     * An iterative process to print PostOrder traversal of Binary tree
     * using one Stack
     */
    void postOrder() {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        Node current = root;

        while (!stack.isEmpty() || current != null) {

            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.key + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.key + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }

    }

    /*
     * An iterative process to print PostOrder traversal of Binary tree
     * using Two Stack
     */
    void postOrderTwoStack() {
        if (root == null)
            return;

        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.push(root);

        while (!stack1.isEmpty()) {

            Node curr = stack1.pop();
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }

            stack2.push(curr);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().key + " ");
        }

    }

    /* Given a binary tree, print its nodes in levelOrder */
    void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");

            /* Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /* Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    /*
     * Inorder traversal of Binary tree
     * T.C: O(n)
     * S.C: O(n)
     * Qs: https://www.scaler.com/academy/mentee-dashboard/class/47562/assignment/
     * problems/214?navref=cl_tt_lst_sl
     */
    public ArrayList<Integer> inorderTraversal(Node A) {
        // To store ans list
        ArrayList<Integer> list = new ArrayList<Integer>();

        /* Define stack to sotre Pair of node and task */
        Stack<Pair> st = new Stack<Pair>();
        /* Add root node with task 1 in Stack */
        Pair rootPair = new Pair(A);
        st.push(rootPair);

        while (st.size() > 0) {
            Pair top = st.peek();
            /* Based on Pair task update the stack */
            /*
             * If task is 1 then for inorder:
             * 1. Increase task by 1
             * 2. Add left child of current stack top node
             */
            if (top.task == 1) {
                top.task++;
                if (top.node.left != null) {
                    Pair temp = new Pair(top.node.left);
                    st.push(temp);
                }
            }
            /*
             * If task is 2:
             * Add top stack node value to ans list
             */
            else if (top.task == 2) {
                top.task++;
                list.add(top.node.key);
            }
            /*
             * If task 3:
             * Add right child of current stack top node
             */
            else if (top.task == 3) {
                top.task++;
                if (top.node.right != null) {
                    Pair temp = new Pair(top.node.right);
                    st.push(temp);
                }
            }
            /*
             * When node task is 4:
             * pop node element as its all action done
             */
            else {
                st.pop();
            }
        }

        return list;
    }

    public static void main(String args[]) {

        /*
         * creating a binary tree and entering
         * the nodes
         */
        TreeTraversalsIterative tree = new TreeTraversalsIterative();

        /*
         * Constructed binary tree is
         * 1
         * / \
         * 2 3
         * / \
         * 4 5
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /*
         * Constructed binary tree is
         * 10
         * / \
         * 5 30
         * / \ \
         * -2 6 40
         * \ \
         * 2 8
         * /
         * -1
         */
        // tree.root = new Node(10);
        // tree.root.left = new Node(5);
        // tree.root.right = new Node(30);
        // tree.root.right.right = new Node(40);
        // tree.root.left.left = new Node(-2);
        // tree.root.left.left.right = new Node(2);
        // tree.root.left.left.right.left = new Node(-1);
        // tree.root.left.right = new Node(6);
        // tree.root.left.right.right = new Node(8);

        System.out.println("Inorder iterative Traversal:");
        tree.inorder();
        System.out.println("\nPreorder iterative Traversal:");
        tree.preorder();
        System.out.println("\nPostorder iterative Traversal:");
        tree.postOrderTwoStack();
        System.out.println("\nLevelorder iterative Traversal:");
        tree.levelOrder();
    }
}
