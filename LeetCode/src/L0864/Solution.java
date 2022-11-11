package L0864;

import java.util.*;

public class Solution {

    public int shortestPathAllKeys(String[] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int keyCnt = 0;
        int row = grid.length, col = grid[0].length();
        int[][][] dist = new int[row][col][1 << 10];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Arrays.fill(dist[i][j], 0x3f3f3f3f);
                char c = grid[i].charAt(j);
                if (c == '@') {  
                    queue.add(new int[]{i, j, 0});
                    dist[i][j][0] = 0;
                } else if (Character.isLowerCase(c)) {
                    keyCnt++;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.pollFirst();
            int x = pos[0], y = pos[1], keyMask = pos[2],step = dist[x][y][keyMask];
            for (int[] di : dir) {
                int nx = x + di[0];
                int ny = y + di[1];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                char c = grid[nx].charAt(ny);
                // 如果是墙，则跳过
                if (c == '#') {
                    continue;
                }
                // 如果是锁，但是没有对应的钥匙，也跳过
                if (Character.isUpperCase(c) && ((keyMask >> (c - 'A') & 1) == 0)) {
                    continue;
                }
                int curKeyMask = keyMask;
                // 如果是钥匙，则扩充当前位置的钥匙数量
                if (Character.isLowerCase(c)) {
                    curKeyMask = curKeyMask | 1 << (c - 'a');
                }
                // 如果获取了所有钥匙，则返回步数
                if ((1 << keyCnt) - 1 == curKeyMask) {
                    return step + 1;
                }
                // 如果是其他情况（空格），则继续行走，对应步数 + 1
                if (step + 1 < dist[nx][ny][curKeyMask]) {
                    dist[nx][ny][curKeyMask] = step + 1;
                    queue.addLast(new int[]{nx, ny, curKeyMask});
                }
            }
        }
        return -1;
    }



}
