import java.util.Scanner;

public class ShppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 总钱数
        int m = scanner.nextInt(); // 物品个数
        int[] v = new int[m + 1]; // 物品价格
        int[] p = new int[m + 1]; // 物品重要度
        int[] q = new int[m + 1]; // 物品类别

        // 记录主件的附件个数和重要度
        int[] attachCount = new int[m + 1];
        int[] attachP = new int[m + 1];

        // 读取物品基本数据
        for (int i = 1; i <= m; i++) {
            v[i] = scanner.nextInt() / 10; // 价格是10的倍数，方便后续计算
            p[i] = scanner.nextInt();
            q[i] = scanner.nextInt();
            if (q[i] > 0) {
                attachCount[q[i]]++;
                attachP[q[i]] = p[i];
            }
        }

        // 动态规划
        int[][] dp = new int[m + 1][N + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= N; j++) {
                if (q[i] == 0) { // 主件
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                    if (j >= v[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + v[i] * p[i]);
                    }
                } else { // 附件
                    if (attachCount[q[i]] == 1) { // 附件所属主件只有一个附件
                        if (j >= v[i] + v[q[i]]) { // 附件所属主件和附件一起购买
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + v[i] * attachP[q[i]]);
                        }
                    } else { // 附件所属主件有两个附件
                        if (j >= v[i] + v[q[i]]) { // 附件所属主件和附件一起购买
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + v[i] * attachP[q[i]]);
                        }
                        if (j >= v[i] + v[q[i]] * 2) { // 附件所属主件和两个附件一起购买
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i] - v[q[i]]] + v[i] * attachP[q[i]] + v[q[i]] * attachP[q[i]]);
                        }
                    }
                }
            }
        }

        // 输出结果
        System.out.println(dp[m][N] * 10); // 价格恢复为原来的倍数
    }
}
