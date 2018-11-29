import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 取字符串中最长的两侧对称的子串.
 * @date 2017/9/7 11:01$
 */
public class LongestPalindromicSubstring {

    private String longestPalindrome(String s) {
        if (s == null || "".equals(s) || s.length() == 1) return s;
        int start = 0;
        int end = 1;
        int length = 1;
        //循环,控制回文字符串中心点.
        one:
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                int tempx = i - 1;
                int tempy = i;
                //双中心点
                if (s.charAt(i) == s.charAt(i - 1)) {
                    two:
                    while (tempx >= 0 && tempy < s.length()) {
                        if (s.charAt(tempx) == s.charAt(tempy)) {
                            if (length < tempy + 1 - tempx) {
                                start = tempx;
                                end = tempy + 1;
                                length = tempy + 1 - tempx;
                            }
                            tempx--;
                            tempy++;
                        } else {
                            break two;
                        }
                    }
                    //单中心点
                }
                tempx = i - 1;
                int tempz = i + 1;
                if (i + 1 < s.length() && s.charAt(tempx) == s.charAt(i + 1)) {
                    three:
                    while (tempx >= 0 && tempz < s.length()) {
                        if (s.charAt(tempx) == s.charAt(tempz)) {
                            if (length < tempz + 1 - tempx) {
                                start = tempx;
                                end = tempz + 1;
                                length = tempz + 1 - tempx;
                            }
                            tempx--;
                            tempz++;
                        } else {
                            break three;
                        }
                    }
                }
            }
        }
        return s.substring(start, end);
    }

    /**
     * 获取最长的回文字符串
     * 解答方法是把上面的方法改进,将字符串加入特殊字符“#”,可以解决双中心的问题
     *
     * @param s
     * @return
     */
    public String impl2(String s) {
        if (s.length() == 1) return s;
        String string = preProcessString(s);
        int i = 1;
        int[] ints = new int[string.length()];
        //#a#b#b#b#a#
        for (; i < string.length() - 1; i++) {
            int max = 0;
            while (string.charAt(i - max) == string.charAt(i + max)) {
                max++;
            }
            ints[i] = max;
        }
        int temp = 0;
        for (int index = 0; index < ints.length; index++) {
            if (ints[index] > temp) {
                temp = ints[index];
                i = index;
            }
        }
        String substring = s.substring((i - temp) / 2, (temp + i) / 2 - 1);
        System.out.println(substring);
        return "";
    }

    private String preProcessString(String s) {
        StringBuilder sb = new StringBuilder("^#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        return sb.append("$").toString();
    }

    @Test
    public void execute() {
        String res = impl2("saxaabaa");
        System.out.println(res);
    }
}
