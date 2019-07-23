import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * @date 2019/1/11 10:11$
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode tempHead = preHead;
        ListNode left = head;
        ListNode right = head;
        ListNode index = head.next;
        int i = 1;
        while (index != null) {
            if (i == k) {
                i = 1;
                tempHead = right;
                left = right.next;
                right = right.next;
                index = right.next;
                continue;
            }
            tempHead.next = index;
            right.next = index.next;
            index.next = left;
            left = tempHead.next;
            index = right.next;
            i++;
        }
        if (i > 1 && i < k) {
            right = left;
            index = left.next;
            while (index != null) {
                tempHead.next = index;
                right.next = index.next;
                index.next = left;
                left = tempHead.next;
                index = right.next;
            }
        }

        return preHead.next;
    }


    @Test
    public void execute() {
        int[] ints = {1, 3};
        ListNode listNode = ListNodeUtil.createListNode(ints);
        System.out.println(reverseKGroup(listNode, 2));
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode left = head;
        ListNode right = head;
        ListNode index = head.next;
        while (index != null) {
            pre.next = index;
            right.next = index.next;
            index.next = left;
            left = pre.next;
            index = right.next;
        }

        return pre.next;
    }


}
