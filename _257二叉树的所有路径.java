package 学习;



import java.util.ArrayList;
import java.util.List;
public class _257二叉树的所有路径 {
    public static void main(String[] args) {
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
    List<String> result = new ArrayList<>();
    List<String> c = new ArrayList<>();
    //回溯递归调用左右树节点进行插入"->"
    public List<String> binaryTreePaths(TreeNode root) {
                if (root == null){
                    return null;
                }
                c.add(String.valueOf(root.val));
        if (root.right == null && root.left == null){
            String k = String.join("->", c);
            result.add(k);
            c.remove(c.size()-1);
            return result;
        }
        binaryTreePaths(root.left);
        binaryTreePaths(root.right);
        c.remove(c.size()-1);
        return result;
        }
}
