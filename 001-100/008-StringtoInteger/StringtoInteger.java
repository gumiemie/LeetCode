import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 字符转数字.去掉空白字符, 如果开头字符不为+-或数字.无法转换.截取到一定数量的数字后,后续非数字忽略.
 * @date 2017/9/25 15:44$
 */
public class StringtoInteger {

    /**
     * 获取字符后,使用StringBuilder组装,然后转换成数字
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) return 0;
        str = str.trim();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (i == 0 && !Character.isDigit(c)) {
                if (c=='-') {
                    result.append("-");
                    continue;
                } else if (c=='+') {
                    continue;
                } else {
                    return 0;
                }
            } else if (Character.isDigit(c)) {
                result.append(c);
            } else {
                break;
            }
        }
        String s = result.toString();
        Long resultLong;
        if (!s.equals("") && !s.equals("-")) {
            try {
                resultLong = Long.valueOf(s);
                if (resultLong > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (resultLong < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                return resultLong.intValue();
            } catch (Exception e) {
                if (s.startsWith("-")) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        } else {
            return 0;
        }
    }

    @Test
    public void execute() {
        int i = aToiImpl2("-0000000001234567");
        System.out.print(i);
    }

    /**
     * 获取数字字符后，使用数学运算计算结果
     * @param string
     * @return
     */
    public int aToiImpl2(String string) {
        if (string.equals("") || string.length() == 0 || string.trim().length() == 0) return 0;
        string = string.trim();
        long result = 0;
        boolean flag = string.startsWith("-");
        if (flag || string.startsWith("+")) {
            string = string.substring(1, string.length());
        }
        int i = 0;
        while (i < string.length()) {
            Character c = string.charAt(i);
            if (Character.isDigit(c)) {
                result = result * 10 + Integer.valueOf(c.toString());
                if (result > Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
            i++;
        }
        if (!flag) {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) result;
        } else {
            result = 0 - result;
            if (result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            return (int) result;
        }

    }


}
