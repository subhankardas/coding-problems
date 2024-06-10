package leetcode.leetcode_75;

import java.util.Stack;

/**
 * Problem: Consider all the leaves of a binary tree, from left to right order,
 * the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9,
 * 8).
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 * 
 * Example 1:
 * Input:
 * root1 = [3,5,1,6,2,9,8,null,null,7,4],
 * root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 
 * Output: true
 * 
 * LEVEL: Easy
 * RUNTIME: 0 ms Beats 100.00% of users with Java
 * MEMORY: 41.13 MB Beats 72.08% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_872_Leaf_Similar_Trees {

    public static void main(String[] args) {
        // TEST CASE 1
        BinaryTree1 tree1 = new BinaryTree1();
        BTNode1 root1 = tree1.insert(null, 3);
        BTNode1 n5 = tree1.insert(root1, 5);
        BTNode1 n1 = tree1.insert(root1, 1);

        tree1.insert(n5, 6);
        BTNode1 n2 = tree1.insert(n5, 2);

        tree1.insert(n2, 7);
        tree1.insert(n2, 4);

        tree1.insert(n1, 9);
        tree1.insert(n1, 8);

        System.out.println("Binary Tree 1: ");
        tree1.print(root1);

        BinaryTree1 tree2 = new BinaryTree1();
        BTNode1 root2 = tree2.insert(null, 3);
        BTNode1 n5_2 = tree2.insert(root2, 5);
        BTNode1 n1_2 = tree2.insert(root2, 1);

        tree2.insert(n5_2, 6);
        tree2.insert(n5_2, 7);

        tree2.insert(n1_2, 4);
        BTNode1 n2_2 = tree2.insert(n1_2, 2);

        tree2.insert(n2_2, 9);
        tree2.insert(n2_2, 8);

        System.out.println("\nBinary Tree 2: ");
        tree2.print(root2);

        System.out.println("\nLeaf Similar Trees: " + tree1.leafSimilar(root1, root2));

        // TEST CASE 2
        tree1 = new BinaryTree1();
        root1 = tree1.insert(null, 1);
        tree1.insert(root1, 2);
        tree1.insert(root1, 200);

        tree2 = new BinaryTree1();
        root2 = tree2.insert(null, 1);
        tree2.insert(root2, 2);
        tree2.insert(root2, 200);

        System.out.println("\nBinary Tree 1: ");
        tree1.print(root1);

        System.out.println("\nBinary Tree 2: ");
        tree2.print(root2);

        System.out.println("\nLeaf Similar Trees: " + tree1.leafSimilar(root1, root2));
    }

}

class BTNode1 {
    int val;
    BTNode1 left;
    BTNode1 right;
}

class BinaryTree1 {

    BTNode1 root;

    public BTNode1 insert(BTNode1 root, int val) {
        if (root == null) {
            root = new BTNode1();
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

    public boolean leafSimilar(BTNode1 root1, BTNode1 root2) {
        if (root1 == null && root2 == null) { // both are null i.e. both trees are empty
            return true;
        }
        if (root1 == null || root2 == null) { // one is null i.e. one tree is empty
            return false;
        }

        Stack<Integer> leafs1 = new Stack<>();
        setLeafs(root1, leafs1); // set all leaf nodes of tree1 in stack

        Stack<Integer> leafs2 = new Stack<>();
        setLeafs(root2, leafs2); // set all leaf nodes of tree2 in stack

        if (leafs1.size() != leafs2.size()) { // both trees have different number of leaf nodes
            return false;
        }

        while (!leafs1.isEmpty()) {
            int n1 = leafs1.pop();
            int n2 = leafs2.pop();
            if (n1 != n2) { // both trees have different leaf nodes
                return false;
            }
        }

        return true; // both trees have same leaf nodes
    }

    public void setLeafs(BTNode1 root, Stack<Integer> leafs) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafs.push(root.val);
        }

        setLeafs(root.left, leafs);
        setLeafs(root.right, leafs);
    }

    public void print(BTNode1 cur) {
        if (cur == null) {
            return;
        }
        System.out.print(cur.val + " ");
        print(cur.left);
        print(cur.right);
    }

}