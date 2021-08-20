package 学习;

public class _110平衡二叉树 {


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
        public boolean isBalanced(TreeNode root) {
          return getHeight(root) != -1;
        }
        public int getHeight(TreeNode node){
          if (node == null){
              return 0;
          }
            int heightLeft = getHeight(node.left);
          if (heightLeft == -1){
              return -1;
          }
            int heightRight = getHeight(node.right);
          if (heightRight == -1){
              return -1;
          }
          if ( Math.abs(heightLeft-heightRight)>1){
return -1;
          }
          return  Math.max(heightLeft,heightRight)+1 ;
        }

}
