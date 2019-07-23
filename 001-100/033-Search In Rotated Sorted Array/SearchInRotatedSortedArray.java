import org.junit.Test;

/**
 * @author guyang <guyang@ebnew.com>
 * @description 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @date 2019-07-11 15:05
 */
public class SearchInRotatedSortedArray {

    /**
     * 要求时间复杂度必须是 O(log n) 级别,所以只能是二分查找
     * 比较复杂的判断递归条件中目标值在哪二分之一
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        } else if (length == 1) {
            return nums[0] == target ? 0 : -1;
        } else {
            return halfSearch(nums, target, 0, length - 1);
        }
    }

    /**
     * 递归二分查找，代码冗长，可优化
     *
     * @param nums
     * @param target
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int halfSearch(int[] nums, int target, int startIndex, int endIndex) {
        int result = -1;
        //基准条件
        int halfIndex = (startIndex + endIndex) / 2;
        if (target == nums[halfIndex]) {
            result = halfIndex;
        } else {
            if (startIndex + 1 == endIndex) {
                return nums[endIndex] == target ? endIndex : result;
            }

            //递归条件
            if (target < nums[halfIndex]) {
                if (target >= nums[startIndex]) {
                    result = halfSearch(nums, target, startIndex, halfIndex);
                } else {
                    if (nums[startIndex] > nums[halfIndex]) {
                        result = halfSearch(nums, target, startIndex, halfIndex);
                    } else {
                        result = halfSearch(nums, target, halfIndex, endIndex);
                    }
                }
            } else {
                if (target <= nums[endIndex]) {
                    result = halfSearch(nums, target, halfIndex, endIndex);
                } else {
                    if (nums[halfIndex] > nums[endIndex]) {
                        result = halfSearch(nums, target, halfIndex, endIndex);
                    } else {
                        result = halfSearch(nums, target, startIndex, halfIndex);
                    }
                }
            }
        }
        return result;
    }


    @Test
    public void execute() {
        int[] nums = new int[]{1, 3, 5};
        int target = 5;
        int targetIndex = search1(nums, target);
        System.out.println(targetIndex);
    }


    /**
     * 不使用递归，使用循环
     *
     * @param nums
     * @param tar
     * @return
     */
    private int search1(int[] nums, int tar) {
        int si = 0, ei = nums.length - 1, hi = 0;
        while (si < ei) {
            hi = (si + ei) / 2;
            if ((tar >= nums[hi] && (tar <= nums[ei] || nums[hi] > nums[ei])) || (tar <= nums[hi] && nums[si] > nums[hi])) {
                if (si == hi) {
                    if (nums[ei] == tar) {
                        return ei;
                    }
                    break;
                } else {
                    si = hi;
                }
            } else {
                ei = hi;
            }
        }
        return nums.length > 0 && nums[hi] == tar ? hi : -1;
    }

}
