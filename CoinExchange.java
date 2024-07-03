package pattern;

import java.util.*;
//Rajveer singh
public class CoinExchange {
    public static int minCoins(int coins[], int m, int V) {
        int[] dp = new int[V + 1];
        dp[0] = 0;
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    int sub_res = dp[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i]) {
                        dp[i] = sub_res + 1;
                    }
                }
            }
        }
        return dp[V] == Integer.MAX_VALUE ? -1 : dp[V];
    }
    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int m = coins.length;
        int V = 11;
        int result = minCoins(coins, m, V);
        if (result != -1) {
            System.out.println("Minimum coins required to make " + V + " is " + result);
        } else {
            System.out.println("It's not possible to make " + V + " with the given coin denominations.");
            System.out.println("\n"+"RAJVEER SINGH "  );
            System.out.println("22SCSE10341 ");
        }
    }
}
