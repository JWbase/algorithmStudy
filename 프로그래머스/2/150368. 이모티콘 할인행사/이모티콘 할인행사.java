import java.util.*;

class Solution {
    private int maxPlusSubscribers = 0;
    private int maxSales = 0;
    private final int[] discountRates = {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length];
        findBestDiscount(0, discounts, users, emoticons);
        
        return new int[]{maxPlusSubscribers, maxSales};
    }
    
    private void findBestDiscount(int depth, int[] discounts, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            calculateResult(discounts, users, emoticons);
            return;
        }
        
        for (int rate : discountRates) {
            discounts[depth] = rate;
            findBestDiscount(depth + 1, discounts, users, emoticons);
        }
    }
    
    private void calculateResult(int[] discounts, int[][] users, int[] emoticons) {
        int plusSubscribers = 0;
        int totalSales = 0;
        
        for (int[] user : users) {
            int userDiscountRate = user[0];
            int userMaxCost = user[1];
            
            int userSpending = 0;
            
            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= userDiscountRate) {
                    int discountedPrice = emoticons[i] * (100 - discounts[i]) / 100;
                    userSpending += discountedPrice;
                }
            }
            
            if (userSpending >= userMaxCost) {
                plusSubscribers++;
            } else {
                totalSales += userSpending;
            }
        }
        
        if (plusSubscribers > maxPlusSubscribers || 
            (plusSubscribers == maxPlusSubscribers && totalSales > maxSales)) {
            maxPlusSubscribers = plusSubscribers;
            maxSales = totalSales;
        }
    }
}