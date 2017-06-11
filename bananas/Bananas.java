import java.time.Duration;
import java.time.Instant;


public class Bananas {
   public static void main(String[] args) {
       Instant timer = Instant.now();

       System.out.println(BCalc.bananas("bnnbnnaanbabn"));
       System.out.println(BCalc.bananas("bnnnaannanaaaanb"));
       System.out.println(BCalc.bananas("bbnnnnbnnnnannn"));
       System.out.println(BCalc.bananas("bnbbnnnanaaab"));
       System.out.println(BCalc.bananas("bbaanaaannananabnn"));

       System.out.println("Runtime :" + Duration.between(timer, Instant.now()));

       timer = Instant.now();

       System.out.println(BCalc.testCalc("bnnbnnaanbabn"));
       System.out.println(BCalc.testCalc("bnnnaannanaaaanb"));
       System.out.println(BCalc.testCalc("bbnnnnbnnnnannn"));
       System.out.println(BCalc.testCalc("bnbbnnnanaaab"));
       System.out.println(BCalc.testCalc("bbaanaaannananabnn"));

       System.out.println("Runtime :" + Duration.between(timer, Instant.now()));

   }

}