package 学习;

import hashmap.T;

import java.util.*;

public class _513找树左下角的值 {


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

        public int findBottomLeftValue(TreeNode root) {

            List<List<Integer>> result = new ArrayList<>();
            Deque<TreeNode> c = new ArrayDeque<>();
            c.offer(root);
            while (!c.isEmpty()){
                int len = c.size();

                List<Integer> k = new ArrayList<>();
                while (len > 0 ){

                    TreeNode poll = c.poll();
                    if (poll.left!=null){
                        c.offer(poll.left);
                    }
                    if (poll.right != null){
                        c.offer(poll.right);
                    }
                    len --;
                    k.add(poll.val);
                }
                result.add(k);

            }
          return result.get(result.size()-1).get(0);
        }

}
