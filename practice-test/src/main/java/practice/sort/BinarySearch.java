package practice.sort;

/**
 * @author ：shujie
 * @date ：2020/04/13
 * @description: 二分查找
 */
public class BinarySearch {

    /**
     * 递归
     * @param array
     * @param low
     * @param high
     * @param target
     * @return
     */
    public int binarySearch(int[] array, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (array[mid] > target) {
            return binarySearch(array, low, mid - 1, target);
        }
        if (array[mid] < target) {
            return binarySearch(array, mid + 1, high, target);
        }
        return mid;
    }

    public int binarySearchWithoutRecursion(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
