package practice.website.array;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    // Execution time: 82000 nanoseconds
    // Memory used: 0 bytes
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int dp[][] = new int[strs.length][26];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                int index = strs[i].charAt(j) - 97;
                dp[i][index] = dp[i][index] + 1;
            }
        }
        int i = 0;
        int[] visited = new int[strs.length];
        while (i < dp.length) {
            if (visited[i] > 0) {
                i++;
                continue;
            }
            List<String> input = new ArrayList<>();
            input.add(strs[i]);
            visited[i] = 1;
            for (int j = i + 1; j < dp.length; j++) {
                if (visited[j] > 0) {
                    continue;
                }
                if (compare(dp, i, j)) {
                    visited[j] = 1;
                    input.add(strs[j]);
                }
            }
            res.add(input);
            i++;
        }
        return res;
    }

    public boolean compare(int[][] s, int i, int j) {
        for (int k = 0; k < 26; k++) {
            if (s[i][k] - s[j][k] != 0) {
                return false;
            }
        }
        return true;
    }

    // Execution time: 17298000 nanoseconds
    // Memory used: 126224 bytes
    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<Map<Character, Integer>, List<String>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++) {
                if (!map.containsKey(strs[i].charAt(j))) {
                    map.put(strs[i].charAt(j), 1);
                } else {
                    map.put(strs[i].charAt(j), map.get(strs[i].charAt(j)) + 1);
                }
            }
            if (!hm.containsKey(map)) {
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                hm.put(map, ls);
            } else {
                List<String> ls = hm.get(map);
                ls.add(strs[i]);
                hm.put(map, ls);
            }

        }
        List<List<String>> res = hm.entrySet().stream().map(val -> val.getValue()).collect(Collectors.toList());
        return res;

    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        GroupAnagrams g = new GroupAnagrams();
        String[] strs = new String[] { "act", "pots", "tops", "cat", "stop", "hat" };

        long startTime = System.nanoTime();

        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // List<List<String>> res = g.groupAnagrams(strs);
        List<List<String>> res2 = g.groupAnagrams2(strs);

        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        long memoryUsed = (usedMemoryAfter - usedMemoryBefore);

        System.out.println("Execution time: " + duration + " nanoseconds");
        System.out.println("Memory used: " + memoryUsed + " bytes");

        System.out.println(res2);

    }

}
