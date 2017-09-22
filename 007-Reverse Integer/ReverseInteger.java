import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 将数字反转.
 * @date 2017/9/22 17:18$
 */
public class ReverseInteger {
    public int reverse(int x) {
        StringBuffer s = new StringBuffer("");
        //如果是负数,先将数字变成正数.
        if (x < 0) {
            s.append("-");
            x = 0 - x;
        }
        while (x != 0) {
            int i = x % 10;
            x /= 10;
            s.append(i);
        }
        return Integer.valueOf(s.toString());
    }

    @Test
    public void execute() {
        int reverse = reverse(-1234);
        System.out.print(reverse);
    }
}
