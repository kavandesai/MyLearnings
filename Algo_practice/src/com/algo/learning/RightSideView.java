package com.algo.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RightSideView {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> elementToVisit = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        } else {
            elementToVisit.add(root);
        }
        List<Integer> list = new ArrayList<>();
        while (elementToVisit.size()>0) {
            int size = elementToVisit.size();
            TreeNode node = null;
            while (size --> 0) {
                node = elementToVisit.remove();
                if (node.left != null) {
                    elementToVisit.add(node.left);
                }
                if (node.right != null) {
                    elementToVisit.add(node.right);
                }
            }
            if (node != null) {
                list.add(node.val);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
