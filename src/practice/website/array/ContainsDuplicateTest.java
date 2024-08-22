package practice.website.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainsDuplicateTest {

    public boolean containsDuplicates(int[] arr) {
        if (arr.length == 0)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int val : arr) {
            set.add(val);
        }
        if (arr.length != set.size()) {
            return true;
        }
        return false;
    }

    @Test
    public void testNoDuplicates() {
        int[] arr = { 1, 2, 3, 4, 5 };
        assertFalse(containsDuplicates(arr), "Array with no duplicates should return false");
    }

    @Test
    public void testWithDuplicates() {
        int[] arr = { 1, 2, 3, 4, 4 };
        assertTrue(containsDuplicates(arr), "Array with duplicates should return true");
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        assertFalse(containsDuplicates(arr), "Empty array should return false");
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = { 1 };
        assertFalse(containsDuplicates(arr), "Array with one element should return false");
    }

    @Test
    public void testLargeArrayWithDuplicates() {
        int[] arr = new int[1000];
        Arrays.fill(arr, 1); // Filling the array with 1s
        assertTrue(containsDuplicates(arr), "Large array with all elements the same should return true");
    }

    @Test
    public void testLargeArrayWithoutDuplicates() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i;
        }
        assertFalse(containsDuplicates(arr), "Large array with unique elements should return false");
    }
}
