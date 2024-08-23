package practice.website.linkedlist;

public class CycleDetection {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast && slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetection cycle = new CycleDetection();
        ListNode list = cycle.createList(new int[] { 1, 2, 3, 4 });
        list.next.next.next = list.next;
        System.out.println(cycle.hasCycle(list));
    }

    public ListNode createList(int[] nums) {
        ListNode z = null;
        for (int index = nums.length - 1; index >= 0; index--) {
            ListNode y = new ListNode(nums[index], z);
            z = y;
        }
        return z;
    }
}
