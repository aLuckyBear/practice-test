package other;

import java.util.Arrays;

/**
 * @author ：shujie
 * @date ：2020/03/16
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        char[][] array = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'h', 'i', 'j'},
        };

        boolean result = solution(array, "abc");
        System.out.println("result = " + result);
    }

    public static String test(String s) {
        String[] split = s.split("-");
        System.out.println(Arrays.toString(split));
        return "";
    }

    public static boolean solution(char[][] array, String input) {
        if (array.length == 0) {
            return false;
        }

        int height = array.length;
        int width = array.length;

        char[] array2 = input.toCharArray();

        if (array2.length == 0) {
            return true;
        }

        int i = 0;
        int j = 0;
        boolean flag = false;

        for (int p = 0; p < height; p++) {
            for (int q = 0; q < width; q++) {
                if (array[p][q] == array2[0]) {
                    i = p;
                    j = q;
                    flag = true;
                }
            }
        }

        if (flag && array2.length == 1) {
            return true;
        }

        if (!flag) {
            return false;
        }

        // TODO


        return false;
    }
}
