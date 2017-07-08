public class Main {
    public static void main(String[] args) {
        String message = "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011";
        String decodedBits = MorseCodeDecoder.decodeBits(message);
        System.out.println(decodedBits);
        System.out.println(MorseCodeDecoder.decodeMorse(decodedBits));
   }
}