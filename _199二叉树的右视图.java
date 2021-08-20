package 学习;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _199二叉树的右视图 {


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


        public List<Integer> rightSideView(TreeNode root) {



          if (root == null){
              return new ArrayList<>();
          }
          List<List<Integer>> result = new ArrayList<>();
          List<Integer> result1 = new ArrayList<>();
            Deque<TreeNode> c = new ArrayDeque<>();
            c.offer(root);
            while (!c.isEmpty()){

                int len = c.size();
                List<Integer> k = new ArrayList<>();
                while (len>0){
                    TreeNode poll = c.poll();
                    k.add(poll.val);
                    if (poll.left != null){
                        c.offer(poll.left);
                    }
                    if (poll.right != null){
                        c.offer(poll.right);
                    }

                    len--;

                }
                result.add(k);
            }
            for (int i = 0; i <result.size() ; i++) {
                result1.add(result.get(i).get(result.get(i).size() - 1));
            }
      return result1;
      }

}
