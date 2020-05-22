package practice.common;

/**
 * @author ：shujie
 * @date ：2019/12/24
 * @description: 二分法
 */
public class BinarySearch {

    /**
     * 常规版
     * 搜索一个数，如果存在，返回其索引，否则返回 -1。
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧边界的二分搜索
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchLeft(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        // target 比所有数都大
        if (left == nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    /**
     * 寻找左右边界的二分搜索
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchRight(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left == 0) {
            return -1;
        }

        // 注意
        return nums[right - 1] == target ? (right - 1) : -1;
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] array = {-1, -1};
        array[0] = searchLeft(nums, target);
        array[1] = searchRight(nums, target);
        return array;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        ListNode listNode = listNode1;

        listNode1 = listNode2;

//        System.out.println("listNode = " + JSON.toJSONString(listNode));

        int a = -1;
        int b = 1;

        int result = a ^ b;
        System.out.println("result = " + Integer.toBinaryString(result));
        int count = 0;
        while (result != 0) {
            if (result % 2 != 0) {
                count++;
            }
            result = result >>> 1;
            System.out.println("result = " + Integer.toBinaryString(result));
        }

        System.out.println("count = " + count);
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
