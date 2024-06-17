package leetcode.leetcode_75;

/**
 * Problem: You are given the root of a binary search tree (BST) and an integer
 * val.
 * Find the node in the BST that the node's value equals val and return the
 * subtree rooted with that node. If such a node does not exist, return null.
 * 
 * Level: Easy
 * Runtime: 0 ms Beats 100.00%
 * Memory: 45.25 MB Beats 28.81%
 * 
 * @author Subhankar Das
 */
public class LT_700_Search_Binary_Search_Tree {

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        BSTNode root = tree.insertLeft(null, 4);

        BSTNode n2 = tree.insertLeft(root, 2);
        tree.insertRight(root, 7);

        tree.insertLeft(n2, 1);
        tree.insertRight(n2, 3);

        System.out.print("Binary Search Tree: ");
        tree.print(root);

        System.out.print("\nSearch BST: ");
        tree.print(BSTree.searchBST(root, 2));
    }
}

class BSTNode {
    int val;
    BSTNode left;
    BSTNode right;
}

class BSTree {

    BSTNode root;

    public BSTNode insertLeft(BSTNode root, int val) {
        if (root == null) {
            root = new BSTNode();
            root.val = val;
            root.left = null;
            root.right = null;
        } else {
            BSTNode newN = new BSTNode();
            newN.val = val;
            root.left = newN;
            return root.left;
        }
        return root;
    }

    public BSTNode insertRight(BSTNode root, int val) {
        if (root == null) {
            root = new BSTNode();
            root.val = val;
            root.left = null;
            root.right = null;
        } else {
            BSTNode newN = new BSTNode();
            newN.val = val;
            root.right = newN;
            return root.right;
        }
        return root;
    }

    public static BSTNode searchBST(BSTNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public void print(BSTNode cur) {
        if (cur == null) {
            return;
        }
        System.out.print(cur.val + " ");
        print(cur.left);
        print(cur.right);
    }

}