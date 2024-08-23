package practice.website.linkedlist;

public class MergeList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = null;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            res = list1;
            list1 = list1.next;
        } else {
            res = list2;
            list2 = list2.next;
        }
        ListNode temp = res;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else if (list2.val <= list1.val) {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 == null) {
            res.next = list2;
        }
        if (list2 == null) {
            res.next = list1;
        }
        return temp;
    }

    public static void main(String[] args) {
        MergeList merge = new MergeList();
        merge.printLinkedList(
                merge.mergeTwoLists(
                        merge.createList(new int[] { 1, 2, 4 }),
                        merge.createList(new int[] { 1, 3, 5 })));
        System.out.println("=================");
        merge.printLinkedList(
                merge.mergeTwoLists(
                        merge.createList(new int[] {}),
                        merge.createList(new int[] { 1, 3, 5 })));
    }

    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
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
