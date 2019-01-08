import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 * @date 2018/12/5 16:09$
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length == 0) return result.toString();
        if (strs.length == 1) return strs[0];
        String str = strs[0];
        int index = 0;
        while (index < str.length()) {
            char temp = str.charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != temp) {
                    return result.toString();
                }
            }
            result.append(temp);
            index++;
        }
        return result.toString();
    }

    @Test
    public void execute() {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

}
