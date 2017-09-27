import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 字符转数字.去掉空白字符, 如果开头字符不为+-或数字.无法转换.截取到一定数量的数字后,后续非数字忽略.
 * @date 2017/9/25 15:44$
 */
public class StringtoInteger {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) return 0;
        str = str.trim();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (i == 0 && !Character.isDigit(c)) {
                if (c.toString().equals("-")) {
                    result += ("-");
                    continue;
                } else if (c.toString().equals("+")) {
                    continue;
                } else {
                    return 0;
                }
            } else if (Character.isDigit(c)) {
                result += c;
            } else {
                break;
            }
            if (result.length()>"2147483647".length()) break;
        }
        if (!result.equals("") && !result.equals("-")) {
            Long resultLong = Long.valueOf(result);
            if (resultLong > 2147483647) {
                return 2147483647;
            } else if (resultLong < -2147483648) {
                return -2147483648;
            } else {
                return resultLong.intValue();
            }
        } else {
            return 0;
        }
    }

    @Test
    public void execute() {
        int i = myAtoi("-+a1234aaaa");
        System.out.print(i);
    }
}
