import java.util.HashSet;

/*
 * ✅ Problem:
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * 
 * Do not modify the linked list.
 * 
 * ---------------------------------------------------------
 * ✅ Intuition:
 * A cycle exists in a linked list when a node points back to a previous node.
 * We are asked to return the node where the cycle starts (if it exists).
 * 
 * Approaches:
 * 1. Brute Force: Store visited nodes manually and compare each time (O(N^2))
 * 2. Better: Use HashSet to track visited nodes (O(N) time, O(N) space)
 * 3. Optimal: Floyd’s Cycle Detection Algorithm (O(N) time, O(1) space)
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Leetcode142_Linked_List_CycleII {

    // ---------------------------------------------------------
    // ✅ 1. Brute Force Approach (for theory) - O(N^2) Time, O(1) Space
    // ---------------------------------------------------------
    public ListNode detectCycleBrute(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode checker = head;
            while (checker != current) {
                if (checker == current.next) {
                    return checker; // cycle start
                }
                checker = checker.next;
            }
            current = current.next;
        }
        return null;
    }

    // ---------------------------------------------------------
    // ✅ 2. Better Approach – Using HashSet - O(N) Time, O(N) Space
    // ---------------------------------------------------------
    public ListNode detectCycleHashSet(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return current; // Cycle detected – this is the start node
            }
            visited.add(current);
            current = current.next;
        }

        return null; // No cycle found
    }

    // ---------------------------------------------------------
    // ✅ 3. Optimal Approach – Floyd’s Cycle Detection Algorithm
    // ---------------------------------------------------------
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, cycle is detected
            if (slow == fast) {
                // Step 2: Find the start of the cycle
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start; // This is the start of the cycle
            }
        }

        return null; // No cycle
    }

    // ---------------------------------------------------------
    // ✅ Dry Run Example:
    // Input: 3 -> 2 -> 0 -> -4
    //              ↑        ↓
    //              ←←←←←←←←←
    //
    // Fast moves 2 steps, slow moves 1 step.
    // Eventually they meet inside the loop.
    // After meeting, move one pointer to head.
    // Move both one step at a time; they meet at cycle start.
    // ---------------------------------------------------------
}
