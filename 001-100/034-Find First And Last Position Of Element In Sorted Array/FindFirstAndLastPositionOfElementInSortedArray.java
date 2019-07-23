import org.junit.Test;

/**
 * @author guyang <guyang@ebnew.com>
 * @description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @date 2019-07-15 16:48
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 题目要求时间复杂度为O(log n)，所以只能是二分查找
     * 找到目标值，分别递减、递增查找起始位置
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int si = 0, ei = nums.length - 1, hi;

        while (si <= ei) {
            hi = (si + ei) / 2;
            if (target == nums[hi]) {
                while (hi > -1 && nums[hi] == target) {
                    hi--;
                }
                result[0] = hi + 1;
                hi = (si + ei) / 2;
                while (hi <= ei && nums[hi] == target) {
                    hi++;
                }
                result[1] = hi - 1;
                break;
            } else {
                if (si == hi) {
                    if (target == nums[ei]) {
                        result[0] = ei;
                        result[1] = ei;
                    }
                    break;
                }
                if (target < nums[hi]) {
                    ei = hi;
                } else if (target > nums[hi]) {
                    si = hi;
                }
            }
        }

        return result;
    }


    @Test
    public void excute() {
        int[] nums = new int[]{5};
        searchRange(nums, 4);
    }

}
