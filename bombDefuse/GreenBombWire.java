public class GreenBombWire extends BombWire {
    @Override
    public boolean nextWireToCut(wireColours aWiresColour) {
        return aWiresColour == wireColours.ORANGE || aWiresColour == wireColours.WHITE;
    }
}
