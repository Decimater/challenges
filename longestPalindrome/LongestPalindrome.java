public class LongestPalindrome {
    public static void main(String[] args) {
	System.out.println(longestPalindrome("123"));
	System.out.println(longestPalindrome("a121z"));
    }

    private static int longestPalindrome(final String s) {
      if (s == null || s.isEmpty()) return 0;
        char[] inputArray = s.toCharArray();

        for (int maxLength = s.length(); maxLength > 1; maxLength--) {
            int maxStartIndex = s.length()-maxLength;
            for (int i = 0; i <= maxStartIndex; i++) {
                if(isPalindromeByIndex(inputArray, i, i+maxLength-1)) {
                    return maxLength;
                }
            }
        }
        
        return 1;
    }
    
    private static boolean isPalindromeByIndex(char[] anArray, int beginIndex, int endIndex) {

        int midpoint = ((endIndex - beginIndex) / 2) + beginIndex;
        for (int i = beginIndex; i <= midpoint; i++) {
            int backwardIndex = endIndex - (i - beginIndex);

            if (anArray[i] != anArray[backwardIndex]) {
                return false;
            }
        }

        return true;
    }
}