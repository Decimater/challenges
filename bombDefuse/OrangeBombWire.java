public class OrangeBombWire extends BombWire {
    @Override
    public boolean nextWireToCut(wireColours aWiresColour) {
        return aWiresColour == wireColours.RED || aWiresColour == wireColours.BLACK;
    }
}