package 学习;

import java.util.Stack;

public class _100相同的树 {


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

        public boolean isSameTree(TreeNode p, TreeNode q) {


            Stack<TreeNode> c = new Stack<>();
            c.push(p);
            c.push(q);
            while (!c.isEmpty()){
                TreeNode rightNode = c.pop();
                TreeNode leftNode = c.pop();
                if (rightNode == null && leftNode == null){
                    continue;
                }
                if ((rightNode== null && leftNode!= null) ||( rightNode!=null && leftNode == null) || rightNode.val != leftNode.val){
                    return false;
                }

                c.push(leftNode.left);
                c.push(rightNode.left);
                c.push(leftNode.right);
                c.push(rightNode.right);

            }
          return true;
        }

}
