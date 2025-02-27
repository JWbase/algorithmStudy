class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int currentHealth = health;
        int lastAttackTime = attacks[attacks.length - 1][0];
        int attackIndex = 0;
        int consecutiveSuccess = 0;
        
        int castingTime = bandage[0];
        int healPerSecond = bandage[1];
        int bonusHeal = bandage[2];
        
        for (int time = 1; time <= lastAttackTime; time++) {
            if (attackIndex < attacks.length && time == attacks[attackIndex][0]) {
                currentHealth -= attacks[attackIndex][1];
                attackIndex++;
                consecutiveSuccess = 0;
                
                if (currentHealth <= 0) {
                    return -1;
                }
            } else {
                currentHealth += healPerSecond;
                consecutiveSuccess++;
                
                if (consecutiveSuccess == castingTime) {
                    currentHealth += bonusHeal;
                    consecutiveSuccess = 0;
                }
                
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }
        }
        
        return currentHealth;
    }
}