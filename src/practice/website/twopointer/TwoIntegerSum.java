package practice.website.twopointer;

public class TwoIntegerSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            }
            if (numbers[start] + numbers[end] > target) {
                end--;
            }
            if (numbers[start] + numbers[end] < target) {
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoIntegerSum sum = new TwoIntegerSum();
        int[] num = new int[] { 1, 2, 3, 4 };
        int target = 3;
        int[] res = sum.twoSum(num, target);
        System.out.println("res = [" + res[0] + "," + res[1] + "]");
    }
}
