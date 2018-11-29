import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 一个字符串, 获取长度最长的无重复的字符串的长度.
 * @date 2017/9/5 15:20$
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s == null || "".equals(s)) return result;
        if (s.length() == 1) return 1;
        StringBuffer buffer = new StringBuffer(s);
        //嵌套循环,外层控制截取字符串开始的位置,内层控制截取字符串结束的位置.
        one:
        for (int i = 0; i < buffer.length(); i++) {
            for (int j = i + 1; j < buffer.length(); j++) {
                String substring = buffer.substring(i, j);
                //如果截取到的字符串包含下一个字符,则当前字符串是开始位置可以截取到的最长字符.
                if (substring.contains(buffer.substring(j, j + 1))) {
                    if (substring.length() > result) result = substring.length();
                    break;
                } else {
                    //判断是否到了字符串尾.
                    if (j + 1 == buffer.length()) {
                        result = j - i + 1;
                    }
                }
            }
            //如果已经取到的字符串长度大于等于剩余可截字符串的最大长度.后续的截取过程无意义,放弃.
            if (result >= buffer.length() - i) break one;
        }
        return result;
    }

    @Test
    public void execute() {
        String s = "fbwg";
        String substring = s.substring(3, 4);
        int leng = lengthOfLongestSubstring("fbwg");
        System.out.println(leng);
    }

}
