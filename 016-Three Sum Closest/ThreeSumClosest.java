import org.junit.Test;

import java.util.Arrays;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * @date 2018/12/11 14:32$
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2], length = nums.length, d = Math.abs(result - target);
        for (int x = 0; x < length; x++) {
            if (x > 0 && nums[x] == nums[x - 1]) {
                continue;
            }
            int y = x + 1, z = length - 1;
            while (y < z) {
                int sum = nums[x] + nums[y] + nums[z];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    y++;
                } else {
                    z--;
                    while (y < z && nums[z] == nums[z + 1]) {
                        z--;
                    }
                }
                int abs = Math.abs(sum - target);
                if (d > abs) {
                    result = sum;
                    d = abs;
                }
            }
        }
        return result;
    }

    @Test
    public void execute() {
        System.out.println(threeSumClosest(new int[]{0, 2, 1}, 1));
    }


}
