package 学习;

public class _19删除链表的倒数第N个结点 {


//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode removeNthFromEnd(ListNode head, int n) {
          int count = 0;
          ListNode k = head;
          while (k  != null){
              count++;
              k = k.next;
          }
            if (count <= 1){
                return null;
            }
          int index = count +1 -n;
          int c = 0;
          ListNode l = new ListNode(0);
          l.next = head;
          ListNode t = l;
          while (t.next != null){
              //下个值为要删除的节点当前的指针指向下个的下个
              if (c+1 == index){
                t.next = t.next.next;
                return l.next;
              }
              else {
                  t = t.next;
                  c ++;
              }
          }
          return l.next;
        }
}
