package 学习;

import hashmap.T;

public class _617合并二叉树 {

    public static void main(String[] args) {
/*
* [1,3,2,5]
[2,1,3,null,4,null,7]*/
TreeNode node = new TreeNode(1);
node.left = new TreeNode(3);
node.left.left = new TreeNode(3);
node.right = new TreeNode(5);
TreeNode k = new TreeNode(2);
k.left = new TreeNode( 1);
k.right = new TreeNode(3);
k.left.right = new TreeNode(1);
k.right.right = new TreeNode(1);
//        System.out.println(mergeTrees(node, k).val);
//        System.out.println(result.val);
    }
//      Definition for a binary tree node.
      public static class TreeNode {
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

     TreeNode result ;

        public  TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null){
                return root2;
            }
            if (root2 == null){
                return root1;
            }
            TreeNode result = new TreeNode(root1.val+root2.val);
            result.left = mergeTrees(root1.left,root2.left);
            result.right =  mergeTrees(root1.right,root2.right);


           return result;
        }



}
