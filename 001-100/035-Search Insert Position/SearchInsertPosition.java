import org.junit.Test;

/**
 * @author guyang <guyang@ebnew.com>
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * @date 2019-07-22 16:49
 */
public class SearchInsertPosition {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int si = 0, ei = nums.length - 1, hi;
        while (si <= ei) {
            hi = (si + ei) >> 1;
            if (nums[hi] == target) {
                return hi;
            } else {
                if (target > nums[hi]) {
                    si = ++hi;
                } else {
                    ei = --hi;
                }
            }
        }
        return si;
    }

    @Test
    public void execute() {
        int nums[] = new int[]{1, 3, 5, 6, 7};
        int i = searchInsert(nums, 4);
        System.out.println(i);

    }


}
