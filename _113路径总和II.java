package 学习;

import java.util.ArrayList;
import java.util.List;

public class _113路径总和II {

    public static void main(String[] args) {
        TreeNode z = new TreeNode(5);
        z.left = new TreeNode(8);
        z.right = new TreeNode(8);
        z.left.left = new TreeNode(11);
        z.left.left.left = new TreeNode(7);
        z.left.left.right = new TreeNode(8);
        z.right.right = new TreeNode(18);
        _113路径总和II k = new _113路径总和II();
        k.pathSum(z,31);
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

       int count = 0;

       List<Integer> c = new ArrayList<>();
       List<List<Integer>> result = new ArrayList<>();

    public  List<List<Integer>> pathSum(TreeNode root, int targetSum) {



        findT(root,targetSum);
          return result;
        }

        public  void  findT(TreeNode root, int targetSum){

          count = root.val;
            targetSum = targetSum - count;
            c.add(count);
            if (root.right == null && root.left == null&& targetSum !=0){
                return;
            }

            if (targetSum==0&&root.right==null&& root.left == null){
                List<Integer> k = new ArrayList<>();
               k.addAll(c);
                result.add(k);
                return;
            }
            if (root.left!= null){
                findT(root.left,targetSum);
                c.remove(c.size()-1);
            }
            if (root.right != null){
                findT(root.right,targetSum);
                c.remove(c.size()-1);

            }


        }
}
