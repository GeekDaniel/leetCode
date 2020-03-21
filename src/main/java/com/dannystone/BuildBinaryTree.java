package com.dannystone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/17 6:47 PM
 */
public class BuildBinaryTree {
    /**
     * Definition for a binary tree next.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        int[] toIntArray(List<Integer> list) {
            int[] ret = new int[list.size()];
            int i = 0;
            for (Integer e : list)
                ret[i++] = e;
            return ret;
        }

        public TreeNode buildTreeWithRoot(int[] preorder, int[] inorder, TreeNode treeNode,boolean left) {
            if (preorder.length == 0) {
                return null;
            }

            //分成左右树
            int root = preorder[0];
            TreeNode rootNode=new TreeNode(root);
            if(treeNode!=null){
                if(left){
                    treeNode.left = rootNode;
                }else{
                    treeNode.right = rootNode;
                }
            }


            List<Integer> leftInorder = new ArrayList();
            List<Integer> rightInorder = new ArrayList();

            List<Integer> leftPreorder = new ArrayList();
            List<Integer> rightPreorder = new ArrayList();

            //取出左右 子中序数组
            boolean rootFound = false;
            for (int j = 0; j < inorder.length; j++) {
                if (!rootFound && inorder[j] != root) {
                    leftInorder.add(inorder[j]);
                }
                if (inorder[j] == root) {
                    rootFound = true;
                    continue;
                }
                if (rootFound && inorder[j] != root) {
                    rightInorder.add(inorder[j]);
                }

            }

            //取出左右 子前序数组
            for (int j = 0; j < preorder.length; j++) {
                if (leftInorder.contains(preorder[j])) {
                    leftPreorder.add(preorder[j]);
                }
                if (rightInorder.contains(preorder[j])) {
                    rightPreorder.add(preorder[j]);
                }
            }

            if (leftInorder.size() > 0) {
                buildTreeWithRoot(toIntArray(leftPreorder), toIntArray(leftInorder), rootNode,true);
            }

            if (rightInorder.size() > 0) {
                buildTreeWithRoot(toIntArray(rightPreorder), toIntArray(rightInorder), rootNode,false);
            }

            return rootNode;


        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }

            return buildTreeWithRoot(preorder, inorder, null,false);


        }
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Solution solution = new Solution();
        Solution.TreeNode treeNode = solution.buildTree(preorder, inorder);
        System.out.println();

       }
}
