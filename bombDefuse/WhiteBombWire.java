public class WhiteBombWire extends BombWire {
    public boolean nextWireToCut(wireColours aWiresColour) {
        return aWiresColour != wireColours.WHITE && aWiresColour != wireColours.BLACK;
    }
}