import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * @date 2019/1/9 15:24$
 */
public class MergeKSortedLists {

    /**
     * 分治算法,将计算分解成若干个2个链表合并。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        mergeList(lists, lists.length);
        return lists[0];
    }

    private void mergeList(ListNode[] lists, int length) {
        int left = 0;
        int right = length - 1;
        while (left < right) {
            lists[left] = merge(lists[left], lists[right]);
            left++;
            right--;
        }
        length = length % 2 == 1 ? length / 2 + 1 : length / 2;
        if (length > 1) {
            mergeList(lists, length);
        }
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(0);
        ListNode temp = new ListNode(0);
        result.next = temp;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                temp.next = node2;
                break;
            }
            if (node2 == null) {
                temp.next = node1;
                break;
            }
            if (node1.val > node2.val) {
                temp.next = node2;
                temp = temp.next;
                node2 = node2.next;
            } else {
                temp.next = node1;
                temp = temp.next;
                node1 = node1.next;
            }
        }
        return result.next.next;
    }

    @Test
    public void execute() {
        int[][] ins = new int[][]{{}, {-1, 5, 11}, {}, {6, 10}, {2, 3, 4}};
        ListNode[] listNodes = new ListNode[ins.length];
        for (int i = 0; i < ins.length; i++) {
            listNodes[i] = createListNode(ins[i]);
        }
        ListNode node = mergeKLists(listNodes);
        System.out.println(node);
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
