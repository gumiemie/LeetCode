/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 链表节点 公用类
 * @date 2018/12/13 17:09$
 */
public class ListNode {

      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      @Override
      public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
      }
}
