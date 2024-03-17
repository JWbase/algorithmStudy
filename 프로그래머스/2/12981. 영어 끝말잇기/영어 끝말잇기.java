import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        String prevWord = words[0];
    
        HashSet<String> wordSet = new HashSet<>();
        wordSet.add(prevWord);
        
        for (int i = 1; i < words.length; i++) {
            
            if (
                words[i].charAt(0) != prevWord.charAt(prevWord.length() - 1) 
                || !wordSet.add(words[i])) {
            
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
            prevWord = words[i];
        }
        
        return new int[] {0, 0};
    }
}