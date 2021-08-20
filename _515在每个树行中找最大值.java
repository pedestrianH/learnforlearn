package 学习;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _515在每个树行中找最大值 {
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
        public List<Integer> largestValues(TreeNode root) {
          if (root == null){
              return  new ArrayList<>();
          }





          List<Integer> result = new ArrayList<>();
            Deque<TreeNode> c = new ArrayDeque<>();
            c.offer(root);
            while (!c.isEmpty()){
                int len = c.size();
                int count = Integer.MIN_VALUE;
                while (len > 0 ){
                    TreeNode poll = c.poll();
                    count = count > poll.val ? count : poll.val;
                    if (poll.left != null){
                        c.offer(poll.left);
                    }
                    if (poll.right != null){
                        c.offer(poll.right);
                    }
                    len --;
                }
                result.add(count);
            }
          return result;
        }
}
