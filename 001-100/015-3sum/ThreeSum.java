import org.junit.Test;

import java.util.*;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * @date 2018/12/7 16:39$
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List result = new ArrayList();
        int length = nums.length;
        if (length < 3) return result;
        Arrays.sort(nums);
        int x = 0, z = length - 1;
        if (nums[x] > 0 || nums[z] < 0) return result;
        while (x < z && nums[x] <= 0) {
            int tx = nums[x];
            int y = x + 1;
            z = length - 1;
            while (y < z) {
                int ty = nums[y], tz = nums[z];
                int sum = tx + ty + tz;
                if (sum >= 0) {
                    if (sum == 0) {
                        List integers = new ArrayList<Integer>();
                        integers.add(tx);
                        integers.add(ty);
                        integers.add(tz);
                        result.add(integers);
                        y++;
                    }
                    z--;
                    while (tz == nums[z] && z > x) {
                        z--;
                    }
                } else {
                    y++;
                }
            }
            x++;
            while (tx == nums[x] && x < z) {
                x++;
            }
        }

        return result;
    }

    @Test
    public void execute() {
        List<List<Integer>> lists = threeSum(new int[]{0, 0});
        System.out.println(lists);
    }
}