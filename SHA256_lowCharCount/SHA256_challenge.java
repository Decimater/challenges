import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;

public class SHA256_challenge {
    public static void main(String[] args) {
	//"GoOutside", Cracker.crackSha256("b8c49d81cb795985c007d78379e98613a4dfc824381be472238dbd2f974e37ae", "deGioOstu"
        System.out.println(crackSha256("b8c49d81cb795985c007d78379e98613a4dfc824381be472238dbd2f974e37ae", "deGioOstu")); 
	//null, Cracker.crackSha256("f58262c8005bb64b8f99ec6083faf050c502d099d9929ae37ffed2fe1bb954fb", "abc"
	System.out.println(crackSha256("f58262c8005bb64b8f99ec6083faf050c502d099d9929ae37ffed2fe1bb954fb", "abc"));
    }

    static String crackSha256(String hash, String chars) {
      String upperCaseHash = hash.toUpperCase();
        for (String permutation : generatePermutations(chars)) {
          if (upperCaseHash.equals(getHash(permutation))) {
            return permutation;
          }
        }
        
        return null; 
    }
    
    public static Set<String> generatePermutations(String input) {
       Set<String> output = new HashSet<>();
       if (input.isEmpty()) return output;

       Character firstCharacter = input.charAt(0);

       if (input.length() > 1) {
           input = input.substring(1);

           Set<String> permSet = generatePermutations(input);

           for (String word : permSet) {
               for (int i = 0; i <= word.length(); i++) {
                   output.add(word.substring(0, i) + firstCharacter + word.substring(i));
               }
           }
       } else {
           output.add(firstCharacter.toString());
       }

       return output;
   }
   
   public static String getHash(String word) {
     try {
       return DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA-256").digest(word.getBytes("UTF-8")));
     } catch (Exception ex) {
       System.out.println("He is dead Jim!");
     }
     
     return "";
   }
}