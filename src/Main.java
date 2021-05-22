/*   Created by IntelliJ IDEA.
 *   Author: Kuldeep Singh (kuldeep506)
 *   Date: 18-05-2021
 *   Time: 04:40 PM
 *   File: Main.java
 */
public class Main {
    public static void main(String[] args) {
        AVLTree avl=new AVLTree();
        avl.insert(10);
        avl.insert(30);
        avl.insert(20);
        avl.inOrderTraversal();
    }
}
