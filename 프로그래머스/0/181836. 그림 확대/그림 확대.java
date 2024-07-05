class Solution {
    public String[] solution(String[] picture, int k) {
        int height = picture.length;
        int width = picture[0].length();
    
        String[] answer = new String[height * k];
    
        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < width; j++) {
                for (int l = 0; l < k; l++) {
                    sb.append(picture[i].charAt(j));
                }
            }
            
        for (int m = 0; m < k; m++) {
            answer[i * k + m] = sb.toString();
        }
    }
    
    return answer;
    }
}