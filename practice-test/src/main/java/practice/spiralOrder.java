package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：shujie
 * @date ：2020/03/08
 * @description: 螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class spiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int height = matrix.length;
        if (height == 0) {
            return list;
        }
        int width = matrix[0].length;

        int l1 = 0; int l2 = height - 1;
        int r1 = 0; int r2 = width - 1;

        while (l1 <= l2 && r1 <= r2) {
            for (int i = r1; i <= r2; i ++) {
                list.add(matrix[l1][i]);
            }
            for (int i = l1+1; i <= l2; i++) {
                list.add(matrix[i][r2]);
            }
            if (l1 < l2 && r1 < r2) {
                for (int i = r2 -1; i >= r1; i--) {
                    list.add(matrix[l2][i]);
                }
                for (int i = l2 -1; i >= l1 + 1; i--) {
                    list.add(matrix[i][r1]);
                }
            }
            r1++;
            r2--;
            l1++;
            l2--;
        }
        return list;
    }

}
