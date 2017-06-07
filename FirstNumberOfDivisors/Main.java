import java.time.Duration;
import java.time.Instant;

public class Main {
   public static void main(String[] args) {
       System.out.println(MinNbDiv.findMinNum(1));
       System.out.println(MinNbDiv.findMinNum(8));
       System.out.println(MinNbDiv.findMinNum(7));
       System.out.println(MinNbDiv.findMinNum(9));
       System.out.println(MinNbDiv.findMinNum(6));

       System.out.println("\nStart timer");
       Instant start = Instant.now();
       System.out.println(MinNbDiv.findMinNum(80));
       Instant finish = Instant.now();

       System.out.println("Time of first calculation "+ Duration.between(start, finish));

       start = Instant.now();

       System.out.println(MinNbDiv.findMinNum(80));
       System.out.println(MinNbDiv.findMinNum(80));
       System.out.println(MinNbDiv.findMinNum(80));
       System.out.println(MinNbDiv.findMinNum(80));

       finish = Instant.now();

       System.out.println("Time of further calculation "+ Duration.between(start, finish));
   }

}