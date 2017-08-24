import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * @date 2017/8/24 14:00$
 */
public class TwoSum {

    @Test
    public void test(){
        //[3,2,4] 6
        int[] array = new int[]{3,2,4};
        int target = 6;

        int[] ints = twoSum(array, target);
        System.out.print("["+ints[0]+","+ints[1]+"]");
    }

    //解决思路是两个for循环.
    public int[] twoSum(int[] nums, int target) {
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

}

