package HOMM.Units;

public abstract class MeleeUnit extends BaseUnit{
    
    /**
     * Характеристики милишника
     * @param damage     - единицы урона
     * @param hp         - единицы здоровья
     * @param initiative - инициатива
     * @param speed      - кол-во клеток перемещения за ход
     */
    public MeleeUnit(String name, int damage, int hp, int initiative, int speed, int x, int y){
        super(name, damage, hp, initiative, speed, x, y);
    }

    public void attack(BaseUnit unit) { unit.setHp(getDamage()); }
}