package 学习;

public class _404左叶子之和 {


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
        public int sumOfLeftLeaves(TreeNode root) {

           return findzui(root);
        }






        public int findzui(TreeNode root){
           if (root == null){
               return 0;
           }
           int k = 0;
           if (root.left!= null && root.left.right == null && root.left.left == null){
                k = root.left.val;
           }
            int findzui = findzui(root.left);
            int findzui1 = findzui(root.right);
            return findzui+findzui1 + k;
        }
}
