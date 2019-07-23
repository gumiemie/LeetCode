import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @date 2019/1/14 10:13$
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int result = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i - 1]) {
                nums[result] = nums[i];
                result++;
            }
            i++;
        }

        return result;
    }

    @Test
    public void execute() {

        System.out.println(removeDuplicates(new int[]{1,1}));

    }

}
