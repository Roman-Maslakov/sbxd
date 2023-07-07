package HOMM.Units;

public class Mage extends CasterUnit{
    
    public Mage(String name, int x, int y) {

        super(name, 9, 13, 2, 1, 15, x, y);
    }

    public void castSpell(BaseUnit unit) {
        if (setMana(getDamage())) {
            unit.setHp(getDamage());
        }
    }
}
