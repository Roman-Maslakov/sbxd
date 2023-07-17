package HOMM.Units;

public class Peasant extends MeleeUnit {

    public Peasant(String name, int x, int y) {

        super(name, new int[] { 1, 2 }, 10, 3, 3, x, y);
    }

    public void giveAnArrow(RangeUnit unit) {
        unit.setShots(1);
    }
}
