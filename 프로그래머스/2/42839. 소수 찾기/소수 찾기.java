import java.util.HashSet;
import java.util.Set;

class Solution {
    
    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void generatePermutations(String prefix, String str, Set<Integer> resultSet) {
        int n = str.length();
        if (!prefix.equals("")) {
            resultSet.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++) {
            generatePermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), resultSet);
        }
    }

    public int solution(String numbers) {
        Set<Integer> numberSet = new HashSet<>();
        generatePermutations("", numbers, numberSet);

        int primeCount = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                primeCount++;
            }
        }

        return primeCount;
    }
}