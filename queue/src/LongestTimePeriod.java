import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestTimePeriod {

    //    public static List<int[]> findLongestTimePeriods(int[] failureRates, int minAverageLost) {
//        int n = failureRates.length;
//        List<int[]> results = new ArrayList<>();
//        int maxPeriod = 0;
//
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            int periodLength = 0;
//            int endIndex = i;
//
//            while (endIndex < n) {
//                sum += failureRates[endIndex];
//                periodLength++;
//
//                // 如果失败率大于 minAverageLost，则跳出循环
//                if (sum / periodLength > minAverageLost) {
//                    break;
//                }
//
//                // 如果当前时间段长度大于等于之前记录的最长时间段，则将当前时间段添加到结果中
//                if (periodLength >= maxPeriod) {
//                    if (periodLength > maxPeriod) {
//                        maxPeriod = periodLength;
//                        results.clear(); // 清空之前的结果
//                    }
//                    results.add(new int[]{i, endIndex}); // 添加当前时间段到结果中
//                }
//
//                endIndex++;
//            }
//        }
//
//        return results;
    public static int[] findLongestTimePeriods(int minAverageLost, int[] failureRates) {

        int sum = 0;
        int endInx = -1;
        int range = 1;
        int[] result = new int[2];

        for (int i = 0; i < failureRates.length; i++) {
            if (endInx < failureRates.length) {
                sum += failureRates[i];
                if (sum / range > minAverageLost) {
                    break;
                }
                endInx++;
                System.out.println(endInx);
                range++;
            }
        }
        if (endInx != -1) {
            result[0] = 0;
            result[1] = endInx;
        } else {
            result = null;
        }
        return result;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int minAverageLost = Integer.parseInt(in.nextLine());

        String[] failureRatesStr = in.nextLine().split(" ");

        int[] failureRates = new int[failureRatesStr.length];

        for (int i = 0; i < failureRatesStr.length; i++) {
            failureRates[i] = Integer.parseInt(failureRatesStr[i]);
        }

        int[] result = findLongestTimePeriods(minAverageLost, failureRates);

        if (result != null) {
            System.out.println("开始索引为: " + result[0] + ", 结束索引为: " + result[1]);

        } else {
            System.out.println("未找到符合条件的时间段。");
        }
    }
}
