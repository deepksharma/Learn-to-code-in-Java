//package striver;


import java.util.HashMap;

class AppearedOnce {

    // =============================
    // ✅ Brute Force Approach - O(n^2)
    // =============================
    public static int findNumBrute(int[] arr) {
        int n = arr.length;

        // For each element, count its frequency
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            // Return the first element which appears only once
            if (count == 1) {
                return arr[i];
            }
        }

        return -1;
    }

    // =============================
    // ✅ Better Approach using HashMap - O(n) Time | O(n) Space
    // =============================
    public static int findNumBetter(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Store frequency of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Return the element which has frequency 1
        for (int num : arr) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    // =============================
    // ✅ Optimal Approach using XOR - O(n) Time | O(1) Space
    // NOTE: Only works when all elements appear twice except ONE.
    // =============================
    public static int findNumOptimal(int[] arr) {
        int xor = 0;

        // XOR of a number with itself is 0
        // XOR of a number with 0 is the number itself
        for (int num : arr) {
            xor ^= num;
        }

        return xor;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 2, 3, 4, 4 };

        System.out.println("Input Array: {1, 2, 1, 2, 3, 4, 4}");

        // Brute Force
        int res1 = findNumBrute(arr);
        System.out.println("Brute Force Result: " + res1);

        // Better (HashMap)
        int res2 = findNumBetter(arr);
        System.out.println("Better (HashMap) Result: " + res2);

        // Optimal (XOR) - Only use if condition is: every element appears twice except one
        int[] xorArr = {1, 2, 1, 2, 3};
        int res3 = findNumOptimal(xorArr);
        System.out.println("Optimal (XOR) Result (for {1,2,1,2,3}): " + res3);
    }
}

/*
====================
🧠 Intuition:
====================
We need to find the element that appears only once in the array.

- Brute Force: Count frequency using nested loops (slowest)
- Better: Use HashMap to count and check frequency
- Optimal: Use XOR only when guaranteed that only one number appears once and rest appear exactly twice

====================
🧪 Dry Run on {1, 2, 1, 2, 3, 4, 4}:
====================
1 -> appears 2 times
2 -> appears 2 times
3 -> appears 1 time ✅
4 -> appears 2 times

Answer => 3
*/
