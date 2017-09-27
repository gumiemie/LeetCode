import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 判断是不是回文数, 不能使用其它空间.
 * @date 2017/9/26 16:07$
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;//所有负数都不是回文数.
        if (x < 10) return true;//所有单数都是回文数.
        if (x % 10 == 0) return false;//10的整数倍都不是回文数.
        int j = x;
        double temp = 0;
        int k = 0;
        while (x != 0) {
            temp += (x % 10) * Math.pow(10, k);
            x /= 10;
            k--;
        }
        k = (int) (temp * Math.pow(10, 0 - k));
        if (j == k) return true;
        return false;
    }

    @Test
    public void execute() {
        if (isPalindrome(1)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }

}
