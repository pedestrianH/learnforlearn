package 学习;

public class _203移除链表元素 {


//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode removeElements(ListNode head, int val) {

          ListNode kNode  = new ListNode();
          kNode.next = head;
          ListNode c= kNode;
          while (c.next != null){
              if (c.next.val == val){
                  c.next = c.next.next;

              }
              else {
                c = c.next;
              }
          }



return  kNode.next;

        }

}
