package com.algo.learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Leetcode 105
public class BinaryTreeFromInOrdPreOrd {

    public class TreeNode {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inOrderValToIndex = new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            inOrderValToIndex.putIfAbsent(inorder[i],i);
        }
        return buildTree(preorder,
                0,0,inorder.length-1,
                inOrderValToIndex);

    }

    private TreeNode buildTree(int[] preorder,int preorderId,int inorderStart,int inorderEnd, Map<Integer,Integer> integerIntegerMap) {
        if (preorderId > preorder.length-1 || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderId]);
        int middle = integerIntegerMap.get(preorder[preorderId]);
        root.left = buildTree(preorder,preorderId+1,inorderStart,middle-1,integerIntegerMap);
        root.right = buildTree(preorder,preorderId+(middle-inorderStart)+1,middle+1,inorderEnd,integerIntegerMap);
        return root;
    }



    public static void main(String[] args) {
        BinaryTreeFromInOrdPreOrd binaryTreeFromInOrdPreOrd = new BinaryTreeFromInOrdPreOrd();
        System.out.println(binaryTreeFromInOrdPreOrd.buildTree(new int[] {3,9,20,15,7},new int [] {9,3,15,20,7}));
    }

}
