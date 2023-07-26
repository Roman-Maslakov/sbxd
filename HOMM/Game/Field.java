package HOMM.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Field {

    public static ArrayList<BaseUnit> initiativeScale = new ArrayList<>();
    public static ArrayList<BaseUnit> red = new ArrayList<>();
    public static ArrayList<BaseUnit> blue = new ArrayList<>();
    public static BaseUnit[][] field = new BaseUnit[10][10];

    public static void addUnit(BaseUnit unit, ArrayList<BaseUnit> team) {
        if (field[unit.getX() - 1][unit.getY() - 1] == null) {
            field[unit.getX() - 1][unit.getY() - 1] = unit;
            initiativeScale.add(unit);
            team.add(unit);
            unit.setTeam(team.equals(red) ? red : blue);
        }
        else System.out.println("На клетке уже есть персонаж!");
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
        Scanner scanner = new Scanner(System.in);
        Collections.sort(initiativeScale, ((o2, o1) -> o1.getInitiative() - o2.getInitiative()));
        // int i = 0;
        while (checkTeams()) {
            View.view();
            scanner.nextLine();
            // System.out.println("Ход номер " + ++i + "\n");
            for (BaseUnit unit : initiativeScale) {
                if (unit.isAlive()) {
                    System.out.println("\nХодит " + unit.getName() + " " + unit.getNameTeam() + " хп: " + unit.getHp());
                    unit.step();
                }
            }
            System.out.println("\n");
        }
    }

    public static boolean checkTeams() {
        boolean flag = false;
        for (BaseUnit unit : blue)
            if (unit.isAlive()) {
                unit.state = "ready";
                flag = true;
            }
        if (flag == false) {
            System.out.println("Красные победили!");
            return flag;
        }
        flag = false;
        for (BaseUnit unit : red)
            if (unit.isAlive()) {
                unit.state = "ready";
                flag = true;
            }
        if (flag == false) {
            System.out.println("Синие победили!");
            return flag;
        }
        return flag;
    }

    public static boolean checkCoords(int x, int y) {
        for (BaseUnit unit : initiativeScale) {
            if (unit.isAlive() && unit.getX() == x && unit.getY() == y) return false;
        }
        return true;
    }
}
