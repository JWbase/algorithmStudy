class Solution {
    public int solution(int[] arr) {
        int x = 0;
        while (true) {
            int[] next = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    next[i] = arr[i] / 2;
                } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                    next[i] = arr[i] * 2 + 1;
                } else {
                    next[i] = arr[i];
                }
            }
            if (areEqual(arr, next)) {
                return x;
            }
            arr = next;
            x++;
        }
    }

    private boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}