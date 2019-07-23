import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @date 2019/1/14 11:25$
 */
public class ImplementStrstr {

    public int strStr(String haystack, String needle) {

        return -1;
    }

    @Test
    public void execute() {
        //System.out.println(impl1("a", "aa"));
        System.out.println(impl2("abacdababc", "abab"));
    }

    /**
     * kmp算法
     * O(m)
     * @param haystack
     * @param needle
     */
    public int impl2(String haystack, String needle) {
        int[] nextArray = getNextArray(needle);

        int j = 0;
        int i = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = nextArray[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    /**
     * kmp算法 获取next数组
     * O(n*n-1)
     * @param needle
     * @return
     */
    private int[] getNextArray(String needle) {
        int[] result = new int[needle.length() + 1];
        result[0] = -1;
        for (int i = 0; i < needle.length(); i++) {
            int temp = 0;
            for (int x = 1; x <= i; x++) {
                if (needle.substring(0, x).equals(needle.substring(i - x + 1, i + 1))) {
                    temp = temp < x ? x : temp;
                }
            }
            result[i + 1] = temp;
        }
        return result;
    }


    /**
     * 暴力法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int impl1(String haystack, String needle) {

        int ty = 0;
        int tx = 0;
        int hlength = haystack.length();
        while (tx < hlength) {
            int nlength = needle.length();
            int temp = tx;
            while (temp < hlength && ty < nlength) {
                char cx = haystack.charAt(temp);
                char cy = needle.charAt(ty);
                if (cx == cy) {
                    if (ty == nlength - 1) {
                        if (temp < hlength) {
                            return temp + 1 - nlength;
                        } else {
                            return -1;
                        }
                    }
                    temp++;
                    ty++;
                } else {
                    break;
                }
            }
            tx++;
            ty = 0;
        }
        return -1;
    }


}
