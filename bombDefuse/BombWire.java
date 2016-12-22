public abstract class BombWire {
    enum wireColours {
        WHITE, RED, BLACK, ORANGE, GREEN, PURPLE
    }

    public abstract boolean nextWireToCut(wireColours aWiresColour);
}
