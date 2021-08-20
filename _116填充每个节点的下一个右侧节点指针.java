package 学习;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _116填充每个节点的下一个右侧节点指针 {


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}



        public Node connect(Node root) {
            if (root == null){
                return null;
            }
            Deque<Node> c = new ArrayDeque<>();
            c.offer(root);
            while (!c.isEmpty()){
                int len =c.size() ;
                    while (len > 0){
                        Node poll = c.poll();
                        if (len >1){
                            poll.next = c.peek();

                        }else if (len == 1){
                            poll.next = null;
                        }

                       if (poll.left != null){
                           c.offer(poll.left);
                       }
                       if (poll.right != null){
                           c.offer(poll.right);
                       }
                        len--;
                    }

            }
          return root;
        }

}
