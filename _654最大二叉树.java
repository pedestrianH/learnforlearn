package 学习;

import hashmap.T;

public class _654最大二叉树 {


    public static void main(String[] args) {
        TreeNode treeNode = constructMaximumBinaryTree(new int[]{3, 2, 1, 13, 0, 5});
        System.out.println(treeNode.right.left.val);
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

        public static TreeNode constructMaximumBinaryTree(int[] nums) {




          TreeNode result = new TreeNode();
          tree(result,nums,0,nums.length-1);
          return  result;
        }
   static int index = 0;

        public static   void tree (TreeNode node, int[] val,int z,int y){
          int zui  = Integer.MIN_VALUE;
          int zi = 0;
            int k = 0;
            for (int i = z; i <=y ; i++) {
                    if (val[i] > zui ){
                        zui = val[i];
                        index = i;

                    }

            }
            k = index;
            node.val = zui;

            if (index - 1 <0 || index  <= z){
                node.left = null;
            }else {
                node.left = new TreeNode();
                tree(node.left,val,z,index-1);
                index = k;
            }
            if (index + 1 >= val.length || index >= y ){
                node.right = null;
            }else {
                node.right = new TreeNode();
                tree(node.right,val,index+1,y);
                index = k;

            }
        }

}
