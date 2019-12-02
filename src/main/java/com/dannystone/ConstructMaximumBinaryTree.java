package com.dannystone;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/24 9:15 PM
 */
public class ConstructMaximumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //找出最大值，划分左右子树
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        return getChildMaximumBinaryTree(nums, start, end);
    }

    private TreeNode getChildMaximumBinaryTree(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        //找到最大值作为子树的根节点
        int[] sorted = Arrays.copyOfRange(nums, start, end + 1);
        Arrays.sort(sorted);
        int max = sorted[nums.length - 1];

        int maxIndex = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] == max) {
                maxIndex = i;
                break;
            }
        }

        TreeNode treeNode = new TreeNode(max);
        //求左子树

        if (maxIndex - 1 < start) {
            treeNode.left = null;
        }
        treeNode.left = getChildMaximumBinaryTree(nums, start, maxIndex - 1);

        //求右子树
        if (maxIndex + 1 > end) {
            treeNode.right = null;
        }
        treeNode.right = getChildMaximumBinaryTree(nums, maxIndex + 1, end);

        return treeNode;
    }
}
