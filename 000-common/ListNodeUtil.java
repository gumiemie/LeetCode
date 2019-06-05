/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/1/11 11:12$
 */
public class ListNodeUtil {
    public static ListNode createListNode(int[] param){
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
