package Leetcode_A_Z_Sheet;

import java.util.Arrays;

/**
 * 🔹 Leetcode 34: Find First and Last Position of Element in Sorted Array
 * 🔗 Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * ❓ Problem Statement:
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 * position of a given target value. If target is not found, return [-1, -1].
 *
 * 🔸 You must write an algorithm with O(log n) runtime complexity.
 *
 * --------------------------------------------------------------------------------------------------
 * 🧠 Intuition:
 * - The array is sorted, which suggests that Binary Search can be used (for O(log n) solutions).
 * - To find the **first and last occurrence**, we modify Binary Search:
 *   → Go left after finding target for first occurrence
 *   → Go right after finding target for last occurrence
 *
 * --------------------------------------------------------------------------------------------------
 * 🐌 Brute Force Approach:
 * - Loop from left to find the first index where nums[i] == target.
 * - Loop from right to find the last index where nums[j] == target.
 * - Time Complexity: O(n)
 * - Space Complexity: O(1)
 */
class Sol {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                arr[0] = i;
                break;
            }
        }
        if (arr[0] == -1) {
            return arr;
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                arr[1] = j;
                break;
            }
        }
        return arr;
    }
}

/**
 * ⚡ Optimized Approach (Binary Search)
 * - Use two separate binary searches to find:
 *   → First Occurrence
 *   → Last Occurrence
 *
 * - Time Complexity: O(log n)
 * - Space Complexity: O(1)
 *
 * 🔍 Dry Run Example:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * First Search:
 *  mid = 2 → 7 < 8 → start = 3
 *  mid = 4 → nums[4] == 8 → res = 4, end = 3
 *  mid = 3 → nums[3] == 8 → res = 3, end = 2 → stop → return 3
 *
 * Second Search:
 *  mid = 2 → 7 < 8 → start = 3
 *  mid = 4 → nums[4] == 8 → res = 4, start = 5
 *  mid = 5 → 10 > 8 → end = 4 → stop → return 4
 * Result: [3, 4]
 */
class Solu {
    public int[] searchRange(int[] nums, int target) {
        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);
        return new int[]{first, last};
    }

    public int searchFirst(int[] nums, int target) {
        int res = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                res = mid;
                end = mid - 1; // search in left half
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public int searchLast(int[] nums, int target) {
        int res = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                res = mid;
                start = mid + 1; // search in right half
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}

/**
 * 🧪 Driver Code to Test Both Approaches
 */
public class Leetcode34_FindFirstandLast {
    public static void main(String[] args) {

        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;

        // Brute force
        Sol brute = new Sol();
        int[] res1 = brute.searchRange(arr, target);
        System.out.println("🔹 Brute Force: " + Arrays.toString(res1));

        // Optimized
        Solu solu = new Solu();
        int[] res2 = solu.searchRange(arr, target);
        System.out.println("🔹 Optimized: Start Index = " + res2[0] + ", Last Index = " + res2[1]);
    }
}
