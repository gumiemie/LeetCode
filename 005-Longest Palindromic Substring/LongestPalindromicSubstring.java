import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 取字符串中最长的两侧对称的子串.
 * @date 2017/9/7 11:01$
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) return "";
        String finalResult = "";
        String result = "";
        //嵌套循环,外层控制截取起始下标,内层控制结束下标.
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;
            boolean flag = false;
            for (int j = i + 1; j < s.length(); j++) {
                result = s.substring(i, j);
                String nextChar = s.substring(j, j + 1);
                if (result.contains(nextChar)) {
                    int index = result.indexOf(nextChar);
                    if (temp == 0) {
                        if (index == result.length() - 2) {
                            flag = true;
                            result = result + nextChar;
                            temp = 2;
                            continue;
                        } else if (index == result.length() - 1) {
                            result = result + nextChar;
                            temp = 2;
                            continue;
                        } else {
                            break;
                        }
                    } else {
                        if (flag) {
                            if (index == result.length() - 2 - temp) {
                                temp += 2;
                                result = result + nextChar;
                                continue;
                            }else {
                                break;
                            }
                        } else {
                            if (index == result.length() - 1 - temp) {
                                result = result + nextChar;
                                temp += 2;
                                continue;
                            }else {
                                break;
                            }
                        }
                    }
                } else {
                    if (temp != 0) break;
                }
            }
            if (flag){
                result = result.substring(result.length()-1 - temp);
            }else {
                result = result.substring(result.length() - temp);
            }
            if (finalResult.length()<result.length()) finalResult = result;
            if (finalResult.length() > s.length() / 2) {
                break;
            }
        }
        return finalResult;
    }

    @Test
    public void execute() {
        String res = longestPalindrome("cbbd");
        System.out.println(res);
    }
}
