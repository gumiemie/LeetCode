import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * @date 2019/2/1 16:48$
 */
public class DivideTwoIntegers {

    public DivideTwoIntegers() {
    }

    /**
     * 不能使用乘法，除法，和取余
     * 首先想到的是减法，被除数每次减去1个除数，看能减多少个，不过显而易见，这种方法效率太低。
     * 那么能不能每次减去N个呢？
     * 这儿可以利用按位运算，找到：减去除数个数的比较合理的值
     * 1：被除数 向右 位移i位（向右位移1位相当于除2），i从31（为什么是31？int最大值是2的31次方-1）依次向下递减
     * 当结果值>=除数时，2的i次方，就是减去除数个数N的值
     * 2：被除数 = 被除数-除数*2的i次方 即 dividend-=divisor<<i（向左位移1位相当于*2）
     * 再次执行1，2操作，直到：i=0 或
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        //int的取值范围为（-2147483648~2147483647），仅当被除数为Integer.MIN_VALUE 除数为-1时，商才会超范围
        if (divisor == -1) {
            return 0 - (long) dividend > Integer.MAX_VALUE ? Integer.MAX_VALUE : 0 - dividend;
        }

        //判断符号位是否相同 位异或运算，相同=0，不同=1
        boolean isPositive = (dividend ^ divisor) >= 0;

        //取绝对值 如果参数为Integer.MIN_VALUE 绝对值为参数本身，超过int的表示范围，所以要转成long类型
        long absD1 = Math.abs((long) dividend);
        long absD2 = Math.abs((long) divisor);

        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if (absD1 >> i >= absD2) {
                result += 1 << i;
                absD1 -= absD2 << i;
                if (absD1 < absD2) {
                    break;
                }
            }
        }
        return isPositive ? result : 0 - result;
    }


    @Test
    public void test() {
        System.out.println(divide(2, 2));
    }
}
