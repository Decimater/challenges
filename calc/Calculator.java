import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {
  public static void main(String[] args) {
	  System.out.println(Calculator.evaluate("2 / 2 + 3 * 4 - 6")); // => 7
	  // Looking back at this the getOperatorFunction would probably be better off as a static hashmap
	  // instead of creating a new function each time, also I completed a level 3!!!!
  }
	
  public static Double evaluate(String expression) {
    List<String> parts = Arrays.stream(expression.split(" ")).collect(Collectors.toList());

    while (parts.size() > 1) {
        int indexOfOperator = getIndexNextOperator(parts);
        String operator = parts.get(indexOfOperator);
        Double firstOperand = Double.parseDouble(parts.get(indexOfOperator-1));
        Double secondOperand = Double.parseDouble(parts.get(indexOfOperator+1));
        Double result = getOperatorFunction(operator).apply(firstOperand, secondOperand);
        
        replaceWithResult(parts, indexOfOperator, result.toString());
    }
    
    Double myDouble = Double.parseDouble(parts.get(0));
	
	// Included as challenge expected a solution using javascript evalulate
    return BigDecimal.valueOf(myDouble)
                        .setScale(3, RoundingMode.HALF_UP)
                        .doubleValue();
  }
  
    public static BiFunction<Double, Double, Double> getOperatorFunction(String symbol) {
        switch (symbol) {
            case "+" : return (a,b) -> a+b;
            case "-" : return (a,b) -> a-b;
            case "/" : return (a,b) -> a/b;
            case "*" : return (a,b) -> a*b;
        }

        throw new IllegalArgumentException("Only supported ops are +-/*");
    }

    public static void replaceWithResult(List<String> expComponents, int operatorIndex, String replacementValue) {
        if (expComponents == null || expComponents.size() < 3) throw new IllegalArgumentException("Only binary operators supported");

        expComponents.remove(operatorIndex-1);expComponents.remove(operatorIndex-1);expComponents.remove(operatorIndex-1);
        expComponents.add(operatorIndex-1, replacementValue);
    }

    public static int getIndexNextOperator(List<String> anExpression) {
        String topLevel = "/*", bottomLevel = "-+";
        OptionalInt index = IntStream.range(0, anExpression.size())
                                        .filter(i -> topLevel.contains(anExpression.get(i)))
                                        .findFirst();

        if (!index.isPresent()) {
            index = IntStream.range(0, anExpression.size()).filter(i -> bottomLevel.contains(anExpression.get(i))).findFirst();
        }

        return index.getAsInt();
    }
}