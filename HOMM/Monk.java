package HOMM;

public class Monk extends CasterUnit{
    
    public Monk() {

        super(7, 15, 3, 1, 20);
    }

    public void healSpell(BaseUnit unit) {
        if (setMana(getDamage())) {
            unit.setHp(-getDamage());
        }
    }
}
