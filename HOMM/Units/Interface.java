package HOMM.Units;

public interface Interface {
    
    void step();

    String getInfo();

    void waiting();

    void setX(int x);

    void setY(int y);

    void setHp(int dif);

    BaseUnit findClosestEnemy();
}
