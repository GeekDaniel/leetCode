package com.dannystone.tree;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/21 10:24 AM
 */
@Data
public class BinaryTree {
    private Node root;

    public static class Node {
        private int value;
        private Node left;
        private Node right;
    }
}
