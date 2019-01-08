import org.junit.Test;

import java.util.ArrayList;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @date 2018/12/13 17:05$
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 单次循环，将结点存储在list中
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<ListNode>();
        listNodes.add(head);
        ListNode temp = head;
        while (temp.next != null) {
            listNodes.add(temp.next);
            temp = temp.next;
        }
        int size = listNodes.size();
        if (size == 1) {
            return null;
        } else if (n == size) {
            return head.next;
        } else if (n > 1) {
            listNodes.get(size - n - 1).next = listNodes.get(size - n).next;
        } else if (n == 1) {
            listNodes.get(size - 2).next = null;
        }
        return head;
    }


    @Test
    public void execute() {

        int[] ints = {1};
        ListNode head = null;
        ListNode node = null;
        for (int i = 0; i < ints.length; i++) {
            ListNode next = new ListNode(ints[i]);
            if (node == null) {
                head = next;
                node = next;
            } else {
                node.next = next;
                node = next;
            }
        }
        System.out.println(removeNthFromEnd2(head, 1));

    }

    /**
     * 单次循环，使用两个指针。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        int length = 1;
        ListNode firstP = node;
        ListNode secondP = head;
        while (length < n) {
            secondP = secondP.next;
            length++;
        }
        while (secondP.next != null) {
            secondP = secondP.next;
            firstP = firstP.next;
        }
        firstP.next = firstP.next.next;
        return node.next;
    }

}
