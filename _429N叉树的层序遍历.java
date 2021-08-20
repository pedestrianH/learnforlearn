package 学习;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _429N叉树的层序遍历 {


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


        public List<List<Integer>> levelOrder(Node root) {
            if (root == null){
                return  new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            Deque<Node> c = new ArrayDeque<>();
            c.offer(root);

            while (!c.isEmpty()){
                int len = c.size();

                List<Integer> k = new ArrayList<>();
                while (len > 0){
                    Node poll = c.poll();
                    k.add(poll.val);
                    if (!poll.children.isEmpty()){
                        for (int i = 0; i < poll.children.size() ; i++) {
                            c.offer(poll.children.get(i));
                        }
                    }
                    len --;

                }
                result.add(k);
            }
            return result;
        }

}
