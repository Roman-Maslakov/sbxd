package HOMM.Units;

public abstract class RangeUnit extends BaseUnit {

    private int shots;

    /**
     * Характеристики стрелкового юнита
     * @param damage     - единицы урона
     * @param hp         - единицы здоровья
     * @param initiative - инициатива
     * @param speed      - кол-во клеток перемещения за ход
     * @param shots      - кол-во выстрелов
     */

    public RangeUnit(String name, int damage, int hp, int initiative, int speed, int shots, int x, int y) {

        super(name, damage, hp, initiative, speed, x, y);
        this.shots = shots;
    }

    public int getShots() {
        return this.shots;
    }

    public void setShots(int dif) {
        this.shots += dif;
    }

    public void shoot(BaseUnit unit) {
        if (this.shots > 0) {
            unit.setHp(getDamage());
            this.shots--;
        }
    }
}