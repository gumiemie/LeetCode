import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 合并两个有序链表
 * @date 2019/1/8 15:38$
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);//结果
        ListNode temp = new ListNode(0);//指针
        result.next = temp;
        do {
            if (l1 == null) {
                temp.next = l2;
                break;
            }
            if (l2 == null) {
                temp.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
        } while (l1 != null || l2 != null);
        return result.next.next;
    }

    @Test
    public void execute() {
        int[] a = new int[]{1, 3, 4, 6};
        int[] b = new int[]{2, 5, 6, 8};
        mergeTwoLists(createListNode(a), createListNode(b));
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
