/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * @date 2019/2/1 16:48$
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            return 0l - (long) dividend < Integer.MIN_VALUE ? Integer.MIN_VALUE : 0 - dividend;
        }
        while (dividend>divisor){
        }
        return 0;
    }

}
