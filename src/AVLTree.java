/*   Created by IntelliJ IDEA.
 *   Author: Kuldeep Singh (kuldeep506)
 *   Date: 18-05-2021
 *   Time: 04:40 PM
 *   File: AVLTree.java
 */
public class AVLTree {
    private AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    /**
     * method to insert value in AVL Tree.
     */
    public void insert(int data) {
        root = (insert(root, data));
    }

    private AVLNode insert(AVLNode node, int data) {
        if (node == null) {
            return new AVLNode(data);
        }
        if (node.data > data) {
            node.left = (insert(node.left, data));
        }
        if (node.data < data) {
            node.right = (insert(node.right, data));
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return balance(node,data);
    }


    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    /**
     * method to balance the tree after new node addition.
     */
    public AVLNode balance(AVLNode node,int data) {
        if (node == null)
            return null;
        // case1. if tree is left heavy and data is less than node.left.data
        /**
         * ex-           30
         *             20
                     10
         */
        if(isLeftHeavy(node) && data<node.left.data)
            return rightRotation(node);

        //case1.2. if tree is left heavy and data is greater than node.left.data
        /**
         *           30
         *       20
         *         25
         */
        if (isLeftHeavy(node)&&data>node.left.data){
            node.left=leftRotation(node.left);
            return rightRotation(node);
        }
        // case2. if tree is right heavy and data is greater than node.right.data
        /**
         * ex-   10
         *          20
         *             30
         */
        if (isRightHeavy(node)&&data>node.right.data){
            return leftRotation(node);
        }
        // case2.1 if tree is right heavy and data is less than node.right.data
        /**
         * ex-     10
         *           20
         *         15
         */
        if (isRightHeavy(node)&&data<node.right.data){
            node.right=rightRotation(node.right);
            return leftRotation(node);
        }
        return node;
    }

    /**
     * method to calculate balance factor
     */
    private int balancedFactor(AVLNode node) {
        if (node == null) {
            return 0;
        } else
            return height(node.left) - height(node.right);
    }

    private boolean isLeftHeavy(AVLNode node) {
        return (balancedFactor(node) > 1);
    }

    private boolean isRightHeavy(AVLNode node) {
        return (balancedFactor(node) < -1);
    }

    //right rotation
    private AVLNode rightRotation(AVLNode node) {
        AVLNode temp = node.left;
        AVLNode t2=temp.right;

        temp.right = node;
        node.left=t2;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }
    //left rotation
    private AVLNode leftRotation(AVLNode node) {
        AVLNode temp = node.right;
        AVLNode t2=temp.left;

        temp.left = node;
        node.right=t2;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }


    //inorder traversal
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(AVLNode node) {
        if (node == null) {
            return;
        } else {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }
}

