import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 取字符串中最长的两侧对称的子串.
 * @date 2017/9/7 11:01$
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s) || s.length() == 1) return s;
        String finalResult = "";
        String result = "";
        //循环,控制回文字符串中心点.
        one:
        for (int i = 1; i < s.length() - 1; i++) {
            int length = s.length();
            //标识中心点是否为单中心或和前面的字符组成双中心,0=单中心,例如:"aba",1=双中心 例如:"abba"
            if (s.substring(i - 1, i).equals(s.substring(i + 1, i + 2))) {
                int x = i > length - 1 - i ? length - 1 - i : i;//最多截取的层数.
                two:
                for (int j = 1; j <= x; j++) {
                    if (s.substring(i - j, i - j + 1).equals(s.substring(i + j, i + j + 1))) {
                        result = s.substring(i - j, i + j + 1);
                        if (result.length() > finalResult.length()) {
                            finalResult = result;
                        }
                    } else {
                        if (finalResult.length() > (2 * x + 1)) break one;
                        break two;
                    }
                }
            }
            if (s.substring(i - 1, i).equals(s.substring(i, i + 1))) {
                int x = i - 1 > length - 1 - i ? length - 1 - i : i - 1;//最多截取的层数.
                two:
                for (int j = 1; j <= x; j++) {
                    result = s.substring(i - 1, i + 1);
                    if (result.length() > finalResult.length()) {
                        finalResult = result;
                    }
                    int temp = 1;
                    if (i > temp) {
                        if (s.substring(i - j - temp, i - j - temp + 1).equals(s.substring(i + j, i + j + 1))) {
                            result = s.substring(i - j - temp, i + j + 1);
                            if (result.length() > finalResult.length()) {
                                finalResult = result;
                            }
                        } else {
                            if (finalResult.length() > (2 * x + 1 + temp)) break one;
                            break two;
                        }
                    }
                }
            }
        }
        return finalResult;
    }

    @Test
    public void execute() {
        String res = longestPalindrome("abcba");
        System.out.println(res);
    }
}
