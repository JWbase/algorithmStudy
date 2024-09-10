import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            char transformedChar = transformCharacter(ch, skipSet, index);
            result.append(transformedChar);
        }

        return result.toString();
    }

    char transformCharacter(char ch, Set<Character> skipSet, int index) {
        int steps = 0;
        char currentChar = ch;

        while (steps < index) {
            currentChar++;
            if (currentChar > 'z') {
                currentChar = 'a';
            }
            if (!skipSet.contains(currentChar)) {
                steps++;
            }
        }

        return currentChar;
    }
}