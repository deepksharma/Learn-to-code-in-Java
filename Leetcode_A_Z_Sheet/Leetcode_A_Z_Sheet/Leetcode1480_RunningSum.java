package Leetcode_A_Z_Sheet;



/**
 * 🔹 Leetcode 1480: Running Sum of 1D Array
 * 🔗 Link: https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * ❓ Problem Statement:
 * Given an array `nums`, return an array `runningSum` such that:
 * - runningSum[i] = nums[0] + nums[1] + ... + nums[i]
 *
 * 📌 Example:
 * Input:  nums = [1,2,3,4]
 * Output: [1,3,6,10]
 *
 * ✅ Constraints:
 * - 1 <= nums.length <= 1000
 * - -10^6 <= nums[i] <= 10^6
 *
 * --------------------------------------------------------------------------------------------------
 * 🧠 Intuition:
 * We want to maintain a running sum. At each index, add current element to a cumulative sum
 * and return all the intermediate sums in a result array.
 *
 * --------------------------------------------------------------------------------------------------
 * 🐌 Brute Force:
 * - Use a separate array `temp` to store results.
 * - Maintain a sum variable and update result at each step.
 *
 * 🔹 Time Complexity: O(n)
 * 🔹 Space Complexity: O(n) → using extra array for result
 *
 * --------------------------------------------------------------------------------------------------
 * 🧪 Better / Optimized (In-place):
 * - Reuse the input array `nums` to store running sums.
 * - Saves memory by not creating a new array.
 *
 * 🔹 Time Complexity: O(n)
 * 🔹 Space Complexity: O(1) → no extra space (modifying input)
 *
 * --------------------------------------------------------------------------------------------------
 * 🔍 Dry Run:
 * Input: [1, 2, 3, 4, 5]
 *
 * Step-by-step:
 * i=1: nums[1] = nums[1] + nums[0] = 2+1 = 3 → nums = [1,3,3,4,5]
 * i=2: nums[2] = 3+3 = 6 → nums = [1,3,6,4,5]
 * i=3: nums[3] = 4+6 = 10 → nums = [1,3,6,10,5]
 * i=4: nums[4] = 5+10 = 15 → nums = [1,3,6,10,15]
 *
 * Output: [1, 3, 6, 10, 15]
 */
class Solution {

    // 🔹 Brute Force
    public int[] runningSumBrute(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            temp[i] = sum;
        }
        return temp;
    }

    // 🔹 Optimized (In-place)
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}

/**
 * 🧪 Driver Code
 */
public class Leetcode1480_RunningSum {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] result1 = sol.runningSumBrute(arr1.clone()); // use clone to preserve original

        System.out.print("🔹 Brute Force Output: ");
        for (int val : result1) {
            System.out.print(val + " ");
        }

        int[] arr2 = {1, 2, 3, 4, 5};
        int[] result2 = sol.runningSum(arr2);

        System.out.print("\n🔹 Optimized In-place Output: ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
    }
}


