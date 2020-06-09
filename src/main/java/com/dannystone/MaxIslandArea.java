package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * <p>
 * 解题思路：
 * <p>
 * 我们想知道网格中每个连通形状的面积，然后取最大值。
 * <p>
 * 如果我们在一个土地上，以 4 个方向探索与之相连的每一个土地（以及与这些土地相连的土地），那么探索过的土地总数将是该连通形状的面积。
 * <p>
 * 为了确保每个土地访问不超过一次，我们每次经过一块土地时，将这块土地的值置为 0。这样我们就不会多次访问同一土地。
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/6/9 3:19 PM
 */
public class MaxIslandArea {

    int max(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, DFS(grid, i, j));
            }
        }
        return max;

    }

    int[][] move = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    /**
     * x,y 为中心点
     *
     * @param grid
     * @param x
     * @param y
     * @return
     */
    int DFS(int[][] grid, int x, int y) {
        int area = 0;
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;

        //注意这里的row col 和xy的对应关系，如果按照直角坐标系的映射，很容易倒了
        if (x < 0 || y < 0 || x >= row|| y >= col) {
            return 0;
        }

        if (grid[x][y] == 1) {
            area++;
            grid[x][y] = 0;

            area+=DFS(grid, x + move[0][0], y + move[0][1]);

            area+=DFS(grid, x + move[1][0], y + move[1][1]);

            area+=DFS(grid, x + move[2][0], y + move[2][1]);

            area+=DFS(grid, x + move[3][0], y + move[3][1]);
        }

        return area;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        MaxIslandArea maxIslandArea = new MaxIslandArea();
        System.out.println(maxIslandArea.max(grid));

    }
}
