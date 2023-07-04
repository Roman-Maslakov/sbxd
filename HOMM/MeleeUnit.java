package HOMM;

public abstract class MeleeUnit extends BaseUnit{
    
    /**
     * Характеристики милишника
     * @param damage     - единицы урона
     * @param hp         - единицы здоровья
     * @param initiative - инициатива
     * @param speed      - кол-во клеток перемещения за ход
     */
    public MeleeUnit(int damage, int hp, int initiative, int speed){
        super(damage, hp, initiative, speed);
    }

    public void attack(BaseUnit unit) { unit.setHp(getDamage()); }
}