package HOMM.Game;

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
        BaseUnit enemy = findClosestUnit(getTeam().equals(Field.red) ? Field.blue : Field.red);
        if (state.equals("ready") && haveShots() && enemy != null) {
            enemy.setHp(getDamage());
            if (peasantHere()) {
                System.out.println("Выстрелов - > " + this.shots + " стреляет по " + enemy.getName());
                state = "busy";
                return true;
            }
            System.out.println("Выстрелов - > " + this.shots + " стреляет по " + enemy.getName());
            this.shots--;
            state = "busy";
            return true;
        }
        System.out.println("Нет стрел");
        return false;
    }

    public boolean peasantHere() {
        for (BaseUnit unit : getTeam()) {
            if (unit.state.equals("ready") && unit instanceof Peasant) {
                unit.state = "busy";
                return true;
            }
        }
        return false;
    }
}