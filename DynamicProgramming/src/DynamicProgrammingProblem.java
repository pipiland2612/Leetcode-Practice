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

    //Longest Palindromic Substring
    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int index = 0, maxLength = 0;
        for (int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1] == 1)){
                    dp[i][j] = 1;
                    if(maxLength < j - i + 1){
                        maxLength = j - i + 1;
                        index = i;
                    }
                }
            }
        }
        return s.substring(index, index + maxLength);
    }

    // Palindromic substrings
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1] == 1)){
                    dp[i][j] = 1;
                    count ++;
                }
            }
        }
        return count;
    }

    //Decode ways
    public static int numDecodings(String s) {
        int n = s.length();
        int[] count1 = new int[n], count2 = new int[n];
        if(s.charAt(0) != '0'){
            count1[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            // Category 1
            int currNum = Integer.parseInt(String.valueOf(s.charAt(i)));
            if(currNum > 0 && currNum <= 26){
                count1[i] = count1[i - 1] + count2[i - 1];
            }
            // Category 2
            int curr = Integer.parseInt(s.substring(i - 1, i + 1));
            if(curr > 0 && curr <= 26){
                count2[i] = count1[i - 1];
            }
        }

        return count1[n - 1] + count2[n - 1];
    }
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("909"));
        System.out.println(numDecodings("20419"));
    }

}
