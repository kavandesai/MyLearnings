package com.algo.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);

        while (queue.size()>0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size -->0) {
                TreeNode node = queue.remove();
                if (node !=null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!list.isEmpty()) {
                result.add(list);
            }
        }
        return  result;

    }

    public static void main(String[] args) {

    }
}
