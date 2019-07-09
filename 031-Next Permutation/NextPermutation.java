import org.junit.Test;

/**
 * @author guyang <guyang@ebnew.com>
 * @description 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @date 2019-06-28 11:27
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int temp;
        int maxIndex = nums.length - 1;
        for (int i = maxIndex; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                temp = nums[i - 1];
                int targetIndex = halfSearch(nums, i, maxIndex, temp);
                nums[i - 1] = nums[targetIndex];
                nums[targetIndex] = temp;
                reverse(nums, i, maxIndex);
                return;
            }
        }
        reverse(nums, 0, maxIndex);
    }

    /**
     * 数组反转
     *
     * @param nums
     * @param startIndex
     * @param endIndex
     */
    private void reverse(int[] nums, int startIndex, int endIndex) {
        int temp;
        while (startIndex < endIndex) {
            temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    /**
     * 二分查找 数组是倒序的，查到比value大紧临的值的下标
     *  注意数组内元素有可能重复
     * @param nums
     * @param startIndex
     * @param endIndex
     * @param targetValue
     * @return
     */
    private int halfSearch(int[] nums, int startIndex, int endIndex, int targetValue) {
        int targetIndex = -1;
        int i = (startIndex + endIndex) / 2;
        if (nums[i] <= targetValue) {
            targetIndex = halfSearch(nums, startIndex, i, targetValue);
        } else {
            if (startIndex == endIndex || endIndex - startIndex == 1) {
                if (nums[endIndex] > targetValue) {
                    return endIndex;
                } else {
                    return startIndex;
                }
            }
            targetIndex = halfSearch(nums, i, endIndex, targetValue);
        }
        return targetIndex;
    }


    @Test
    public void execute() {
        int[] nums = {4,2,0,2,3,2,0};
        nextPermutation(nums);
        System.out.println(nums);
    }

}
