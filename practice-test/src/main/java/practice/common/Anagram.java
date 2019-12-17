package practice.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：shujie
 * @date ：2019/12/16
 * @description: 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {

        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();

        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();

        for (char i : array1) {
            if (map1.containsKey(i)) {
                Integer value = map1.get(i);
                map1.put(i, value + 1);
            } else {
                map1.put(i, 1);
            }
        }

        for (char i : array2) {
            if (map2.containsKey(i)) {
                Integer value = map2.get(i);
                map2.put(i, value + 1);
            } else {
                map2.put(i, 1);
            }
        }

        if (map1.size() != map2.size()) {
            return false;
        }

        for (Character character : map1.keySet()) {
            Integer num = map1.get(character);
            if (!map2.containsKey(character) || !map2.get(character).equals(num)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 利用题目中字母的条件，ascii码只有256位。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] chars = new int[256];

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        for (char str : chars1) {
            chars[str] = chars[str] + 1;
        }

        for (char str : chars2) {
            chars[str] = chars[str] - 1;
        }

        for (int str : chars) {
            if (str != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        anagram.isAnagram("anagram", "nagaram");

    }

}
