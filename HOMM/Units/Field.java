package HOMM.Units;

import java.util.ArrayList;
import java.util.Collections;

public class Field {

    public static ArrayList<BaseUnit> initiativeScale = new ArrayList<>();
    public static ArrayList<BaseUnit> red = new ArrayList<>();
    public static ArrayList<BaseUnit> blue = new ArrayList<>();
    public static BaseUnit[][] field = new BaseUnit[10][8]; // 10х8 клеток как в Героях 5))

    public static void addUnit(BaseUnit unit, ArrayList<BaseUnit> team) {
        field[unit.getX()][unit.getY()] = unit;
        initiativeScale.add(unit);
        team.add(unit);
        unit.setTeam(team.equals(red) ? red : blue);
    }

    public static String mapInfo() {
        String info = "\n На карте находятся: \n";
        for (BaseUnit[] units : field) {
            for (BaseUnit unit : units) {
                if (unit != null && unit.isAlive())
                    info += unit.getInfo();
            }
        }
        return info;
    }

    public static void battle() {
        Collections.sort(initiativeScale, ((o2, o1) -> o1.getInitiative() - o2.getInitiative()));
        while (checkTeams())
            for (BaseUnit unit : initiativeScale)
                unit.step();
    }

    public static boolean checkTeams() {
        boolean flag = false;
        for (BaseUnit unit : red)
            if (unit.isAlive())
                flag = true;
        if (flag == false) {
            System.out.println("Синие победили!");
            return flag; 
        }
        flag = false;
        for (BaseUnit unit : blue)
            if (unit.isAlive())
                flag = true;
        if (flag == false) {
            System.out.println("Красные победили!");
            return flag; 
        }
        return flag;
    }
}
