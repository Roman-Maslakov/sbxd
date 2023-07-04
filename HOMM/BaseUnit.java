package HOMM;
 
public abstract class BaseUnit implements Interface{

    private int damage; 
    private int hp; 
    private int initiative;
    private int speed;

    /**
     * Характеристики юнита
     * @param damage - единицы урона
     * @param hp - единицы здоровья
     * @param initiative - инициатива
     * @param speed - кол-во клеток перемещения за ход
     */

    public BaseUnit(int damage, int hp, int initiative, int speed) {
        this.damage = damage;
        this.hp = hp;
        this.initiative = initiative;
        this.speed = speed;
    }

    public int getHp() { return this.hp; }
    public int getDamage() { return this.damage; }
    public int getInitiative() { return this.initiative; }
    public int getSpeed() { return this.speed; }

    protected void setHp(int dif) { this.hp -= dif; }

    public void waiting() {} // реализовать шкалу инициативы 

    public void step() {}

    public String getInfo() {
        return String.format("Юнит: %s", getClass()).replace("class HOMM.", "");
    }
}