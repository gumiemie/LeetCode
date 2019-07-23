import org.junit.Test;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @date 2018/12/14 15:33$
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        s = s.replaceAll("", "#");
        s = s.replaceAll("\\(", "-1");
        s = s.replaceAll("\\[", "-2");
        s = s.replaceAll("\\{", "-3");
        s = s.replaceAll("\\)", "1");
        s = s.replaceAll("\\]", "2");
        s = s.replaceAll("\\}", "3");
        s = s.substring(1, s.length() - 1);
        String[] nums = s.split("#");
        int length = nums.length;
        int sum = 0;
        int i = 0;
        while (i < nums.length) {
            if (length == 0) {
                break;
            }
            Integer tx = Integer.valueOf(nums[i]);
            sum += tx;
            if (i == nums.length - 1 && length > 0) {
                if (length == nums.length || sum != 0) {
                    return false;
                }
                i = 0;
                continue;
            }
            if (tx == 0) {
                i++;
                continue;
            }
            int y = i + 1;
            while (y < nums.length) {
                if ("0".equals(nums[y]) && y < nums.length - 1) {
                    y++;
                } else {
                    break;
                }
            }
            Integer ty = Integer.valueOf(nums[y]);
            if (tx + ty == 0 && tx < ty) {
                nums[i] = "0";
                nums[y] = "0";
                length = length - 2;
                sum += ty;
                if (y == nums.length - 1) {
                    i = 0;
                    continue;
                }
                i += 2;
                continue;
            } else {
                if (tx + ty != 0) {
                    if (tx < 0 && ty > 0) {
                        return false;
                    }
                } else {
                    if (i == 0 || y == nums.length - 1) {
                        return false;
                    }
                }
            }
            i++;
        }

        return true;
    }

    @Test
    public void execute() {
        System.out.println(impl3("[({(())}[()])]"));
    }


    public boolean isValidImpl2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> maps1 = new HashMap<Character, Character>();
        maps1.put('(', ')');
        maps1.put('[', ']');
        maps1.put('{', '}');
        Set<Character> keys1 = maps1.keySet();
        Stack<Character> noSum = new Stack<Character>();
        int x = 0;
        while (x < length) {
            char c = s.charAt(x);
            if (keys1.contains(c)) {
                noSum.push(c);
                x++;
            } else {
                if (noSum.empty()) {
                    return false;
                } else {
                    if (maps1.get(noSum.peek()).compareTo(c) == 0) {
                        x++;
                        noSum.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return noSum.empty();
    }

    public boolean impl3(String s){
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char achar:chars){
            if (stack.size()==0){
                stack.push(achar);
            }else if (isMatch(stack.peek(),achar)){
                stack.pop();
            }else {
                stack.push(achar);
            }
        }
        return stack.empty();
    }

    private boolean isMatch(Character c1,Character c2){
        return (c1=='('&&c2==')')||(c1=='['&&c2==']'||(c1=='{'&&c2=='}'));
    }

}
