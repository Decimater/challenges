public class Main {
    public static void main(String[] args) {
	    String sequence1 = "white\n" +
                "red\n" +
                "green\n" +
                "white";

	    String sequence2 = "white\n" +
                "orange\n" +
                "green\n" +
                "white";

	    defuseTheBomb(sequence1);
        System.out.println();
        defuseTheBomb(sequence2);
    }

    public static BombWire.wireColours[] splitTextIntoWireColours(String sequenceToSplit) {
        String[] separateColours = sequenceToSplit.split("\n");
        BombWire.wireColours[] wireColours = new BombWire.wireColours[separateColours.length];

        for (int i = 0; i < separateColours.length; i++) {
            switch (separateColours[i]) {
                case "white" : wireColours[i] = BombWire.wireColours.WHITE;
                break;
                case "red" : wireColours[i] = BombWire.wireColours.RED;
                break;
                case "black" : wireColours[i] = BombWire.wireColours.BLACK;
                break;
                case "orange" : wireColours[i] = BombWire.wireColours.ORANGE;
                break;
                case "green" : wireColours[i] = BombWire.wireColours.GREEN;
                break;
                case "purple" : wireColours[i] = BombWire.wireColours.PURPLE;
            }
        }

        return wireColours;
    }

    public static BombWire bombWireColourInstance( BombWire.wireColours colour) {
        switch (colour) {
            case WHITE: return new WhiteBombWire();
            case RED: return new RedBombWire();
            case BLACK: return new BlackBombWire();
            case ORANGE: return new OrangeBombWire();
            case GREEN: return new GreenBombWire();
            case PURPLE: return new PurpleBombWire();
            default: return new WhiteBombWire();
        }
    }

    public static void defuseTheBomb(String someWires) {
        BombWire.wireColours[] defuseAttemptOne = splitTextIntoWireColours(someWires);

        boolean isDefusing = true;
        for (int i = 0; i < defuseAttemptOne.length-1 && isDefusing; i++) {
            BombWire aBombWire = bombWireColourInstance(defuseAttemptOne[i]);
            isDefusing = aBombWire.nextWireToCut(defuseAttemptOne[i+1]);
        }

        if (isDefusing)
            System.out.printf("Bomb defused!");
        else
            System.out.println("Boom");
    }
}