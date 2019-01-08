import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * @date 2018/12/13 11:54$
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = nums.length;
        if (length < 4) return result;
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int x = i + 1; x < length; x++) {
                if (x - i > 1 && nums[x] == nums[x - 1]) {
                    continue;
                }
                int y = x + 1, z = length - 1;
                int tempNum = target - nums[i] - nums[x];
                while (y < z) {
                    if (nums[y] + nums[z] == tempNum) {
                        ArrayList<Integer> childrenList = new ArrayList<Integer>();
                        childrenList.add(nums[i]);
                        childrenList.add(nums[x]);
                        childrenList.add(nums[y]);
                        childrenList.add(nums[z]);
                        result.add(childrenList);
                        y++;
                        z--;
                        while (z > y && nums[z] == nums[z + 1]) {
                            z--;
                        }
                    } else if (nums[y] + nums[z] > tempNum) {
                        z--;
                    } else {
                        y++;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void execute() {
        System.out.println(fourSum(new int[]{-2,0,0,3,3,-1}, 5));
    }
}
