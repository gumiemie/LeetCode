import org.junit.Test;

import java.util.Stack;

/**
 * @author guyang <guyang@ebnew.com>
 * @description 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * @date 2019-07-09 16:15
 */
public class LongestValidParentheses {

    /**
     * 解题主要思路是:遍历每个字符，利用栈 计算
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> charStack = new Stack<Integer>();
        charStack.push(-1);
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == '(') {
                charStack.push(i);
            } else {
                charStack.pop();
                if (charStack.isEmpty()) {
                    charStack.push(i);
                } else {
                    result = Math.max(result, i - charStack.peek());
                }
            }
        }
        return result;
    }


    /**
     * 动态规划
     * 定义一个数组,存放此字符与前面字符可组成的有效长度
     * '(',是没有办法组成的，所以长度为0。只需要计算')'字符的长度。
     * 每遍历一个字符是一个阶段,只需计算字符是')'的阶段的状态。
     * 当前阶段的状态可根据上一阶段的状态与M状态计算出。
     * M状态又可通过上一状态计算出
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        int result = 0;
        int[] lengths = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    lengths[i] = i - 2 >= 0 ? lengths[i - 2] + 2 : 2;
                } else {
                    if (i - lengths[i - 1] - 1 > -1 && s.charAt(i - lengths[i - 1] - 1) == '(') {
                        lengths[i] = lengths[i - 1] + 2 + ((i - lengths[i - 1] - 2) > -1 ? lengths[i - lengths[i - 1] - 2] : 0);
                    }
                }
                result = Math.max(result, lengths[i]);
            }
        }

        return result;
    }


    @Test
    public void execute() {
        String s = "(((()()(((())))))))";
        int i = longestValidParentheses1(s);
        System.out.println(i);
    }


}
