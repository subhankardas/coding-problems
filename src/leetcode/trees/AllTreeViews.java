package leetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AllTreeViews {

    public static void main(String[] args) {
        ATVBinaryTree binaryTree = new ATVBinaryTree();

        ATVNode root = binaryTree.insertLeft(null, 1);
        ATVNode n2 = binaryTree.insertLeft(root, 2);
        ATVNode n3 = binaryTree.insertRight(root, 3);

        binaryTree.insertLeft(n2, 4);
        binaryTree.insertRight(n2, 5);

        binaryTree.insertLeft(n3, 6);
        binaryTree.insertRight(n3, 7);

        System.out.print("Binary Tree(BFS): ");
        binaryTree.printBFS(root);
        System.out.println();

        System.out.print("Binary Tree(DFS - PreOrder): ");
        binaryTree.printPreOrder(root);
        System.out.println();

        System.out.print("Binary Tree(DFS - InOrder): ");
        binaryTree.printInOrder(root);
        System.out.println();

        System.out.print("Binary Tree(DFS - PostOrder): ");
        binaryTree.printPostOrder(root);
        System.out.println();

        System.out.print("Right Side View: ");
        binaryTree.printRightView(root);

        System.out.print("Left Side View: ");
        binaryTree.printLeftView(root);
    }

}

class ATVNode {
    int val;
    ATVNode left;
    ATVNode right;
}

class ATVBinaryTree {

    ATVNode root;

    public ATVNode insertLeft(ATVNode root, int val) {
        if (root == null) {
            root = new ATVNode();
            root.val = val;
            root.left = null;
            root.right = null;
        } else {
            ATVNode newN = new ATVNode();
            newN.val = val;
            root.left = newN;
            return root.left;
        }
        return root;
    }

    public ATVNode insertRight(ATVNode root, int val) {
        if (root == null) {
            root = new ATVNode();
            root.val = val;
            root.left = null;
            root.right = null;
        } else {
            ATVNode newN = new ATVNode();
            newN.val = val;
            root.right = newN;
            return root.right;
        }
        return root;
    }

    public void printBFS(ATVNode root) {
        if (root == null) {
            return;
        }
        Queue<ATVNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ATVNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public void printPreOrder(ATVNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printInOrder(ATVNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public void printPostOrder(ATVNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public void printRightView(ATVNode root) {
        if (root == null) {
            return;
        }
        List<Integer> rightLeafs = new ArrayList<>();
        rightSideViewPreOrder(root, rightLeafs, 0);
        System.out.println(rightLeafs);
    }

    // Modified DFS PreOrder Traversal - To find the rightmost nodes in the tree.
    // Traverse the right node first and then traverse the left node.
    // For each level, add the node if it is the rightmost node.
    // 1 --> right[0]
    // 2 3 --> right[1]
    // 4 5 6 7 --> right[2]
    private void rightSideViewPreOrder(ATVNode root, List<Integer> rightLeafs, int level) {
        if (root == null) { // bottom of the tree
            return;
        }

        if (level == rightLeafs.size()) { // rightleafs[level] == null i.e. we have reached the rightmost node
            rightLeafs.add(root.val);
        }

        rightSideViewPreOrder(root.right, rightLeafs, level + 1); // see the right node
        rightSideViewPreOrder(root.left, rightLeafs, level + 1); // see the left node is the right node
    }

    public void printLeftView(ATVNode root) {
        if (root == null) {
            return;
        }
        List<Integer> leftLeafs = new ArrayList<>();
        leftSideViewPreOrder(root, leftLeafs, 0);
        System.out.println(leftLeafs);
    }

    private void leftSideViewPreOrder(ATVNode root, List<Integer> leftLeafs, int level) {
        if (root == null) { // bottom of the tree
            return;
        }
        if (level == leftLeafs.size()) { // leftleafs[level] == null i.e. we have reached the leftmost node
            leftLeafs.add(root.val);
        }
        leftSideViewPreOrder(root.left, leftLeafs, level + 1); // see the left node
        leftSideViewPreOrder(root.right, leftLeafs, level + 1); // see the right node is the left node
    }

}