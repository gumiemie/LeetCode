import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 判断是不是回文数, 不能使用其它空间.实现方法是将整个数字完全反转后看是否相等.
 * @date 2017/9/26 16:07$
 */
public class PalindromeNumber {

    /**
     * 使用数字计算将数字反转后对比
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //所有负数都不是回文数.
        if (x < 0) return false;
        //所有个位数都是回文数.
        if (x < 10) return true;
        //10的整数倍都不是回文数.
        if (x % 10 == 0) return false;
        int j = x;
        int k = 0;
        while (j != 0) {
            k = k * 10 + j % 10;
            j /= 10;
        }
        return x == k;
    }

    @Test
    public void execute() {
        if (impl2(121)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }

    /**
     * 利用String类反转后对比
     * @param x
     * @return
     */
    public boolean impl2(int x) {

        StringBuilder sb = new StringBuilder();
        sb.append(x);
        return sb.reverse().toString().equals(sb.toString());
    }

}
