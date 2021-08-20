package 学习;

public class _237删除链表中的节点 {


//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

        public void deleteNode(ListNode node) {

         node.val = node.next.val;
         node.next = node.next.next;
        }

}
