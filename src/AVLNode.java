/*   Created by IntelliJ IDEA.
 *   Author: Kuldeep Singh (kuldeep506)
 *   Date: 18-05-2021
 *   Time: 04:41 PM
 *   File: AVLNode.java
 */

public class AVLNode {
    public int data;
    public int height;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "data=" + data +
                ", height=" + height +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
