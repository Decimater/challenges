import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.AbstractMap.SimpleEntry;

public class PredictiveContactList {
    private static final Map<String, String> KEY_LETTERS = Collections.unmodifiableMap(Stream.of(
            new SimpleEntry<>("2", "ABC"),
            new SimpleEntry<>("3", "DEF"),
            new SimpleEntry<>("4", "GHI"),
            new SimpleEntry<>("5", "JKL"),
            new SimpleEntry<>("6", "MNO"),
            new SimpleEntry<>("7", "PQRS"),
            new SimpleEntry<>("8", "TUV"),
            new SimpleEntry<>("9", "WXYZ"))
            .collect(Collectors.toMap(SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue))
    );


    public static void main(String[] args) {
        List<String> inputContacts = Arrays.asList(
                "jones", "thompson", "brown", "taylor",
                "bow", "smith", "cox", "timmons"
        );
        String keystrokes = "2";

        System.out.println(predict(inputContacts, keystrokes)); // brown, bow, cox

        keystrokes = "269";

        System.out.println(predict(inputContacts, keystrokes)); // bow and cox
    }

    public static List<String> predict(List<String> contacts, String keystrokes) {
        if (keystrokes == null || keystrokes.isEmpty()) return contacts;

        String regex = Arrays.stream(keystrokes.split(""))
                .map(s -> "[" + KEY_LETTERS.get(s).toLowerCase() + "]")
                .collect(Collectors.joining()).concat(".*\\b");

        return contacts.stream().filter(s -> s.matches(regex)).collect(Collectors.toList());
    }

}
