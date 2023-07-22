package HOMM.Game;

import java.util.ArrayList;

public class Mage extends CasterUnit {

    public Mage(String name, int x, int y) {

        super(name, new int[] { 4, 11 }, 31, 7, 4, 50, x, y);
    }

    @Override
    public boolean cast() {
        int spellCost = getDamage();
        BaseUnit enemy = findStrongestUnit(getTeam().equals(Field.red) ? Field.blue : Field.red);
        if (super.state.equals("ready") && enemy != null && setMana(spellCost)) {
            System.out.println("Кастует по " + enemy.getName());
            enemy.setHp(spellCost);
            super.state = "busy";
            return true;
        }
        System.out.println("Нет манны");
        return false;
    }

    public BaseUnit findStrongestUnit(ArrayList<BaseUnit> team) {
        BaseUnit strongest = null;
        int maxHp = 0;
        for (BaseUnit unit : team) {
            if (unit.isAlive() && maxHp < unit.getHp()) {
                maxHp = unit.getHp();
                strongest = unit;
            }
        }
        return strongest;
    }
}
