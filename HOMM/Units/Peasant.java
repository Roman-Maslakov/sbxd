package HOMM.Units;

public class Peasant extends MeleeUnit{

    public Peasant(String name, int x, int y) {
        
        super(name, 1, 10, 3, 3, x, y);
    }

    public void giveAnArrow(RangeUnit unit) { unit.setShots(1); }
}
