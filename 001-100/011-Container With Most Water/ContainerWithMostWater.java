import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @date 2018/12/4 13:47$
 */
public class ContainerWithMostWater {
    /**
     * 暴力法,计算每个区域的面积
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = 0;
        int x = 0;
        int length = height.length;
        while (x < length) {
            int y = x + 1;
            while (y < length) {
                int temp = (y - x) * Math.min(height[x], height[y]);
                if (temp > result) {
                    result = temp;
                }
                y++;
            }
            x++;
        }
        return result;
    }

    @Test
    public void execute() {
        System.out.print(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 双指针法,头尾两个指针,哪边高度低，哪边指针向中心移动。
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int x = 0;
        int y = height.length - 1;
        int maxArea = 0;
        while (x < y) {
            maxArea =  Math.max(maxArea,(y-x)*Math.min(height[x],height[y]));
            if (height[x]>height[y]){
                y--;
            }else {
                x++;
            }
        }
        return maxArea;
    }

}
