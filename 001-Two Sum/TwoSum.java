import org.junit.Test;

import java.util.HashMap;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * @date 2017/8/24 14:00$
 */
public class TwoSum {

    @Test
    public void test() {
        //[3,2,4] 6
        int[] array = new int[]{3, 2, 4};
        int target = 6;

        int[] ints = twoSumUseHashMap(array, target);
        System.out.print("[" + ints[0] + "," + ints[1] + "]");
    }

    //解决思路是两个for循环.
    private int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 解决思路是使用hash表
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSumUseHashMap(int[] nums, int target) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("参数数组为空!");
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }
        return null;
    }

}

