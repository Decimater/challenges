public class NegativeZeroValidator {
    public static void main(String[] args) {
	System.out.println(isNegativeZero(-0f));
	System.out.println(isNegativeZero(0f));
    }

    public static boolean isNegativeZero(float n) {
        return new Float(n).equals(-0.0f);
    }
}