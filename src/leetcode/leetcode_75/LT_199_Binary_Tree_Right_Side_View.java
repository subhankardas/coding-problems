package leetcode.leetcode_75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: Given the root of a binary tree, imagine yourself standing on the
 * right side of it, return the values of the nodes you can see ordered from top
 * to bottom.
 * 
 * LEVEL: Medium
 * RUNTIME: 0 ms Beats 100.00%
 * MEMORY: 42.00 MB Beats 51.41%
 * 
 * @author Subhankar Das
 */
public class LT_199_Binary_Tree_Right_Side_View {

    public static void main(String[] args) {
        BinaryTree2 binaryTree = new BinaryTree2();

        BTNode2 root = binaryTree.insertLeft(null, 1);
        BTNode2 n2 = binaryTree.insertLeft(root, 2);
        BTNode2 n3 = binaryTree.insertRight(root, 3);

        binaryTree.insertRight(n2, 5);
        binaryTree.insertRight(n3, 4);

        System.out.print("Binary Tree: ");
        binaryTree.print(root);
        System.out.println();

        System.out.print("Binary Tree: ");
        binaryTree.printBFS(root);
        System.out.println();

        System.out.print("Right Side View: ");
        List<Integer> rightSideView = binaryTree.rightSideView(root);
        System.out.println(rightSideView);
    }

}

class BTNode2 {
    int val;
    BTNode2 left;
    BTNode2 right;
}

class BinaryTree2 {

    BTNode2 root;

    public BTNode2 insertLeft(BTNode2 root, int val) {
        if (root == null) {
            root = new BTNode2();
            root.val = val;
            root.left = null;
            root.right = null;
        } else {
            BTNode2 newN = new BTNode2();
            newN.val = val;
            root.left = newN;
            return root.left;
        }
        return root;
    }

    public BTNode2 insertRight(BTNode2 root, int val) {
        if (root == null) {
            root = new BTNode2();
            root.val = val;
            root.left = null;
            root.right = null;
        } else {
            BTNode2 newN = new BTNode2();
            newN.val = val;
            root.right = newN;
            return root.right;
        }
        return root;
    }

    List<Integer> rightLeafs = new ArrayList<>();

    public List<Integer> rightSideView(BTNode2 root) {
        if (root == null) {
            return new ArrayList<>();
        }

        rightSideViewPreOrder(root, 0);
        return rightLeafs;
    }

    private void rightSideViewPreOrder(BTNode2 root, int level) {
        if (root == null) { // bottom of the tree
            return;
        }

        if (level == rightLeafs.size()) { // rightleafs[level] == null i.e. we have reached the rightmost node
            rightLeafs.add(root.val);
        }

        rightSideViewPreOrder(root.right, level + 1); // see the right node
        rightSideViewPreOrder(root.left, level + 1); // see the left node is the right node
    }

    public void printBFS(BTNode2 root) {
        if (root == null) {
            return;
        }
        Queue<BTNode2> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BTNode2 cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public void print(BTNode2 cur) {
        if (cur == null) {
            return;
        }
        System.out.print(cur.val + " ");
        print(cur.left);
        print(cur.right);
    }

}