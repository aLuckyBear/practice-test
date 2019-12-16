package practice.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：shujie
 * @date ：2019/12/16
 * @description: 两数之和
 */
public class SumTwo {

    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }

        return array;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] array = new int[2];
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(size);
        for (int i = 0; i < size; i++) {
            int value = nums[i];
            if (map.containsKey(target - value)) {
                array[0] = i;
                array[1] = map.get(target - value);
                return array;
            }
            map.put(nums[i], i);
        }
        return array;
    }
}
