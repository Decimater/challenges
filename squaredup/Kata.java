public class Kata {
    public static int[] squareUp(int n) {
        int[] output = new int[n * n];
        
        for (int i = 1; i <= n; i++) {
          for (int j = n * i - i; j < output.length; j += n) {
            output[j] = i;
          }
        }
               
        return output;
    }
}