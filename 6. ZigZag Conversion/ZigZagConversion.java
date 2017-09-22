import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 将字符串转换成锯齿状, 并返回每行的
 * @date 2017/9/21 10:16$
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows<=1) return s;
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
        for (String temp:result){
            resultString+=temp;
        }
        //去掉null
        resultString = resultString.replaceAll("null", "");
        return resultString;
    }

    @Test
    public void execute(){
        String paypalishiring = convert("PAYPALISHIRING", 3);
        System.out.print(paypalishiring);
    }

}
