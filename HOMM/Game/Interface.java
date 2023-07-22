package HOMM.Game;

import java.util.ArrayList;

public interface Interface {

    void step();

    String getInfo();

    void setX(int x);

    void setY(int y);

    BaseUnit findClosestUnit(ArrayList<BaseUnit> team);
}
