package 学习;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class _559N叉树的最大深度 {
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
        public int maxDepth(Node root) {







    if (root == null){
        return 0;
    }
            Deque<Node> c = new ArrayDeque<>();
            c.offer(root);
            int count = 0;
            while (!c.isEmpty()){
                int len = c.size();
                while (len>0){
                    Node poll = c.poll();
                    if (poll.children !=null){
                        for (int i = 0; i <poll.children.size(); i++) {
                            c.offer(poll.children.get(i));
                        }
                    }
                    len --;
                }
                count++;
            }
    return count;
        }

}
