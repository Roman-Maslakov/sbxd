package HOMM;
 
public abstract class BaseUnit {

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

    public void setHp(int dif) { this.hp -= dif; }

    public void move() {} // если реализовать игровое поле, может двумерный массив? 

    public void waiting() {} // реализовать шкалу инициативы 
}