/*
Leetcode 2095: Delete the Middle Node of a Linked List

Usage Example:
public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
    Leetcode2095_Delete_Middle_Node solution = new Leetcode2095_Delete_Middle_Node();
    head = solution.deleteMiddle(head);
    // Print the modified list here if needed.
}

🟡 Problem:
You're given the head of a singly linked list. Your task is to delete the middle node and return the modified list. 
Middle is considered as the ⌊n / 2⌋th node (0-based index).

🧠 Intuition:
We'll use the slow and fast pointer technique. The slow pointer will land at the middle when the fast pointer reaches the end. Once we find the middle, we simply skip it in the list.

💡 Approaches:

🔸 Brute Force:
1. First, count the total number of nodes.
2. Then, again loop to the (n/2)-th node and skip it.
- Time: O(n), Space: O(1)

🔸 Better Approach:
Same logic but using a single traversal with two pointers (slow and fast).
- Time: O(n), Space: O(1)

🔸 Optimal:
This is actually the better approach itself. The idea is already optimal using two pointers.

📘 Dry Run Example:
Input: [1, 2, 3, 4]
Pointers move:
- slow → 1 → 2 → 3 → 4
- fast → 1 → 3 → null
Middle = 2, remove it → Output: [1, 3, 4]
*/

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Leetcode2095_Delete_Middle_Node {

    // Brute Force Approach
    public ListNode deleteMiddleBrute(ListNode head) {
        if (head == null || head.next == null) return null;

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;
        if (mid == 0) return head.next;

        temp = head;
        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
    

    //  Foucs on this approach(Better Approach)

    // Better / Optimal Approach using Fast & Slow pointer
    public ListNode deleteMiddleBetter(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }


}
