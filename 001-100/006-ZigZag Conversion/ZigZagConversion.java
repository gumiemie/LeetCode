import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 将字符串转换成Z字状, 并逐行输出
 * @date 2017/9/21 10:16$
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        //用数组存储每一行的字符.
        String[] result = new String[numRows];
        String[] bytes = s.split("");
        int i = 0;//当前行数
        boolean flag = true;//控制字符的方向
        for (int j = 0; j < bytes.length; j++) {
            //遍历字符串中的各个字符.
            if (i >= 0 && i < numRows) {
                result[i] += bytes[j];
                if (flag) {
                    i++;
                } else {
                    i--;
                }
                //到最底端或最顶端行时返回.
                if (i == numRows - 1) flag = false;
                if (i == 0) flag = true;
            }
        }
        String resultString = "";
        for (String temp : result) {
            resultString += temp;
        }
        //去掉null
        resultString = resultString.replaceAll("null", "");
        return resultString;
    }

    @Test
    public void execute() {
        String paypalishiring = process("LEETCODEISHIRING", 3);
        System.out.print(paypalishiring);
    }

    /**
     * 优化版
     *
     * @return
     */
    private String process(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        //数组索引
        int i = 0;
        int max = numRows - 1;
        //方向开关
        boolean flag = true;
        for (char c : s.toCharArray()) {
            if (stringBuilders[i] == null) {
                stringBuilders[i] = new StringBuilder();
            }
            stringBuilders[i].append(c);
            if (flag) {
                i++;
                if (i == max) flag = false;
            } else {
                i--;
                if (i == 0) flag = true;
            }
        }

        StringBuilder result = stringBuilders[0];
        i = 1;
        while (i < numRows) {
            result.append(stringBuilders[i]);
            i++;
        }

        return result.toString();
    }


}
