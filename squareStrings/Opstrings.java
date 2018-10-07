import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.UnaryOperator;

class Opstrings {
    
    public static String vertMirror (String strng) {
        return Arrays.stream(strng.split("\n"))
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .collect(Collectors.joining("\n"));
    }
    public static String horMirror (String strng) {
        List<String> output = Arrays.asList(strng.split("\n"));
        Collections.reverse(output);
        return output.stream().collect(Collectors.joining("\n"));
    }
    public static String oper(UnaryOperator<String> operator, String s) {
        return operator.apply(s);
    }
}