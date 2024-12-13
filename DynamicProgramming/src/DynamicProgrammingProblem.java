public class DynamicProgrammingProblem {
    // Climb stairs Problem
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= 2; i++) {
            dp[i] = i;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Min cost problems
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = cost[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1] ,dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    // House robber 1
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    // House robber 2
    private static int helper(int[] nums, int start, int end){
        int n = end - start + 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + start - 1]);
        }
        return dp[n];
    }
    public static int rob2(int[] nums){
        int n = nums.length;
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
}
