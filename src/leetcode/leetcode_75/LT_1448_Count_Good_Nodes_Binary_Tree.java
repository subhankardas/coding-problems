package leetcode.leetcode_75;

/**
 * Problem: Given a binary tree root, a node X in the tree is named good if in
 * the path from root to X there are no nodes with a value greater than X.
 * 
 * Return the number of good nodes in the binary tree.
 * 
 * Level: Medium
 * Runtime: 2 ms Beats 84.31%
 * Memory: 52.45 MB Beats 28.21%
 * 
 * @author Subhankar Das
 */
public class LT_1448_Count_Good_Nodes_Binary_Tree {

    public static void main(String[] args) {
        BinaryTree3 binaryTree = new BinaryTree3();

        BTNode3 root = binaryTree.insertLeft(null, 3);
        BTNode3 n1 = binaryTree.insertLeft(root, 1);
        BTNode3 n4 = binaryTree.insertRight(root, 4);

        binaryTree.insertLeft(n1, 3);

        binaryTree.insertLeft(n4, 1);
        binaryTree.insertRight(n4, 5);

        System.out.print("Binary Tree: ");
        binaryTree.print(root);

        System.out.println("\nGood Nodes: " + binaryTree.goodNodes(root));
    }

}

class BTNode3 {
    int val;
    BTNode3 left;
    BTNode3 right;
}

class BinaryTree3 {

    BTNode3 root;

    public BTNode3 insertLeft(BTNode3 root, int val) {
        if (root == null) {
            root = new BTNode3();
            root.val = val;
            root.left = null;
            root.right = null;
        } else {
            BTNode3 newN = new BTNode3();
            newN.val = val;
            root.left = newN;
            return root.left;
        }
        return root;
    }

    public BTNode3 insertRight(BTNode3 root, int val) {
        if (root == null) {
            root = new BTNode3();
            root.val = val;
            root.left = null;
            root.right = null;
        } else {
            BTNode3 newN = new BTNode3();
            newN.val = val;
            root.right = newN;
            return root.right;
        }
        return root;
    }

    int count;

    public int goodNodes(BTNode3 root) {
        if (root == null) {
            return 0;
        }
        count = 0;
        dfs(root, root.val);
        return count;
    }

    public int dfs(BTNode3 root, int max) {
        if (root == null) {
            return 0;
        }
        if (root.val >= max) {
            count++;
        }
        max = Math.max(max, root.val);
        dfs(root.left, max);
        dfs(root.right, max);
        return count;
    }

    public void print(BTNode3 cur) {
        if (cur == null) {
            return;
        }
        System.out.print(cur.val + " ");
        print(cur.left);
        print(cur.right);
    }

}