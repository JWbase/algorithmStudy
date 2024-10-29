class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] scores = new int[26];
        
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            int choice = choices[i];
            
            if (choice < 4) {
                scores[disagree - 'A'] += 4 - choice;
            } else if (choice > 4) {
                scores[agree - 'A'] += choice - 4;
            }
        }
        
        StringBuilder result = new StringBuilder();
        result.append(scores['R' - 'A'] >= scores['T' - 'A'] ? 'R' : 'T');
        result.append(scores['C' - 'A'] >= scores['F' - 'A'] ? 'C' : 'F');
        result.append(scores['J' - 'A'] >= scores['M' - 'A'] ? 'J' : 'M');
        result.append(scores['A' - 'A'] >= scores['N' - 'A'] ? 'A' : 'N');
        
        return result.toString();
    }
}