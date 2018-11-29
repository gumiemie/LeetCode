import org.junit.Test;

import java.util.Arrays;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 有两个已经排好序的数组, 取两个数组合并后的中位数.
 * @date 2017/9/6 10:35$
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] a1, int[] a2) {
        int totalLength = a1.length + a2.length;//总长度.
        int middleLength = totalLength / 2;
        int[] a = new int[totalLength];
        System.arraycopy(a1,0,a,0,a1.length);
        System.arraycopy(a2,0,a,a1.length,a2.length);
        Arrays.sort(a);

        return totalLength % 2 == 1 ? a[middleLength] : (double) (a[middleLength] + a[middleLength - 1]) / 2;
    }

    @Test
    public void execute() {
        int[] a1 = new int[]{1, 3};
        int[] a2 = new int[]{2};
        double medianSortedArrays = findMedianSortedArrays(a1, a2);
        System.out.println(medianSortedArrays);
    }
}
