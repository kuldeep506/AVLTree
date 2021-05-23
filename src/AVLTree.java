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

    private AVLNode insert(AVLNode root, int data) {
        if (root == null) {
            return new AVLNode(data);
        }
        if (root.data > data) {
            root.left = (insert(root.left, data));
        }
        if (root.data < data) {
            root.right = (insert(root.right, data));
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return balance(root);
    }

    /**
     * height
     */
    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    /**
     * formula to balance the tree
     */
    public AVLNode balance(AVLNode node) {
        if (node == null)
            return null;
        // if tree is left heavy.
        if (isLeftHeavy(node)) {
            //if left child of node is right heavy.
            if (balancedFactor(node.left) < 0) {
                root.left=leftRotation(node.left);
                return rightRotation(node.right);
            }
            //if tree is left skew tree .
//            if (balancedFactor(node.left) > 0) {
//                return rightRotation(node.left);
//            }
        }
        // if tree is right heavy.
        if (isRightHeavy(node)) {
            //if right child of node is left heavy.
            if (balancedFactor(node.right) > 0) {
                root.right=rightRotation(node.right);
                return leftRotation(node.left);
            }
            //if tree is right skew tree.
//            if (balancedFactor(node.right) < 0) {
//                return leftRotation(node.left);
//            }
        }
        return node;
    }

    /**
     * formula for balance factor
     *
     * @param node
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

    /**
     * left and right rotations
     */
    private AVLNode rightRotation(AVLNode node) {
        AVLNode temp = node.left;
        AVLNode t2=temp.right;

        temp.right = node;
        node.left=t2;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }

    private AVLNode leftRotation(AVLNode node) {
        AVLNode temp = node.right;
        AVLNode t2=temp.left;

        temp.left = node;
        node.right=t2;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }


    /**
     * inorder traversal
     */
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

