import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        int dictionaryIndex = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), dictionaryIndex++);
        }

        int i = 0;
        while (i < msg.length()) {
            String w = String.valueOf(msg.charAt(i));
            int nextIndex = i + 1;

            while (nextIndex <= msg.length() && dictionary.containsKey(msg.substring(i, nextIndex))) {
                w = msg.substring(i, nextIndex);
                nextIndex++;
            }

            result.add(dictionary.get(w));

            if (nextIndex <= msg.length()) {
                String wc = msg.substring(i, nextIndex);
                dictionary.put(wc, dictionaryIndex++);
            }

            i = nextIndex - 1;
        }

        int[] answer = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            answer[j] = result.get(j);
        }

        return answer;
    }
}