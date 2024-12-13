public class Test {
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
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
