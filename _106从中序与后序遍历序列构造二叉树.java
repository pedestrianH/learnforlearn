package 学习;

import java.util.HashMap;
import java.util.Map;

public class _106从中序与后序遍历序列构造二叉树 {


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

int p = 0;//从后续遍历往前移减一
    int[] inorder;
    int[] postorder;
    Map<Integer,Integer> c = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {




            this.inorder = inorder;
            this.postorder = postorder;
            p = postorder.length -1;
            //因为要这个根据postorder尾部根节点的数值找到中序遍历的根节点索引 因此要用到
            for (int i = 0; i <inorder.length ; i++) {
                c.put(inorder[i],i);
            }
          return   k(0,p);
        }
            public TreeNode k(int left,int right){

            if (left > right){
                return null;
            }

            int val = postorder[p];
            int index =c.get(val);
            p--;
        TreeNode node = new TreeNode(val);
        //要先找这个右边的因为p为从后序遍历的最后个主次往前减少一要等到这个右边的操作全部完毕之后p减少了到了左边这里来了
                node.right = k(index+1,right);
                node.left = k(left,index-1);

                return node;
            }
}
