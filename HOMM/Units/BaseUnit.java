package HOMM.Units;

import java.util.ArrayList;

public abstract class BaseUnit implements Interface{

    private int x, y;
    private String team;
    private String name;
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

    public BaseUnit(String name, int damage, int hp, int initiative, int speed, int x, int y) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
        this.initiative = initiative;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public String getName() { return this.name; }
    public int getHp() { return this.hp; }
    public int getDamage() { return this.damage; }
    public int getInitiative() { return this.initiative; }
    public int getSpeed() { return this.speed; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setTeam(String team) { this.team = team; }

    public void setHp(int dif) { this.hp -= dif; }

    public void waiting() {} // реализовать шкалу инициативы 

    public void step() {} // позже

    public String getInfo() {
        return String.format("Юнит: %s, Имя: %s, координаты х: %d y: %d, команда: %s \n", 
        getClass(), getName(), this.x, this.y, this.team)
        .replace("class HOMM.Units.", "");
    }

    public int getDistance(BaseUnit unit) { 
        return (int)(Math.ceil(Math.sqrt(Math.pow(unit.getX() - this.x, 2) + Math.pow(unit.getY() - this.y, 2)))); 
    }

    public BaseUnit findClosestEnemy() { 
        ArrayList<BaseUnit> teamEnemy = this.team.equals("Красных") ? Field.blueTeam : Field.redTeam;
        BaseUnit closest = teamEnemy.get(0);
        int minDistance = getDistance(closest);
        for (BaseUnit unit : teamEnemy) {
            if (minDistance > getDistance(unit)) {
                minDistance = getDistance(unit);
                closest = unit;
            }
        }
        return closest;
    }
}