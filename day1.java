class LychrelCheck {
    public static void main(String[] args) {
        int n = 89;
        int k = 30;
        int[] result = findPalindrome(n, k);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    
    static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        return rev;
    }

    
    static boolean isPalindrome(int n) {
        return n == reverse(n);
    }

    
    static int[] findPalindrome(int n, int k) {
        for (int i = 1; i <= k; i++) {
            int sum = n + reverse(n);
            if (isPalindrome(sum)) {
                return new int[]{i, sum};
            }
            n = sum;
        }
        return new int[]{-1, -1}; 
    }
}
