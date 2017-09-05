/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 有两个代表两组非负数字的链表。两个链表按照逆序排序，并且每一个节点包含一位数字。把两组数加起来，并且返回一个链表。
 * @date 2017/8/24 14:23$
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = null;
        ListNode headNode = null;
        int carry = 0; //进位

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            if (result == null) {
                headNode = new ListNode(carry % 10);
                result = headNode;
            } else {
                result.next = new ListNode(carry % 10);
                result = result.next;
            }
            carry /= 10;
        }

        if (carry == 1) {
            result.next = new ListNode(1);
        }

        return headNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}