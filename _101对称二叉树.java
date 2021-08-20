package 学习;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _101对称二叉树 {


//      Definition for a binary tree node.
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

        public boolean isSymmetric(TreeNode root) {


            Stack<TreeNode> c= new Stack<>();

            c.push(root.left);
            c.push(root.right);

            while (!c.isEmpty()){
                TreeNode leftNode = c.pop();
                TreeNode rightNode = c.pop();

                if (leftNode == null && rightNode == null ){
                        continue;
                }
                if (leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                    return false;
                }
                c.push(leftNode.left);
                c.push(rightNode.right);
                c.push(leftNode.right);
                c.push(rightNode.left);
            }
          return true;
        }

}
