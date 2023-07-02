package HOMM;

public class Mage extends CasterUnit{
    
    public Mage() {

        super(9, 13, 2, 1, 15);
    }

    public void castSpell(BaseUnit unit) {
        if (setMana(getDamage())) {
            unit.setHp(getDamage());
        }
    }
}
