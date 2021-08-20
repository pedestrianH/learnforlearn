package 学习;

public class _226翻转二叉树 {


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
            public TreeNode invertTree(TreeNode root) {
                if (root == null){
                    return null;
                }
                    if (root.left == null && root.right == null){
                        return  root;
                    }




                    if (root.right != null){
                        invertTree(root.right);

                    }
                    if (root.left != null){
                        invertTree(root.left);

                    }
                    TreeNode c= root.left;
                    root.left = root.right;
                    root.right = c;
          return  root;
        }

}
