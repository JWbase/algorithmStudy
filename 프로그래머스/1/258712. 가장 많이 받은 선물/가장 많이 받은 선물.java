import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        HashMap<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nameToIndex.put(friends[i], i);
        }
        
        int[][] giftMap = new int[n][n];
        
        int[] given = new int[n];
        int[] received = new int[n];
        
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];
            
            int giverIdx = nameToIndex.get(giver);
            int receiverIdx = nameToIndex.get(receiver);
            
            giftMap[giverIdx][receiverIdx]++;
            given[giverIdx]++;
            received[receiverIdx]++;
        }
        
        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = given[i] - received[i];
        }
        
        int[] nextMonthGifts = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftMap[i][j] > giftMap[j][i]) {
                    nextMonthGifts[i]++;
                } else if (giftMap[i][j] < giftMap[j][i]) {
                    nextMonthGifts[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftIndex[i] < giftIndex[j]) {
                        nextMonthGifts[j]++;
                    }
                }
            }
        }
        
        int maxGifts = 0;
        for (int count : nextMonthGifts) {
            maxGifts = Math.max(maxGifts, count);
        }
        
        return maxGifts;
    }
}