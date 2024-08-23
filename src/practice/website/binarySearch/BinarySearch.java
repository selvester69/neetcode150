package practice.website.binarySearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int resIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                resIndex = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return resIndex;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        System.out.println(search.search(new int[] { -1, 0, 2, 4, 6, 8 }, 4));
        System.out.println(search.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
        System.out.println(search.search(new int[] { -1, 0, 3, 5, 9, 12 }, 13));
    }
}
