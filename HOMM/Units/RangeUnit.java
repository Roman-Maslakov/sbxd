package HOMM.Units;

public abstract class RangeUnit extends BaseUnit {

    private int shots;

    /**
     * Характеристики стрелкового юнита
     * 
     * @param damage     - единицы урона
     * @param hp         - единицы здоровья
     * @param initiative - инициатива
     * @param speed      - кол-во клеток перемещения за ход
     * @param shots      - кол-во выстрелов
     */

    public RangeUnit(String name, int[] damage, int hp, int initiative, int speed, int shots, int x, int y) {

        super(name, damage, hp, initiative, speed, x, y);
        this.shots = shots;
    }

    public int getShots() {
        return this.shots;
    }

    public boolean haveShots() {
        return this.shots > 0 ? true : false;
    }

    public void setShots(int dif) {
        this.shots += dif;
    }

    public void step() {
        shoot();
    }

    public void shoot(BaseUnit unit) {
    }

    public boolean shoot() {
        BaseUnit enemy = findClosestEnemy();
        if (isAlive() && haveShots() && enemy != null) {
            enemy.setHp(getDamage());
            if (peasantHere())
                return true;
            this.shots--;
            return true;
        }
        return false;
    }

    public boolean peasantHere() {
        for (BaseUnit unit : getTeam()) {
            if (unit instanceof Peasant)
                return true;
        }
        return false;
    }
}