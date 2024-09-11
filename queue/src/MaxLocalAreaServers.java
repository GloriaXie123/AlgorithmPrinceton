import java.util.Scanner;

public class MaxLocalAreaServers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的行数和列数
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 读取服务器信息矩阵
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 计算最大局域网包含的服务器个数
        int maxLocalAreaServers = findMaxLocalAreaServers(grid);

        // 输出结果
        System.out.println(maxLocalAreaServers);

        scanner.close();
    }

    // 计算最大局域网包含的服务器个数的方法
    public static int findMaxLocalAreaServers(int[][] grid) {
        int maxServers = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // 计算每一行和每一列中服务器的数量
        int[] rowServers = new int[rows];
        int[] colServers = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    rowServers[i]++;
                    colServers[j]++;
                }
            }
        }

        // 计算最大局域网包含的服务器个数
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxServers = Math.max(maxServers, rowServers[i] + colServers[j] - 1);
                }
            }
        }

        return maxServers;
    }
}
