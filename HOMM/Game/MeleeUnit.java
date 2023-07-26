package HOMM.Game;

public abstract class MeleeUnit extends BaseUnit {

    /**
     * Характеристики милишника
     * 
     * @param damage     - единицы урона
     * @param hp         - единицы здоровья
     * @param initiative - инициатива
     * @param speed      - кол-во клеток перемещения за ход
     */
    public MeleeUnit(String name, int[] damage, int hp, int initiative, int speed, int x, int y) {
        super(name, damage, hp, initiative, speed, x, y);
    }

    public void step() {
        attack();
    }

    public boolean attack() {
        BaseUnit enemy = findClosestUnit(getTeam().equals(Field.red) ? Field.blue : Field.red);
        if (super.state.equals("ready") && enemy != null) {
            if (moveTo(enemy)) {
                enemy.setHp(getDamage());
                System.out.println("Ударил по " + enemy.getName());
                super.state = "busy";
                return true;
            }
            System.out.println("Пошел в сторону "  + enemy.getName());
            super.state = "busy";
            return false;
        }
        System.out.println("Победили уже");
        return false;
    }

    public boolean moveTo(BaseUnit unit) {
        if (unit.getX() - getX() > 1) {
            if (Field.checkCoords(getX() + 1, getY())) setX(getX() + 1);
            return false;
        }
        if (getX() - unit.getX() > 1) {
            if (Field.checkCoords(getX() - 1, getY())) setX(getX() - 1);
            return false;
        }
        if (unit.getY() - getY() > 1) {
            if (Field.checkCoords(getX(), getY() + 1)) setY(getY() + 1);
            return false;
        }
        if (getY() - unit.getY() > 1) {
            if (Field.checkCoords(getX(), getY() - 1)) setY(getY() - 1);
            return false;
        }
        return true;
    }
}