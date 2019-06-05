import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 示例:给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:你的算法只能使用常数的额外空间。你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @date 2019/1/10 11:01$
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(-1);
        ListNode left = preHead;
        if (head.next == null) {
            return head;
        }
        ListNode mid = head;
        ListNode right = mid.next;
        while (right != null) {
            mid.next = right.next;
            left.next = right;
            right.next = mid;
            if (mid.next == null) {
                break;
            }
            left = mid;
            mid = mid.next;
            right = mid.next;
        }
        return preHead.next;
    }

    @Test
    public void execute() {
        int[] ints = new int[]{1, 3, 4, 7, 6, 2};
        System.out.println(swapPairs(createListNode(ints)));
    }


    private ListNode createListNode(int[] param) {
        ListNode result = null;
        ListNode node = null;
        for (int ai : param) {
            ListNode temp = new ListNode(ai);
            if (result == null) {
                result = temp;
                node = temp;
            } else {
                node.next = temp;
                node = node.next;
            }
        }
        return result;
    }

}
