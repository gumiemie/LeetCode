import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 有两个已经排好序的数组, 取两个数组合并后的中位数.
 * @date 2017/9/6 10:35$
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] a1, int[] a2) {
        int totalLength = a1.length + a2.length;//总长度.
        int middleLength = totalLength / 2 + 1;//遍历时需要拿的元素个数.
        int index = 0;//标记已经拿到了多少元素.
        int temp = 0;//第二个数组下标
        int firstValue = 0;//可能的中位数.只有总元素个数是双数时才需要.
        int secondValue = 0;//可能的中位数.一定需要.
        one:
        for (int i = 0; i < a1.length; i++) {
            two:
            for (int j = temp; j < a2.length; j++) {
                if (index < middleLength) {
                    index++;
                    if (a1[i] < a2[j]) {
                        firstValue = secondValue;
                        secondValue = a1[i];
                        break two;
                    } else if (a1[i] > a2[j]) {
                        firstValue = secondValue;
                        secondValue = a2[j];
                        temp = j + 1;
                    } else {
                        firstValue = secondValue;
                        secondValue = a1[i];
                        break two;
                    }
                } else {
                    break one;
                }
            }
        }

        return totalLength % 2 == 1 ? secondValue : (double) (firstValue + secondValue) / 2;
    }

    @Test
    public void execute() {
        int[] a1 = new int[]{1, 3};
        int[] a2 = new int[]{2};
        double medianSortedArrays = findMedianSortedArrays(a1, a2);
        System.out.println(medianSortedArrays);
    }
}
