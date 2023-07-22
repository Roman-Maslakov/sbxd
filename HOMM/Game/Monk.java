package HOMM.Game;

import java.util.ArrayList;

public class Monk extends CasterUnit {

    public Monk(String name, int x, int y) {

        super(name, new int[] { 5, 8 }, 41, 6, 4, 75, x, y);
    }

    @Override
    public boolean cast() {
        int spellCost = getDamage();
        BaseUnit ally = findWeakestUnit(getTeam().equals(Field.red) ? Field.red : Field.blue);
        if (super.state.equals("ready") && ally != null && setMana(spellCost)) {
            if (ally.state.equals("dead")) {
                ally.state = "ready";
                System.out.println("Воскрешает " + ally.getName());
            }
            else System.out.println("Лечит " + ally.getName());
            ally.setHp(-spellCost);
            super.state = "busy";
            return true;
        }
        System.out.println("Нет манны");
        return false;
    }

    public BaseUnit findWeakestUnit(ArrayList<BaseUnit> team) {
        BaseUnit weakest = null;
        int maxInjury = 0;
        for (BaseUnit unit : team) {
            if (unit.state.equals("dead")) {
                return unit;
            }
            if (maxInjury < unit.getMaxHp() - unit.getHp()) {
                maxInjury = unit.getMaxHp() - unit.getHp();
                weakest = unit;
            }
        }
        return weakest;
    }
}
