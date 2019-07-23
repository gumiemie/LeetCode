import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 正则表达式匹配
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符。'*' 匹配零个或多个前面的元素。匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * 说明: s 可能为空，且只包含从 a-z 的小写字母。p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * @date 2018/12/3 10:54$
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        //todo 未实现
        //如果正则为空
        if (p == null || "".equals(p)) {
            if (s == null || "".equals(s)) {
                return true;
            }
            return false;
        } else {
            if (".*".equals(p)) return true;
            char[] chars = p.toCharArray();
            if (s == null || "".equals(s)) {
                int i = 0;
                while (i < chars.length) {
                    char aChar = chars[i];
                    if ((aChar >= 97 && aChar <= 122) || aChar == '.') {
                        if (i > 0) {
                            aChar = chars[i - 1];
                            if ((aChar >= 97 && aChar <= 122) || aChar == '.') {
                                return false;
                            }
                        }
                        i++;
                        continue;
                    }
                    if (aChar == '*') {
                        if (i > 0) {
                            aChar = chars[i - 1];
                            if ((aChar >= 97 && aChar <= 122) || aChar == '.') {
                                if (i == chars.length - 1) {
                                    return true;
                                }
                                i++;
                                continue;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                    return false;
                }
                return true;
            } else {
                int y = 0;
                int x = 0;
                int num1 = 1;
                int num2 = 0;
                one:
                while (x < s.length()) {
                    char c = s.charAt(x);
                    two:
                    while (y < chars.length) {
                        char aChar = chars[y];
                        if (aChar == '.') {
                            num1 = 1;
                            num2 = 0;
                            x++;
                            y++;
                            break two;
                        }
                        if (c == aChar) {
                            x++;
                            y++;
                            break two;
                        }
                        if (aChar == '*') {
                            if (y > 0 && y < chars.length) {
                                char bchar = chars[y - 1];
                                if (c == bchar || bchar == '.') {
                                    num1++;
                                    x++;
                                    break two;
                                }
                                if (c != bchar) {
                                    y++;
                                    continue;
                                }
                            }
                            return false;
                        }
                        if (c != aChar) {
                            if (y > 0 && y < chars.length) {
                                num2++;
                                if (chars[y - 1] != '*') {
                                    return false;
                                }
                            }
                            y++;
                            continue;
                        }
                        if (num1 < num2) {
                            return false;
                        }
                    }

                    if (y >= chars.length && x < s.length()) return false;
                }
            }
            return true;
        }
    }

    @Test
    public void execute() {

        System.out.println(isMatch("ab", ".*"));
    }
}
