import java.util.*;

public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
      List<String> mLetters = new LinkedList<>();

        bits = bits.replaceAll("\\b0+|0+\\b", "");
        char changeChar = bits.charAt(0);
        StringBuilder word = new StringBuilder();

        for (Character digit : bits.toCharArray()) {
            if (changeChar == digit) {
                word.append(digit);
            } else {
                mLetters.add(word.toString());
                word = new StringBuilder();
                word.append(digit);
                changeChar = digit;
            }
        }

        mLetters.add(word.toString());

        int timeUnit = mLetters.stream()
                      .mapToInt(String::length)
                      .min().getAsInt();

        StringBuilder output = new StringBuilder();
        for (String aLetter : mLetters) {
            if (aLetter.contains("1")) {
                if (aLetter.length() <= 2*timeUnit) {
                    output.append(".");
                } else {
                    output.append("-");
                }
            } else {
                if (aLetter.length() == 3*timeUnit) {
                    output.append(" ");
                } else if (aLetter.length() > 3*timeUnit){
                    output.append("   ");
                }
            }
        }

        return output.toString().trim();
    }
    
    public static String decodeMorse(String morseCode) {
      StringBuilder output = new StringBuilder();
      
      for (String word : morseCode.split("   ")) {
        for (String mLetter : word.split(" ")) {
            output.append(MorseCode.get(mLetter));
        }
        output.append(" ");
      }
      
      return output.toString().trim();
    }

    public static Map<String, String> MorseCode = new HashMap<>();
    static {
        MorseCode.put(".", "E");
        MorseCode.put("....", "H");
        MorseCode.put("-.--", "Y");
        MorseCode.put(".---", "J");
        MorseCode.put("..-", "U");
        MorseCode.put("-..", "D");
    }
}