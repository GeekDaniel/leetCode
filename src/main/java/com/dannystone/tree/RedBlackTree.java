package com.dannystone.tree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Each node is either red or black.
 * The root is black. This rule is sometimes omitted. Since the root can always be changed from red to black, but not necessarily vice versa, this rule has little effect on analysis.
 * All leaves (NIL) are black.
 * If a node is red, then both its children are black.
 * Every path from a given node to any of its descendant NIL nodes goes through the same number of black nodes.
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/21 9:54 PM
 */
public class RedBlackTree {

    /**
     * 左旋的意思是将x节点的右节点y上升为它的parent，x节点作为它的左节点。
     * 达成上述效果我们需要解决两个问题
     * 1. x节点新的右节点哪里来？
     * 2. y节点的老的左节点该放到哪里？
     * <p>
     * 发现将"y节点的老的左节点" 作为"x节点新的右节点" 完美解决上面两个问题,最终效果依然遵循有序二叉树的 左子树所有元素<parent<右子树所有元素
     *
     * @param t
     * @param x
     */
    public static void leftRotate(RedBlackTree t, RedBlackTreeNode x) {
        BinaryTreeNode y = x.right;
        x.right = y.left;
        if (y.left != RedBlackTreeNode.NIL) {
            y.left = x;
        }

    }
}
