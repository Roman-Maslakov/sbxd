package HOMM.Units;

import java.util.ArrayList;

public class Field {

    public static ArrayList<BaseUnit> redTeam = new ArrayList<>();
    public static ArrayList<BaseUnit> blueTeam = new ArrayList<>();

    public static BaseUnit[][] field = new BaseUnit[10][8]; // 10х8 клеток как в Героях 5))
    
    public static void addUnit(BaseUnit unit, ArrayList<BaseUnit> team) {
        field[unit.getX()][unit.getY()] = unit;
        team.add(unit);
        unit.setTeam(team.equals(redTeam) ? "Красных" : "Синих");
    }

    public static String getMapInfo() {
        String info = "На карте находятся: \n";
        for (BaseUnit[] units : field) {
            for (BaseUnit unit : units) {
                if (unit != null) { info += unit.getInfo(); }
            }
        }
        return info;
    }
}
