public class PurpleBombWire extends BombWire {
    @Override
    public boolean nextWireToCut(wireColours aWiresColour) {
        return aWiresColour != wireColours.PURPLE &&
                aWiresColour != wireColours.GREEN &&
                aWiresColour != wireColours.ORANGE &&
                aWiresColour != wireColours.WHITE;
    }
}