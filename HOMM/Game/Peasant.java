package HOMM.Game;

import java.util.ArrayList;

public class Peasant extends MeleeUnit {

    public Peasant(String name, int x, int y) {
        super(name, new int[] { 1, 2 }, 7, 10, 5, x, y);
    }

    public void step() {
        giveAnArrow();
    }

    public void giveAnArrow() {
        if (state.equals("ready")) {
            System.out.println("Дал стрелу " + findClosestArcher().getName());
            findClosestArcher().setShots(1);
            state = "busy";
        }
        else System.out.println("Занят");
    }

    public RangeUnit findClosestArcher() {
        ArrayList<BaseUnit> teamAlly = getTeam().equals(Field.red) ? Field.red : Field.blue;
        RangeUnit closest = null;
        int minDistance = 13; // максимальная дистанция на поле +1
        for (BaseUnit unit : teamAlly) {
            if (unit instanceof RangeUnit) {
                if (unit.isAlive() && minDistance > getDistance(unit)) {
                    minDistance = getDistance(unit);
                    closest = (RangeUnit) unit;
                }
            }
        }
        return closest;
    }
}
