import java.util.*;

public class RackManagement {

    public static void main(String[] args) {
        System.out.println("Scrabble checker");
        System.out.println(scrabbleCheckerOne("ladilmy", "daily"));     //true
        System.out.println(scrabbleCheckerOne("orrpgma", "program"));   //true
        System.out.println(scrabbleCheckerOne("orppgma", "program"));   //false
        System.out.println(scrabbleCheckerOne("eerriin", "eerie"));     //false

        //bonus 1
        System.out.println("\nBonus One");
        System.out.println(scrabbleCheckerBonusOne("pizza??", "pizzazz")); //true
        System.out.println(scrabbleCheckerBonusOne("piizza?", "pizzazz")); //true
        System.out.println(scrabbleCheckerBonusOne("a??????", "program")); //false
        System.out.println(scrabbleCheckerBonusOne("b??????", "program")); //false         
    }

    public static boolean scrabbleCheckerBonusOne(String lettersAvailable,  String possibleWord) {
        if (possibleWord.length() > lettersAvailable.length()) return false;

        Map<Character, Integer> lettersAvailableMap = lettersAvailableMapMaker(lettersAvailable);
        Map<Character, Integer> possibleWordMap = lettersAvailableMapMaker(possibleWord);

        int amountOfWildCards = lettersAvailableMap.get('?') == null ? 0 : lettersAvailableMap.get('?');
        int amountMissing = 0;

        for (Character aLetter : possibleWordMap.keySet()) {
            if ( lettersAvailableMap.keySet().contains(aLetter)) {
                if ( lettersAvailableMap.get(aLetter) < possibleWordMap.get(aLetter)) {
                    amountMissing += possibleWordMap.get(aLetter) - lettersAvailableMap.get(aLetter);
                } else {
                    amountMissing += possibleWordMap.get(aLetter);
                }
            }
        }

        return amountMissing >= amountOfWildCards;
    }

    public static Map<Character, Integer> lettersAvailableMapMaker(String word) {
        Map<Character, Integer> lettersAvailableMap = new HashMap<>();

        for ( Character aLetter : word.toCharArray()) {
            if ( !lettersAvailableMap.keySet().contains(aLetter)) {
                lettersAvailableMap.put( aLetter, 1 );
            } else {
                lettersAvailableMap.put( aLetter, lettersAvailableMap.get(aLetter)+1);
            }
        }

        return lettersAvailableMap;
    }

    public static boolean scrabbleCheckerOne(String lettersAvailable, String possibleWord) {
        if (possibleWord.length() > lettersAvailable.length()) return false;
        
        Map<Character, Integer> lettersAvailableMap = lettersAvailableMapMaker(lettersAvailable);
        Map<Character, Integer> possibleWordMap = lettersAvailableMapMaker(possibleWord);


        // Initial check if possible word is possible by checking characters
        // Check characters with more than one instance
        if ( !lettersAvailableMap.keySet().containsAll( possibleWordMap.keySet() )) {
            return false;
        } else {
            for ( Character aLetter : possibleWordMap.keySet() ) {
                if ( lettersAvailableMap.get(aLetter) < possibleWordMap.get(aLetter)) {
                    return false;
                }
            }
        }

        return true;
    }
}