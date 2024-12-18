package DynamicProgramming.test;

import DynamicProgramming.src.DynamicProgrammingProblem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicProgrammingProblemTest {

    DynamicProgrammingProblem dpProblem = new DynamicProgrammingProblem();

    // Test cases for climbStairs
    @Test
    void testClimbStairs() {
        assertEquals(2, dpProblem.climbStairs(2)); // 1 step + 1 step, or 2 steps
        assertEquals(3, dpProblem.climbStairs(3)); // 1+1+1, 1+2, 2+1
    }

    // Test cases for minCostClimbingStairs
    @Test
    void testMinCostClimbingStairs() {
        assertEquals(15, dpProblem.minCostClimbingStairs(new int[]{10, 15, 20}));
        assertEquals(6, dpProblem.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    // Test cases for rob (House Robber 1)
    @Test
    void testRob() {
        assertEquals(4, dpProblem.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, dpProblem.rob(new int[]{2, 7, 9, 3, 1}));
    }

    // Test cases for rob2 (House Robber 2)
    @Test
    void testRob2() {
        assertEquals(3, dpProblem.rob2(new int[]{2, 3, 2}));
        assertEquals(15, dpProblem.rob2(new int[]{2,9,8,3,6}));
    }

    // Test cases for longestPalindrome
    @Test
    void testLongestPalindrome() {
        assertEquals("aba", dpProblem.longestPalindrome("babad")); // Can also be "aba"
        assertEquals("bb", dpProblem.longestPalindrome("cbbd"));
    }

    // Test cases for countSubstrings (Palindromic substrings)
    @Test
    void testCountSubstrings() {
        assertEquals(3, dpProblem.countSubstrings("abc")); // "a", "b", "c"
        assertEquals(6, dpProblem.countSubstrings("aaa")); // "a", "a", "a", "aa", "aa", "aaa"
    }

    // Test cases for numDecodings (Decode ways)
    @Test
    void testNumDecodings() {
        assertEquals(2, dpProblem.numDecodings("12")); // "AB" or "L"
        assertEquals(3, dpProblem.numDecodings("226")); // "BZ", "VF", or "BBF"
    }

    // Test cases for coinChange
    @Test
    void testCoinChange() {
        assertEquals(3, dpProblem.coinChange(new int[]{1, 2, 5}, 11)); // 5+5+1
        assertEquals(-1, dpProblem.coinChange(new int[]{2}, 3)); // No possible change
    }

    // Test cases for maxProduct (Maximum product subarray)
    @Test
    void testMaxProduct() {
        assertEquals(6, dpProblem.maxProduct(new int[]{2, 3, -2, 4})); // Subarray [2, 3]
        assertEquals(0, dpProblem.maxProduct(new int[]{-2, 0, -1})); // Subarray [0]
    }
}
