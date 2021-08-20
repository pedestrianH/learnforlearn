package 学习;

import java.util.*;

public class _107二叉树的层序遍历II {


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


        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>>  result = new ArrayList<>();


            if (root == null){
                return new ArrayList<>();
            }
            //右左入栈有count计数
            int count  = 0;
            Deque<TreeNode> c = new LinkedList<>();
            c.add(root);
            while (!c.isEmpty()){
                        int len = c.size();

                        List<Integer> t = new ArrayList<>();
                        while (len >0){
                            TreeNode poll = c.poll();
                            t.add(poll.val);
                        if (poll.left!=null){
                            c.offer(poll.left);
                        }
                        if (poll.right != null){
                            c.offer(poll.right);
                        }
                        len--;
                        }
                        result.add(t);

            }
            List<List<Integer>> result1 = new ArrayList<>();
            for (int i = result.size() -1; i>=0 ; i--) {
                result1.add(result.get(i));
            }


            return result1;
        }

}
