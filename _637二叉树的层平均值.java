package 学习;

import hashmap.T;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _637二叉树的层平均值 {


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

        public List<Double> averageOfLevels(TreeNode root) {


          List<Double> result = new ArrayList<>();

            Deque<TreeNode> c = new ArrayDeque<>();
            c.offer(root);

            while (!c.isEmpty()){
                double len = c.size();
                double count = 0;

                double t = len;
                while (len > 0){
                    TreeNode poll = c.poll();
                    count += poll.val;
                    if (poll.left != null){
                        c.offer(poll.left);
                    }
                    if (poll.right != null){

                        c.offer(poll.right);
                    }
                    len --;
                }
                result.add(count/t);
            }
          return result;
        }

}
