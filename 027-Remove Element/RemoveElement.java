import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @date 2019/1/14 10:48$
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }

    @Test
    public void execute(){

        System.out.println(removeElement(new int[]{3,2,2,3},3));
    }

}
