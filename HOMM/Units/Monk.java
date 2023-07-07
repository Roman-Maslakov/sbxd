package HOMM.Units;

public class Monk extends CasterUnit{
    
    public Monk(String name, int x, int y) {

        super(name, 7, 15, 3, 1, 20, x, y);
    }

    public void healSpell(BaseUnit unit) {
        if (setMana(getDamage())) {
            unit.setHp(-getDamage());
        }
    }
}
