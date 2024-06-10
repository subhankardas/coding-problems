package leetcode.leetcode_75;

/**
 * Problem: Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * RUNTIME: 0 ms Beats 100.00% of users with Java
 * MEMORY: 42.27 MB Beats 80.60% of users with Java
 */
public class LT_104_Maximum_Depth_Binary_Tree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        BTNode root = binaryTree.insert(null, 3);
        binaryTree.insert(root, 9);
        BTNode root2 = binaryTree.insert(root, 20);
        binaryTree.insert(root2, 15);
        binaryTree.insert(root2, 7);

        System.out.print("Binary Tree: ");
        binaryTree.print(root);

        System.out.print("\nMaximum Depth: ");
        System.out.println(binaryTree.maxDepth(root));
    }

}

class BTNode {
    int val;
    BTNode left;
    BTNode right;
}

class BinaryTree {

    BTNode root;

    public BTNode insert(BTNode root, int val) {
        if (root == null) {
            root = new BTNode();
            root.val = val;
            root.left = null;
            root.right = null;
        } else {
            if (root.left == null) {
                root.left = insert(root.left, val);
                return root.left;
            } else if (root.right == null) {
                root.right = insert(root.right, val);
                return root.right;
            }
        }
        return root;
    }

    public int maxDepth(BTNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthDFS(BTNode cur, int depth) {
        if (cur == null) {
            return depth;
        }
        if (cur.left != null) {
            return maxDepthDFS(cur.left, depth + 1);
        } else if (cur.right != null) {
            return maxDepthDFS(cur.right, depth + 1);
        }
        return depth;
    }

    public void print(BTNode cur) {
        if (cur == null) {
            return;
        }
        System.out.print(cur.val + " ");
        print(cur.left);
        print(cur.right);
    }

}