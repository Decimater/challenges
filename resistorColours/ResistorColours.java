import java.util.HashMap;
import java.util.Map;

public class ResistorColours {
    public static void main(String[] args) {
        Map<String, Integer> colourBandValues = new HashMap<>();
        colourBandValues.put("black", 0);
        colourBandValues.put("brown", 1);
        colourBandValues.put("red", 2);
        colourBandValues.put("orange", 3);
        colourBandValues.put("yellow", 4);
        colourBandValues.put("green", 5);
        colourBandValues.put("blue", 6);
        colourBandValues.put("violet", 7);
        colourBandValues.put("gray", 8);
        colourBandValues.put("white", 9);
        colourBandValues.put("silver", 10);
        colourBandValues.put("gold" , 5);

        String bands = "brown black green";
        String[] someBands = bands.split(" ");
        String ohmsString = "" + colourBandValues.get(someBands[0]) + colourBandValues.get(someBands[1]);
        for (int i = 0; i < colourBandValues.get(someBands[2]); i++ ) { ohmsString += "0"; }

        int ohms = Integer.parseInt(ohmsString);
        if ( ohms >= 1000000) {
            if (ohms % 1000000 == 0) {
                ohmsString = ohms / 1000000 + "M";
            } else {
                ohmsString = "" + ohms / 1000000 + ".";
                ohms %= 1000000;
                ohmsString += ohms / 100000;
            }
        } else if ( ohms >= 1000) {
            if (ohms % 1000 == 0) {
                ohmsString = ohms / 1000 + "K";
            } else {
                ohmsString = "" + ohms / 1000 + ".";
                ohms %= 1000;
                ohmsString += ohms / 100 + "K";
            }
        }

        ohmsString += " ohms";
        if (someBands.length == 3) {
            ohmsString += ", 20%";
        } else if (someBands[3].equals("gold")) {
            ohmsString += ", " + colourBandValues.get(someBands[3]) + "%";
        } else {
            ohmsString += ", " + colourBandValues.get("silver") + "%";
        }
        System.out.println(ohmsString);
    }

}