package 学习;

public class _2两数相加 {


     // Definition for singly-linked list.
     public static class ListNode {
          int val;
         ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode k = new ListNode();
        ListNode cur = l;
        ListNode t = k;
        for (int i = 0; i <=3 ; i++) {
            cur.val = 3;
            cur.next = new ListNode();
            cur = cur.next;

            t.val = 9;
            t.next = new ListNode();
            t = t.next;
        }
        System.out.println(addTwoNumbers(l, k));
    }
//[2,4,3]
//[5,6,4]
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode result = null;
            ListNode c = result;
            int current = 0;
            while (l1 !=null || l2 !=null){
                int cl1 = l1 == null ? 0 : l1.val;
            int cl2 = l2 == null ? 0 : l2.val;
            int he = cl1 + cl2 + current ;
                current = he/10;
                if (result == null){
                    result = new ListNode(he%10);
                    c =result;
                }else {
                    c.next = new ListNode(he%10);
                    c = c.next;

                }
                if (l1 !=null){
                    l1 = l1.next;
                }
                if (l2 != null){
                    l2 = l2.next;
                }

            }
            if (current > 0){
                c.next = new ListNode(current);
            }
         return result;
        }

}
