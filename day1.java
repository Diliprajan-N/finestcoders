class LychrelCheck {
    public static void main(String[] args) {
        long n = 89;
        int k = 30;
        long[] result = findPalindrome(n, k);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    static long reverse(long n) {
        long rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        return rev;
    }

    static long[] findPalindrome(long n, int k) {
        for (int i = 1; i <= k; i++) {
            long sum = n + reverse(n);
            if (sum == reverse(sum)) {
                return new long[]{i, sum};
            }
            n = sum;
        }
        return new long[]{-1, -1};
    }
}
