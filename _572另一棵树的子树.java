package 学习;

import hashmap.T;

import java.util.Stack;

public class _572另一棵树的子树 {


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

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null){
                return true;
            }
            if (root == null || subRoot == null ){
return false;
            }


            return  findRoot(root,subRoot) || isSubtree(root.left,subRoot) ||isSubtree(root.right,subRoot);
        }
        public boolean findRoot(TreeNode root, TreeNode subRoot){


            Stack<TreeNode> c = new Stack<>();
            c.push(root);
            c.push(subRoot);
            while (!c.isEmpty()){

                TreeNode rightNode = c.pop();
                TreeNode leftNode = c.pop();

                if (rightNode == null && leftNode == null){
                    continue;
                }
                if ((rightNode == null&& leftNode!=null )|| (rightNode != null && leftNode == null) || rightNode.val != leftNode.val){
                    return  false;
                }
                c.push(leftNode.left);
                c.push(rightNode.left);
                c.push(leftNode.right);
                c.push(rightNode.right);

            }
            return true;


        }

}
