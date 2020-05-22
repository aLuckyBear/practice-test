package practice;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：shujie
 * @date ：2020/03/08
 * @description: 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList();
        for (int k = 0; k < nums.length - 2; k++) {
            // k一开始指向数组最左边
            if (nums[k] > 0) {
                break;
            }
            // 跳过重复数值
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }

            int i = k + 1;
            int j = nums.length - 1;
            while(i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while(i < j && nums[i] == nums[++i]) {
                        ;
                    }
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]) {
                        ;
                    }
                } else {
                    list.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]) {
                        ;
                    }
                    while(i < j && nums[j] == nums[--j]) {
                        ;
                    }
                }
            }

        }
        return list;
    }

}
