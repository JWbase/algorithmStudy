import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minKeyPress = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            for (int j = 0; j < key.length(); j++) {
                char ch = key.charAt(j);
                int keyPress = j + 1;
                if (minKeyPress.containsKey(ch)) {
                    minKeyPress.put(ch, Math.min(minKeyPress.get(ch), keyPress));
                } else {
                    minKeyPress.put(ch, keyPress);
                }
            }
        }

        int[] result = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalKeyPress = 0;
            boolean isPossible = true;

            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);
                if (minKeyPress.containsKey(ch)) {
                    totalKeyPress += minKeyPress.get(ch);
                } else {
                    isPossible = false;
                    break;
                }
            }

            result[i] = isPossible ? totalKeyPress : -1;
        }

        return result;
    }
}