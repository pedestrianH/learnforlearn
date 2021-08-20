package 学习;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _111二叉树的最小深度 {

    public static void main(String[] args) {
        Scanner k =new Scanner(System.in);
        int[] t = new int[128];
        int index = 0;
        while (k.hasNext()){

            t[index] = k.nextInt();
            index++;
            System.out.println(t[index-1]);
        }

    }
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


        public int minDepth(TreeNode root) {

                if (root == null){
                    return 0;
                }
            Deque<TreeNode> c = new ArrayDeque<>();
            c.offer(root);
            int count = 0;
            while (!c.isEmpty()){
                count++;

                int len =c.size();
//                if (count > 0 && len != count*2 && c.peek().left==null &&c.peek().right == null ){
//                    return count;
//                }
                while (len >0){
                    TreeNode poll = c.poll();
                       if (poll.right == null && poll.left == null){
                           return  count;
                       }
                    if (poll.left != null){
                        c.offer(poll.left);
                    }
                    if (poll.right != null){
                        c.offer(poll.right);
                    }
                    len --;
                }





            }
          return  count;
        }

}
