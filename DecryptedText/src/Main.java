import java.util.Scanner;
import java.util.Stack;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();

            int[][] grid = new int[m][n];

            int result = getMaximumGold(grid, k);
            System.out.println(result);

        }

    }

    public static int getMaximumGold(int[][] grid, int k) {
        // boolean[][] visited = new boolean[grid.length][grid[0].length];

        // return dfs(grid, 0, 0, k, visited);

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j =0; j < n;j++){
                dp[i][j] = -1;//表示未访问
            }
        }

        int maxGold = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxGold = Math.max(maxGold, dfs(grid, i, j, k, dp));
            }
        }

        return maxGold;

    }

    private static int dfs(int[][] grid, int i, int j, int k, int[][] dp){
        int m = grid.length;
        int n = grid[0].length;

        int maxGold = 0;
        dp[i][j] = grid[i][j];

        while(true){
            boolean updated = false;

            for(int x = 0; x < m; x++){
                for(int y =0; y < n; y ++){
                    if(dp[x][y] == -1 && (x > 0 && dp[x-1][y] != -1 || x < m-1 && dp[x +1][y] != -1 ||
                            y > 0 && dp[x][y -1] != -1 || y < n-1 && dp[x][y+1] != -1) &&
                            digitSum(x) + digitSum(y) <= k){
                        dp[x][y] = grid[x][y] + Math.max(
                                Math.max(x > 0 ? dp[x -1][y] : 0, x < m -1? dp[x +1][y] : 0),
                                Math.max(y > 0 ? dp[x][y-1] : 0, x < m -1? dp[x][y+1] : 0)
                        );
                        updated = true;
                        maxGold = Math.max(maxGold, dp[x][y]);
                    }
                }
            }

            if(!updated){
                break;
            }
        }



        return maxGold;



//        if(dp[i][j] != 0){
//            return dp[i][j];
//        }
//
//        int gold = grid[i][j];
//        gold+= dfs(grid, i+1, j, k, dp);
//        gold+= dfs(grid, i-1, j, k, dp);
//        gold+= dfs(grid, i, j+1, k, dp);
//        gold+= dfs(grid, i, j-1, k, dp);
//
//        dp[i][j] = gold;
//
//        return gold;

    }

    private static int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}