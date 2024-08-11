import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("\\},\\{");
        Arrays.sort(arr, (a, b) -> Integer.compare(a.length(), b.length()));
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (String str : arr) {
            String[] nums = str.split(",");
            for (String num : nums) {
                int number = Integer.parseInt(num);
                if (set.add(number)) {
                    result.add(number);
                }
            }
        }

        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}