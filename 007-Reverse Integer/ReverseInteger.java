import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 将数字反转.
 * @date 2017/9/22 17:18$
 */
public class ReverseInteger {
    public int reverse(int x) {
        StringBuilder s = new StringBuilder();
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
        Integer integer = 0;
        try {
            integer = Integer.valueOf(s.toString());
        } catch (Exception e) {
            return integer;
        }

        return integer;
    }

    @Test
    public void execute() {
        int reverse = process(-212222228);
        System.out.print(reverse);
    }

    /**
     * 不借助String实现
     *
     * @param x
     * @return
     */
    private int process(int x) {
        long temp = 0;
        while (x != 0) {
            temp = temp * 10 + x % 10;
            if (temp>Integer.MAX_VALUE||temp<Integer.MIN_VALUE) return 0;
            x = x / 10;
        }
        return (int)temp;
    }
}
