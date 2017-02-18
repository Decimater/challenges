import java.util.HashMap;
import java.util.Map;

public class SpellWithChemistry {
    private static Map<String, String> elements = new HashMap<>();
    private static void populateElements() {
        elements.put("Ge","Germanium");
        elements.put("Ni","Nickel");
        elements.put("U","Uranium");
        elements.put("S","Sulfur");
        elements.put("test","dummy");
        elements.put("Ba","Barium");
        elements.put("Co","Cobalt");
        elements.put("N","Nitrogen");
    }

    public static void main(String[] args) {
        // genius -> GeNiUS (germanium nickel uranium sulfur)
        populateElements();
        System.out.println(spellWithChem("genius"));
        System.out.println(spellWithChem("bacon"));
    }

    public static String spellWithChem(String word) {
        StringBuilder output = new StringBuilder(), chunk;
        int endOfWord = word.length()-1;
        for (int i = 0; i <= endOfWord; i+=2) {
            chunk = new StringBuilder();
            chunk.append(Character.toUpperCase(word.charAt(i)));

            if (i != endOfWord) chunk.append(word.charAt(i+1));

            if (elements.keySet().contains(chunk.toString())) {
                output.append(chunk);
            } else {
                output.append(Character.toUpperCase(word.charAt(i)));
                i--;
            }
        }
        return output.toString();
    }
}
