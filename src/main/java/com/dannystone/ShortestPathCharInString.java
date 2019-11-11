package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/11 11:32 PM
 */
public class ShortestPathCharInString {
    public int[] shortestToChar(String S, char C) {
        //由于是一维度的，不是向左就是向右
        char[] chars = S.toCharArray();

        int[] distances = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int leftResult = leftFind(chars, i, C);
            int rightResult = rightFind(chars, i, C);
            //左边没有肯定在右边
            if (leftResult < 0) {
                distances[i] = rightResult;
            }else if (rightResult < 0) {
                distances[i] = leftResult;
            }else{
                distances[i] = Math.min(leftResult, rightResult);
            }

        }
        return distances;

    }

    public static int leftFind(char[] chars, int charIndex, char C) {
        //由于是一维度的，不是向左就是向右
        int findIndex = charIndex;
        while (findIndex >= 0) {
            if (chars[findIndex] == C) {
                return charIndex - findIndex;
            }
            findIndex--;
        }
        return -1;

    }

    public static int rightFind(char[] chars, int charIndex, char C) {
        //由于是一维度的，不是向左就是向右
        int findIndex = charIndex;
        while (findIndex < chars.length) {
            if (chars[findIndex] == C) {
                return findIndex - charIndex;
            }
            findIndex++;
        }
        return -1;
    }

    public static void main(String[] args){
        String s = "loveleetcode";
        char C = 'e';
        ShortestPathCharInString shortestPathCharInString = new ShortestPathCharInString();
        int[] ints = shortestPathCharInString.shortestToChar(s, C);

    }
}
