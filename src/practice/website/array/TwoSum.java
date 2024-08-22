package practice.website.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (!hm.containsKey(val)) {
                hm.put(nums[i], i);
            } else {
                if (i < hm.get(val)) {
                    res[0] = i;
                    res[i] = hm.get(val);
                } else {
                    res[0] = hm.get(val);
                    res[1] = i;
                }
            }
        }

        return res;
    }

    @Test
    public void testTwoSumWithValidInput() {
        int[] nums = { 3, 4, 5, 6 };
        int target = 7;
        int[] result = twoSum(nums, target);
        assertArrayEquals(new int[] { 0, 1 }, result, "The indices for target 9 should be [0, 1]");
    }

    @Test
    public void testTwoSumWithMultipleSolutions() {
        int[] nums = { 1, 3, 3, 6 };
        int target = 6;
        int[] result = twoSum(nums, target);
        assertArrayEquals(new int[] { 1, 2 }, result, "The indices for target 6 could be [1, 2]");
    }

    @Test
    public void testTwoSumWithNegativeNumbers() {
        int[] nums = { -3, 4, 3, 90 };
        int target = 0;
        int[] result = twoSum(nums, target);
        assertArrayEquals(new int[] { 0, 2 }, result, "The indices for target 0 should be [0, 2]");
    }

    @Test
    public void testTwoSumWithNoSolution() {
        int[] nums = { 1, 2, 3, 4 };
        int target = 10;
        assertThrows(IllegalArgumentException.class, () -> {
            twoSum(nums, target);
        }, "An exception should be thrown when no solution exists");
    }

    @Test
    public void testTwoSumWithSingleElementArray() {
        int[] nums = { 1 };
        int target = 1;
        assertThrows(IllegalArgumentException.class, () -> {
            twoSum(nums, target);
        }, "An exception should be thrown when the array has less than two elements");
    }

    @Test
    public void testTwoSumWithIdenticalNumbers() {
        int[] nums = { 5, 5, 11, 15 };
        int target = 10;
        int[] result = twoSum(nums, target);
        assertArrayEquals(new int[] { 0, 1 }, result, "The indices for target 10 should be [0, 1]");
    }

}
