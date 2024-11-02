class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possibleWords = {"aya", "ye", "woo", "ma"};
        
        for (String word : babbling) {
            if (containsRepeatedPronunciation(word)) {
                continue;
            }

            String temp = word;

            for (int i = 0; i < possibleWords.length; i++) {
                temp = temp.replace(possibleWords[i], String.valueOf(i));
            }

            boolean isValid = true;
            for (char c : temp.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean containsRepeatedPronunciation(String word) {
        return word.contains("ayaaya") || 
               word.contains("yeye") || 
               word.contains("woowoo") || 
               word.contains("mama");
    }
}