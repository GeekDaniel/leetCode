package com.dannystone.tree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/21 9:56 PM
 */
public class RedBlackTreeNode extends BinaryTreeNode {
    /**
     * 0 red; 1 black
     */
    private int color = 0;

    RedBlackTreeNode(int x) {
        super(x);
    }
}
