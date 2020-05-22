package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：shujie
 * @date ：2020/03/08
 * @description: 二叉树层次遍历
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 * 思路：
 * 最简单的解法就是递归，首先确认树非空，然后调用递归函数 helper(node, level)，参数是当前节点和节点的层次。程序过程如下：
 *
 * 输出列表称为 levels，当前最高层数就是列表的长度 len(levels)。
 * 比较访问节点所在的层次 level 和当前最高层次 len(levels) 的大小，如果前者更大就向 levels 添加一个空列表。
 * 将当前节点插入到对应层的列表 levels[level] 中。
 * 递归非空的孩子节点：helper(node.left / node.right, level + 1)。
 *
 */
public class levelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }

}
