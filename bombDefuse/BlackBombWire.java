public class BlackBombWire extends BombWire {
    @Override
    public boolean nextWireToCut(wireColours aWiresColour) {
        return aWiresColour != wireColours.WHITE &&
                aWiresColour != wireColours.GREEN &&
                aWiresColour != wireColours.ORANGE;
    }
}
