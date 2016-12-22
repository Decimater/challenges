public class RedBombWire extends BombWire{
    @Override
    public boolean nextWireToCut(wireColours aWiresColour) {
        return aWiresColour == wireColours.GREEN;
    }
}