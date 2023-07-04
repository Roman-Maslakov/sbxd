package HOMM;

public abstract class CasterUnit extends BaseUnit {

    private int mana;

    /**
     * Характеристики кастера
     * @param damage     - единицы урона
     * @param hp         - единицы здоровья
     * @param initiative - инициатива
     * @param speed      - кол-во клеток перемещения за ход
     * @param mana       - кол-во маны
     */

    CasterUnit(int damage, int hp, int initiative, int speed, int mana) {
        super(damage, hp, initiative, speed);
        this.mana = mana;
    }

    public int getMana() { return this.mana; }

    protected boolean setMana(int cost) {
        if (this.mana > cost) {
            this.mana -= cost;
            return true;
        } else return false;
    }
}
