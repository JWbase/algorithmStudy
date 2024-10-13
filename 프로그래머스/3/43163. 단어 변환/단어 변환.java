import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        Queue<WordNode> queue = new LinkedList<>();
        queue.offer(new WordNode(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while (!queue.isEmpty()) {
            WordNode node = queue.poll();
            String currentWord = node.word;
            int level = node.level;
            
            if (currentWord.equals(target)) {
                return level;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canTransform(currentWord, words[i])) {
                    visited[i] = true;
                    queue.offer(new WordNode(words[i], level + 1));
                }
            }
        }
        
        return 0;
    }
    
    private static boolean canTransform(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
    
    static class WordNode {
        String word;
        int level;
        
        WordNode(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}